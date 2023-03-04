package io.syd.aum.ucore.cache;

import java.util.concurrent.*;


/**
 * 拓展 org.apache.commons.lang3.concurrent.Memoizer 实现，增加重新生成缓存的功能，compute(final I arg, boolean reCompute)
 *
 * @param <I>
 * @param <O>
 */
public class Memoizer<I, O> implements Computable<I, O> {

    private final ConcurrentMap<I, Future<O>> cache = new ConcurrentHashMap<>();
    private final Computable<I, O> computable;
    private final boolean recalculate;

    public Memoizer(final Computable<I, O> computable) {
        this(computable, false);
    }

    public Memoizer(final Computable<I, O> computable, final boolean recalculate) {
        this.computable = computable;
        this.recalculate = recalculate;
    }

    @Override
    public O compute(final I arg) throws InterruptedException {
        while (true) {
            Future<O> future = cache.get(arg);
            if (future == null) {
                final Callable<O> eval = () -> computable.compute(arg);
                final FutureTask<O> futureTask = new FutureTask<>(eval);
                future = cache.putIfAbsent(arg, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (final CancellationException e) {
                cache.remove(arg, future);
            } catch (final ExecutionException e) {
                if (recalculate) {
                    cache.remove(arg, future);
                }

                throw launderException(e.getCause());
            }
        }
    }

    //不能直接继承 apache 的 Memoizer，cache 是私有的
    public void removeCache(final I arg) throws InterruptedException {
        // compute 已经保证了可以只计算一次，这里只要直接删除
        cache.remove(arg);
    }


    private RuntimeException launderException(final Throwable throwable) {
        if (throwable instanceof RuntimeException) {
            return (RuntimeException) throwable;
        } else if (throwable instanceof Error) {
            throw (Error) throwable;
        } else {
            throw new IllegalStateException("Unchecked exception", throwable);
        }
    }
}
