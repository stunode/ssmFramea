package com.quartztask.service;

import com.quartztask.entity.ScheduleJob;

import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface IScheduleJobService {
    /**
     *function：获取所有任务
    */
    List<ScheduleJob> getAllJobList();

    /**
     * function：获取指定任务
     */
    ScheduleJob getJobById(Long id);

    void updateByPrimaryKeySelective(ScheduleJob job);

    /**
     *function：新建调度任务
    */
    void insertSelective(ScheduleJob job);
}
