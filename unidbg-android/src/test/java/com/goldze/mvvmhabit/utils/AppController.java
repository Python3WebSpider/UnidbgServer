package com.goldze.mvvmhabit.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    NativeUtils utils = new NativeUtils();

    @RequestMapping("/encrypt")
    public Map<String, String> encrypt(String string, int offset) {
        String token = utils.encrypt(string, offset);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }
}
