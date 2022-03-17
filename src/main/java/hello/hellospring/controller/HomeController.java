package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")    //그냥 localhost:8080 으로 들어오면
    public String home() {
        return "home";  // home.html로 연결
    }
}
