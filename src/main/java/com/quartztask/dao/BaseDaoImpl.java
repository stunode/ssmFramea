package com.quartztask.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *  dao的基类<br> 
 * 〈功能详细描述〉
 *
 * @author allways
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseDaoImpl implements IBaseDao {

    /**
     * 由开发者提供查询count的sql
     */
    private static final int SELF_COUNT_SQL = 2;

    private Log log = LogFactory.getLog(BaseDaoImpl.class);

    /**
     * 一次性返回客户端的最大的记录条数
     */
    protected static final int MAX_RETURN_NUM =2000;

    @Autowired
    protected SqlSessionTemplate sqlSession;

    @Override
    public int insert(String sqlId, Object param) {
        return sqlSession.insert(sqlId, param);
    }

    @Override
    public int update(String sqlId, Object param) {
        return sqlSession.update(sqlId, param);
    }

    @Override
    public int delete(String sqlId, Object param) {
        return sqlSession.delete(sqlId, param);
    }

    @Override
    public <T> List<T> queryList(String sqlId, Object param) {
        return sqlSession.selectList(sqlId, param);
    }

    @Override
    public <T> T queryForObject(String sqlId, Object param) {
        return sqlSession.selectOne(sqlId, param);
    }



    /**
     * <p>
     * Description: 查询记录总数
     * </p>
     * 
     * @param sqlId mybatis的sqlId
     * @param param 参数
     * @return 记录总数
     */
    private int getSqlCount(String sqlId, Map<String, Object> param) {
        int totalCount = 0;
        Connection connection = null;
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            MappedStatement mappedStatement = sqlSession.getConfiguration().getMappedStatement(sqlId);
            BoundSql boundSql = mappedStatement.getBoundSql(param);
            connection = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
            String countSql = "select count(0) from (" + boundSql.getSql() + ") tmp";

            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            rs = countStmt.executeQuery();

            if (rs != null && rs.next()) {
                totalCount = rs.getInt(1);
            }

        } catch (SQLException e) {
            log.error("close the statement of sqlCount failed!");
        } finally {
            try {
                if(countStmt != null) {
                    countStmt.close();
                }
            } catch (SQLException e) {
                log.info("close the statement of sqlCount failed!");
            }
            try {
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                log.info("close the resultSet of sqlCount failed!");
            }
            try {
                if(connection != null) connection.close();
            } catch (SQLException e) {
                log.info("close the connection of sqlCount failed!");
            }
        }
        return totalCount;
    }

    /**
     * <p>
     * Description: 对PreparedStatement设置参数
     * </p>
     * 
     * @param ps PreparedStatement
     * @param mappedStatement mappedStatement
     * @param boundSql boundSql
     * @param parameterObject parameterObject
     * @throws SQLException 异常
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
            Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }


    @Override
    public <T> T queryObjectById(String sqlId, Object param) {
        return sqlSession.selectOne(sqlId, param);
    }

    @Override
    public Long getCount(String sqlId, Object param) {
        return sqlSession.selectOne(sqlId, param);
    }

}
