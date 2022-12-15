package com.example.authenticatingldap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restrict")
public class RestrictController {
    @GetMapping
    public String restrict () {
        return "restrict";
    }
}
