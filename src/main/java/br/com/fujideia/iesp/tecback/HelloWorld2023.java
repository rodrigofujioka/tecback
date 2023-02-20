package br.com.fujideia.iesp.tecback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld2023 {

    @GetMapping
    public String hello(){
        return "Hello Postman";
    }
}
