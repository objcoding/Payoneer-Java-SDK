package com.objcoding.pay.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by chenghui.zhang on 2017/9/19.
 */
@SpringBootApplication
public class PayDemoApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PayDemoApp.class).web(true).run(args);
    }
}


