package com.fengcheyun.workflow;

import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActivitiController {
    @Autowired
    private RepositoryService repositoryService;


    @RequestMapping("/")
    @ResponseBody
    public String home() {
        System.out.print(repositoryService);
        return "Hello World!";
    }



}