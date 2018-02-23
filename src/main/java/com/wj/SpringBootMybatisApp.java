package com.wj;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.wj.log.Log;
import com.wj.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wangjun
 * @date 18-2-9 上午11:11
 * @description
 * @modified by
 */

@SpringBootApplication
public class SpringBootMybatisApp extends WebMvcConfigurerAdapter {
    private static Logger logger = LoggerFactory.getLogger(SpringBootMybatisApp.class);

    public static void main(String args[]) {
        SpringApplication.run(SpringBootMybatisApp.class, args);
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1.需要先定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteMapNullValue);

        // 3.在converter中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);

        // 4.将converter赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastConverter;

        // 5.返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }
}
