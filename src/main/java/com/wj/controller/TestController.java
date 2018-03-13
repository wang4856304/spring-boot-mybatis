package com.wj.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjun
 * @date 18-2-9 下午3:33
 * @description
 * @modified by
 */

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @RequestMapping("/test")
    public Object test() {
        return buildSuccessJson("hello world");
    }
}
