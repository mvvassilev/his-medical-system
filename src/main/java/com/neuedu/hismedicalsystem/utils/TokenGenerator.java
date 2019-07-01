package com.neuedu.hismedicalsystem.utils;

import org.springframework.stereotype.Component;

@Component
public interface TokenGenerator {

    public String generate(String... strings);

}
