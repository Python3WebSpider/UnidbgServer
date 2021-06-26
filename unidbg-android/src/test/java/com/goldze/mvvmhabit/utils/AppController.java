package com.goldze.mvvmhabit.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    @RequestMapping("/encrypt")
    public Map<String, String> encrypt(String plaintext, int offset) {
        String token = NativeUtils.call(plaintext, offset);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }
}
