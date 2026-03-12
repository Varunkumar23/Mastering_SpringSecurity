package com.lpu.SpringSecurityBasic.controller;

import com.lpu.SpringSecurityBasic.entity.Cricketer;
import com.lpu.SpringSecurityBasic.service.CricketerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cricketers")
@RequiredArgsConstructor
public class CricketerController {

    private final CricketerService cricketerService;

    @GetMapping("/greet")
    public String greetCricketrs(){
        return "Hello Cricketers!";
    }

    @PostMapping
    public Cricketer saveCricketer(@RequestBody Cricketer cricketer) {
        return cricketerService.saveCricketer(cricketer);
    }

    @GetMapping("/{id}")
    public Cricketer getCricketerById(@PathVariable int id) {
        return cricketerService.getCricketerById(id);
    }

    // Get all cricketers
    @GetMapping
    public List<Cricketer> getAllCricketers() {
        return cricketerService.getAllCricketers();
    }
}
