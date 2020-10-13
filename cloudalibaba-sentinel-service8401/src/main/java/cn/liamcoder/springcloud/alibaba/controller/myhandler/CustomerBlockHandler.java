package cn.liamcoder.springcloud.alibaba.controller.myhandler;

import cn.liamcoder.springcloud.entities.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;


public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "客户自定义，global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "客户自定义，global handlerException---2");
    }
}
