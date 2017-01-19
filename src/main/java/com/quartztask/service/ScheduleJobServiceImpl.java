package com.quartztask.service;

import com.quartztask.dao.BaseDaoImpl;
import com.quartztask.entity.ScheduleJob;
import com.quartztask.taskService.JobTaskService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 获取数据库中的所有定时任务
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends BaseDaoImpl implements IScheduleJobService {
    @Autowired
    private JobTaskService jobTaskService;
    @Override
    public List<ScheduleJob> getAllJobList() {
        return queryList("scheduleJob.getAll", null);
    }

    @Override
    public ScheduleJob getJobById(Long id) {
        return queryObjectById("scheduleJob.selectByPrimaryKey",id);
    }

    @Override
    public void updateByPrimaryKeySelective(Long jobId, String cmd) {
        try {
            ScheduleJob job = getJobById(jobId);
            if (job == null) {
                return;
            }
            if ("stop".equals(cmd)) {
                jobTaskService.deleteJob(job);
                job.setJobStatus(ScheduleJob.STATUS_NOT_RUNNING);
            } else if ("start".equals(cmd)) {
                job.setJobStatus(ScheduleJob.STATUS_RUNNING);
                jobTaskService.addJob(job);
            }
            update("scheduleJob.updateByPrimaryKey", job);
            System.out.println("状态改变完成!");
        } catch (SchedulerException e) {
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }

    @Override
    public void insertSelective(ScheduleJob job) {
        insert("scheduleJob.insertSelective", job);
    }
}
