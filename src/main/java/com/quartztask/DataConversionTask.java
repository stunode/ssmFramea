package com.quartztask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataConversionTask {
    /** 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(DataConversionTask.class);
    public void run() {
        if (LOG.isInfoEnabled()) {
            LOG.info("数据转换任务线程开始执行");
        }
    }

    public void initScheduleJob(){
        System.out.println("========================initScheduleJob===========================");
    }
}
