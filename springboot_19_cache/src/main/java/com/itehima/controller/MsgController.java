package com.itehima.controller;

import com.itehima.domain.Book;
import com.itehima.service.BookService;
import com.itehima.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @GetMapping("{telephone}")
    public String get(@PathVariable String telephone){
        return msgService.get(telephone);
    }

    @PostMapping
    public boolean save(String telephone,String code){
        return msgService.check(telephone,code);
    }


}
