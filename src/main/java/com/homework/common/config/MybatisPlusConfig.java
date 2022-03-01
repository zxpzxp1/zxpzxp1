/**
 * (C) Copyright Company 2018. All rights reserved.
 * 文件名：MybatisPlusConfig
 * 版 本：1.0
 * 内容简述：Mybatis Plus配置
 * 创建日期：2018.09.12-13:00:13
 * 创建人：陈玉麟
 * 修改记录：
 * 日期  版本  修改人  修改内容
 */
package com.homework.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    /**
     * 设置分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
