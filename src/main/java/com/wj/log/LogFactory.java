package com.wj.log;

/**
 * @author wangjun
 * @date 18-2-9 下午5:31
 * @description
 * @modified by
 */
public class LogFactory {

    public static Log getLogger(Class clazz) {
        Log log = new Log(clazz);
        return log;
    }

    public static Log getLogger(String name) {
        Log log = new Log(name);
        return log;
    }
}
