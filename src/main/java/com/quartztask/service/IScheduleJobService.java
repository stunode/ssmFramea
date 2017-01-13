package com.quartztask.service;

import com.quartztask.entity.ScheduleJob;

import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface IScheduleJobService {
    List<ScheduleJob> getAllJobList();
}
