package com.fengcheyun.workflow;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by xuxiaokang on 2017/4/24.
 */

//@EnableAutoConfiguration(exclude = {
//org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
//org.activiti.spring.boot.SecurityAutoConfiguration.class,
//org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
//})

@Configuration
@ComponentScan
@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude = {
//        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
//        org.activiti.spring.boot.SecurityAutoConfiguration.class
////        ,org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
//})
public class ActivitiApplication {


    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class, args);
    }
    @Bean
    public CommandLineRunner init(final RepositoryService
                                              repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
//                repositoryService.createDeployment().addClasspathResource("processes/joinProcess.bpmn20.xml").deploy();
//                System.out.println("Number of process definitions : "
//                        + repositoryService.createProcessDefinitionQuery().count());
//                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//                runtimeService.startProcessInstanceByKey("oneTaskProcess");
//                System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
            }
        };

    }
    
    @Bean 
     CommandLineRunner seedUsersAndGroups(final IdentityService identityService) { 
         return new CommandLineRunner() { 
             @Override 
             public void run(String... strings) throws Exception { 
 
 
//                 // install groups & users 
//                 Group group = identityService.newGroup("user"); 
//                 group.setName("users"); 
//                 group.setType("security-role"); 
//                 identityService.saveGroup(group); 
// 
//                 User joram = identityService.newUser("jbarrez"); 
//                 joram.setFirstName("Joram"); 
//                 joram.setLastName("Barrez"); 
//                 joram.setPassword("password"); 
//                 identityService.saveUser(joram); 
// 
//                 User josh = identityService.newUser("jlong"); 
//                 josh.setFirstName("Josh"); 
//                 josh.setLastName("Long"); 
//                 josh.setPassword("password"); 
//                 identityService.saveUser(josh); 
// 
// 
//                 identityService.createMembership("jbarrez", "user"); 
//                 identityService.createMembership("jlong", "user"); 
             } 
         }; 
    } 

//         @Configuration 
//         static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter { 
//             protected void configure(HttpSecurity http) throws Exception { 
//                 http 
//                         .antMatcher("/api/**") 
//                         .authorizeRequests() 
//                         .anyRequest().authenticated() 
//                         .and() 
//                         .httpBasic(); 
//             } 
//         } 

}
