package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")    // URI의 hello라고 입력하면 이 함수랑 매칭시킴.
    public String hello(Model model) {
        model.addAttribute("data", "hello, Spring!");
        return "hello"; // viewResolver가 hello.html을 찾아서 처리한다.
    }

    // @ResponseBody가 있으면 viewResolver 대신 HttpMessageConverter가 동작함.
    // 문자, 객체 등에 따라 다른 Converter가 동작한다.

    // 문자 반환
    @GetMapping("hello-string")
    @ResponseBody   // viewResolver를 사용하지 않음. HTTP의 BODY에 문자 내용을 직접 반환
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // 객체 반환
    @GetMapping("hello-api")
    @ResponseBody   // 객체를 반환하면 객체가 JSON으로 변환됨
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


