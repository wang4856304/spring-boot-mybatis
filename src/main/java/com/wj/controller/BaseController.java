package com.wj.controller;

import com.alibaba.fastjson.JSONObject;
import com.wj.SpringBootMybatisApp;
import com.wj.entity.Response;
import com.wj.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangjun
 * @date 18-2-23 下午2:33
 * @description
 * @modified by
 */
public abstract class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    public Object buildSuccessJson() {
        Response response = new Response();
        response.setCode(ResultEnum.SUCCESS.getCode());
        response.setMsg(ResultEnum.SUCCESS.getMsg());
        logger.info("response:" + JSONObject.toJSONString(response));
        return response;
    }

    public Object buildSuccessJson(Object data) {
        Response response = new Response();
        response.setCode(ResultEnum.SUCCESS.getCode());
        response.setMsg(ResultEnum.SUCCESS.getMsg());
        response.setData(data);
        logger.info("response:" + JSONObject.toJSONString(response));
        return response;
    }
}
