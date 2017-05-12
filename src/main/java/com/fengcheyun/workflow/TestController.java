package com.fengcheyun.workflow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private HistoryService historyService;

    @RequestMapping("/test")
    @ResponseBody
    public String home() throws IOException {
//    	ProcessInstance pi = runtimeService.startProcessInstanceByKey("oneTaskProcess");
//
//        ProcessDefinitionEntity definition = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(pi.getProcessDefinitionId());
//
//        BpmnModel bpmnModel = repositoryService.getBpmnModel(pi.getProcessDefinitionId());
//
//        ProcessDiagramGenerator pdg = new DefaultProcessDiagramGenerator();
//        if (bpmnModel.getLocationMap().size() == 0) {
//            BpmnAutoLayout autoLayout = new BpmnAutoLayout(bpmnModel);
//            autoLayout.execute();
//        }
//        List<Task> list = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
//        for(Task task :list) {
//        	
//        	taskService.complete(task.getId());
//        }
//       
//        List<HistoricActivityInstance> activitis =  historyService.createHistoricActivityInstanceQuery().processInstanceId(pi.getId()).finished().list();
//        List<String> hlacts = new ArrayList<>();
//        activitis.forEach(act->{hlacts.add(act.getActivityId());});
//        List<String> highlightflows = new ArrayList<>();
//        getHighLightedFlows(definition.getActivities(),highlightflows,hlacts);
//
//        InputStream is = pdg.generateDiagram(bpmnModel,"png",hlacts,highlightflows);
//        
//        
//        FileOutputStream fos =new FileOutputStream(new File("/Users/baidu/test.png"));
//        IOUtils.copy(is,fos);
//        fos.flush();
//        fos.close();
//        is.close();
//        System.out.println("ddddeeeyyddd");
        return "Hello World test!";
    }

    private void getHighLightedFlows(List<ActivityImpl> activityList,
                                     List<String> highLightedFlows,
                                     List<String> historicActivityInstanceList) {
        for (ActivityImpl activity : activityList) {
            if (activity.getProperty("type").equals("subProcess")) {
                // get flows for the subProcess
                getHighLightedFlows(activity.getActivities(), highLightedFlows,
                        historicActivityInstanceList);
            }

            if (historicActivityInstanceList.contains(activity.getId())) {
                List<PvmTransition> pvmTransitionList = activity
                        .getOutgoingTransitions();
                for (PvmTransition pvmTransition : pvmTransitionList) {
                    String destinationFlowId = pvmTransition.getDestination()
                            .getId();
                    if (historicActivityInstanceList
                            .contains(destinationFlowId)) {
                        highLightedFlows.add(pvmTransition.getId());
                    }
                }
            }
        }
    }

}