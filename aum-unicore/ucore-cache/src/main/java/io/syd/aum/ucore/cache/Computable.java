package io.syd.aum.ucore.cache;

/**
 * <p>Definition of an interface for a wrapper around a calculation that takes a single parameter and returns a result.</p>
 *
 * <p>This interface allows for wrapping a calculation into a class so that it maybe passed around an application.</p>
 *
 * @param <I> the type of the input to the calculation
 * @param <O> the type of the output of the calculation
 * @since 3.6
 */
public interface Computable<I, O> {

    /**
     * This method carries out the given operation with the provided argument.
     *
     * @param arg the argument for the calculation
     * @return the result of the calculation
     * @throws InterruptedException thrown if the calculation is interrupted
     */
    O compute(I arg) throws InterruptedException;
}