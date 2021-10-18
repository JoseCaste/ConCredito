package com.ancabe.concredito;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SampleEncode {
    public static void main (String [] args){
        System.out.println("encode "+new BCryptPasswordEncoder().encode("12345"));
    }
}
