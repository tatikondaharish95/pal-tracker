package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String welcome_message = "hello default";

    public WelcomeController(@Value("${welcome.message}") String welcome_message) {
        this.welcome_message = welcome_message;
    }

    @RequestMapping("/")
    public String sayHello() {
        return welcome_message;
    }
}
