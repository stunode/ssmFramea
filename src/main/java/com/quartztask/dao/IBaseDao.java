package com.quartztask.dao;


import java.util.List;

/**
 * <p>ClassName: IBaseDao</p>
 * <p>Description: dao基类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-6-16</p>
 */
public interface IBaseDao {
    
    /**
     * <p>Description: 插入记录</p>
     * @param sqlId
     * @param param
     */
    int insert(String sqlId, Object param);
    
    /**
     * <p>Description: 更新记录</p>
     * @param sqlId
     * @param param
     */
    int update(String sqlId, Object param);
    
    /**
     * <p>Description: 删除记录</p>
     * @param sqlId 
     * @param param
     */
    int delete(String sqlId, Object param);
    
    /**
     * <p>Description: 根据主键查询记录</p>
     * @param sqlId
     * @param param
     */
    <T> T queryObjectById(String sqlId, Object param);
    
    /**
     * <p>Description: 查询记录列表</p>
     * @param sqlId
     * @param param
     */
    <T> List<T> queryList(String sqlId, Object param);
    
    /**
     * 查询单个对象
     * @param sqlId
     * @param param
     */
    <T> T queryForObject(String sqlId, Object param);

    /**
     * 功能描述: 得到记录数量<br>
     * 〈功能详细描述〉
     *
     * @param sqlId
     * @param param
     * @return
     */
    Long getCount(String sqlId, Object param);
}
