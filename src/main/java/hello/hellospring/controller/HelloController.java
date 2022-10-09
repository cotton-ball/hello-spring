package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러 어노테이션을 적어주어야 한다
public class HelloController {

    @GetMapping("hello")//웹 어플리케이션에서 hello 라고 들어오면 아래 메서드를 호출함
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // hello -> value
        return "hello";
    }

    @GetMapping("hello-mvc") //웹에서 파라미터를 받음
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http : header/body 이렇게 있는데 내가 바디를 직접 넣어 주겠다.
    public  String helloSting(@RequestParam("name")String name){
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public  Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
