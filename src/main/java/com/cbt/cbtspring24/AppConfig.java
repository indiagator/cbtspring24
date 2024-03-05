package com.cbt.cbtspring24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public MyNumber getMyNumber()
    {
        MyNumber number =  new MyNumber();
        number.setI(76);
        return number;
    }

    @Bean
    public BCryptPasswordEncoder getEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Scope("prototype")
    public MyNumber getMyNumber2()
    {
        MyNumber number =  new MyNumber();
        number.setI(89);
        return number;
    }

}
