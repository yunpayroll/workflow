package com.fengcheyun;

import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActivitiController {
    @Autowired
    private RepositoryService repositoryService;


    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        System.out.print(repositoryService);
        return "Hello World home!";
    }



}