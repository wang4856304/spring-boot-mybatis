package com.wj.exception;

import com.wj.entity.Response;
import com.wj.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wangjun
 * @date 18-2-9 下午4:01
 * @description 统一异常处理
 * @modified by
 */

@RestControllerAdvice
public class ControllerAdvice {

    private static final String code = ResultEnum.FAIL.getCode();
    private static Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception ex) {
        Response response = new Response();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException)ex;
            if (StringUtils.isEmpty(businessException.getErrCode())) {
                response.setCode(businessException.getErrCode());
            }
            else {
                response.setCode(code);
            }
            response.setMsg(businessException.getMessage());
        }
        else {
            response.setCode(code);
            response.setMsg(ex.getMessage());
        }
        logger.error(ex.getMessage(), ex);
        return response;
    }
}
