package com.quartztask.service;

import com.quartztask.dao.BaseDaoImpl;
import com.quartztask.entity.ScheduleJob;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 获取数据库中的所有定时任务
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends BaseDaoImpl implements IScheduleJobService {
    @Override
    public List<ScheduleJob> getAllJobList() {
        return queryList("scheduleJob.getAll", null);
    }
}