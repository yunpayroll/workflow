package com.fengcheyun.workflow;

import ch.qos.logback.core.rolling.helper.FileStoreUtil;
import ch.qos.logback.core.util.FileUtil;
import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.ArrayList;

@Controller
public class TestController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/test")
    @ResponseBody
    public String home() throws IOException {
        ProcessDefinition
                processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("joinProcess")
                .list().get(0);
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinition.getId());


        ProcessDiagramGenerator pdg = new DefaultProcessDiagramGenerator();
        if (bpmnModel.getLocationMap().size() == 0) {
            BpmnAutoLayout autoLayout = new BpmnAutoLayout(bpmnModel);
            autoLayout.execute();
        }

        InputStream is = pdg.generatePngDiagram(bpmnModel);
        File f = new File("/Users/baidu/test.png");
        FileOutputStream fos =new FileOutputStream(f);
        IOUtils.copy(is,fos);
        fos.flush();
        fos.close();
        is.close();
        System.out.println("ddddddd");
        return "Hello World !";
    }



}