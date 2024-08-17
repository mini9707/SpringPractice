package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

@Controller
public class ShopController {
    @GetMapping("/")
    String hello() {
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about() {
        return "피싱사이트에용";
    }

    @GetMapping("/date")
    @ResponseBody
    String date() {
        return LocalDateTime.now().toString();
    }
}