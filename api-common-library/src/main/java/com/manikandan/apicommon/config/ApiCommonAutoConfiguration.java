package com.manikandan.apicommon.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@ConditionalOnWebApplication
@ComponentScan(basePackages = "com.manikandan.apicommon")
public class ApiCommonAutoConfiguration {
}