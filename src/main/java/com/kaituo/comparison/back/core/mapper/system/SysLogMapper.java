package com.kaituo.comparison.back.core.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaituo.comparison.back.core.entity.system.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 2018/4/28/9:56
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

    /**
     * DTO传参
     *
     * @param sysLog
     * @return
     */
    List<SysLog> selectLogByDto(SysLog sysLog);


    /**
     * 注解传参
     *
     * @param username
     * @param uri
     * @return
     */
    List<SysLog> selectLogByParam(@Param("username") String username, @Param("uri") String uri);


    /**
     * mybatis  foreach 标签
     *
     * @param listUserNames
     * @return
     */
    List<SysLog> selectLogByUserNames(@Param("listUserNames") List<String> listUserNames);


    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteLogById(@Param("id") String id);


    /**
     * 批量插入
     *
     * @param sysLogs
     * @return
     */
    int insertLogBatch(@Param("sysLogs") List<SysLog> sysLogs);


}
