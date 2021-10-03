package com.itheima.config;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.itheima")
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@Import({JDBCConfig.class,MyBatisConfig.class})
public class SpringConfig {

}
