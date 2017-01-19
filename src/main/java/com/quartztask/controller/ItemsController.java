package com.quartztask.controller;

import com.quartztask.entity.ScheduleJob;
import com.quartztask.service.IScheduleJobService;
import com.quartztask.service.ScheduleJobServiceImpl;
import com.quartztask.taskService.JobTaskService;
import com.quartztask.util.ResultMapObj;
import com.quartztask.util.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * function：调度系统控制页面
 */
@Controller
@RequestMapping("/task")
public class ItemsController {

    @Autowired
    private JobTaskService taskService;
    @Autowired
    private IScheduleJobService scheduleJobService;

    /**
     * function：初始化页面列表
     */
    @RequestMapping("/taskList")
    public String taskList(HttpServletRequest request) {
        List<ScheduleJob> taskList = taskService.getAllTask();
        request.setAttribute("taskList", taskList);
        return "taskList";
    }

    /**
     * function：改变任务状态
     */
    @RequestMapping("/changeJobStatus")
    public
    @ResponseBody
    String changeJobStatus(HttpServletRequest request, Long jobId, String cmd) {
        ResultMapObj resultMap = new ResultMapObj();
        resultMap.setFlag(false);
        try {
//            taskService.changeStatus(jobId, cmd);
            scheduleJobService.updateByPrimaryKeySelective(jobId, cmd);
            resultMap.setMsg("状态改变成功！");
            resultMap.setFlag(true);
            return resultMap.toJson();
        } catch (RuntimeException e) {
            e.printStackTrace();
            resultMap.setMsg("任务状态改变失败！");
            return resultMap.toJson();
        }
    }

    /**
     * function：增加调度任务
     */
    @RequestMapping("add")
    @ResponseBody
    public String addTask(HttpServletRequest request, ScheduleJob scheduleJob) {
        ResultMapObj resultMapObj = new ResultMapObj();
        resultMapObj.setFlag(false);

        //验证输入cronExpress是否有误
        try {
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
        } catch (Exception e) {
            resultMapObj.setMsg("cron表达式有误！");
            resultMapObj.setFlag(true);
            return resultMapObj.toJson();
        }
        //验证调度实现是否存在，首先验证是否为注册到pring中的bean，如果没有则通过反射获得
        Object obj = null;
        try {
            if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
                obj = SpringUtils.getBean(scheduleJob.getSpringId());
            } else {
                Class clazz = Class.forName(scheduleJob.getBeanClass());
                obj = clazz.newInstance();
            }
        } catch (Exception e) {
            // do nothing.........
        }
        if (obj == null) {
            resultMapObj.setMsg("未找到目标类！");
            return resultMapObj.toJson();
        } else {
            Class clazz = obj.getClass();
            Method method = null;
            try {
                method = clazz.getMethod(scheduleJob.getMethodName(), null);
            } catch (Exception e) {
                // do nothing.....
            }
            if (method == null) {
                resultMapObj.setMsg("未找到目标方法！");
                return resultMapObj.toJson();
            }
        }
        taskService.addTask(scheduleJob);
        resultMapObj.setMsg("任务增加成功！");
        resultMapObj.setFlag(true);
        return resultMapObj.toJson();

    }
}
