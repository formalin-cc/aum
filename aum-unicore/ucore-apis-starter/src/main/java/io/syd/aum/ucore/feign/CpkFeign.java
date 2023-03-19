package io.syd.aum.ucore.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 远程调用主键生成服务
 * @program: aum
 * @author: yc
 * @date: 2023-03-19 22:08
 **/
@FeignClient(name = "bserver-cpk"
//        , url = "127.0.0.1:12011"
)
public interface CpkFeign {

    @RequestMapping(value = "cpk/genId", method = RequestMethod.GET)
    long genId();

    @RequestMapping(value = "cpk/genId", method = RequestMethod.GET)
    long genId(@RequestParam String key);

    @RequestMapping(value = "cpk/genIds", method = RequestMethod.GET)
    long[] genIds(@RequestParam int size);

    @RequestMapping(value = "cpk/genIds", method = RequestMethod.GET)
    long[] genIds(@RequestParam int size, @RequestParam String key);
}