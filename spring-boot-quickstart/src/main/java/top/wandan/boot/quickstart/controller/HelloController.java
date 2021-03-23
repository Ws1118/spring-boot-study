package top.liekai.boot.quickstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2021/3/23
 * @description HelloController
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping()
    public String getHello(String name){
        return  "helloword";
    }
}