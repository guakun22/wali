package com.guakun22.robot.wali.controller;

import com.guakun22.robot.wali.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private AtomicLong counter = new AtomicLong();

    @GetMapping("/v1/greeting")
    public Greeting sayHi(
            @RequestParam("name") String name) {

        return new Greeting(
                counter.incrementAndGet(),
                String.format("Hello, %s", name)
        );
    }

}
