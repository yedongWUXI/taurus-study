package com.kaituo.comparison.back.core.controller;

import com.kaituo.comparison.back.common.bean.ResponseCode;
import com.kaituo.comparison.back.common.bean.ResponseResult;
import com.kaituo.comparison.back.core.entity.system.SysLog;
import com.kaituo.comparison.back.core.mapper.system.SysLogMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2020/2/13 17:14
 * @Modified by:
 */
@RestController
@Api(tags = {"mybatis动态sql"})
@RequestMapping(value = {"/common"})
public class CommonControl {

    @Autowired
    SysLogMapper sysLogMapper;


    @GetMapping(value = "/cors")
    public String cors() {
        return "cors success";
    }


    @PostMapping("/selectLogByDto")
    @ApiOperation("Dto传参")
    public ResponseResult selectLogByDto(@RequestBody SysLog sysLog) {
        List<SysLog> sysLogs = sysLogMapper.selectLogByDto(sysLog);

        return ResponseResult.e(ResponseCode.OK, sysLogs);
    }


    @PostMapping("/selectLogByParam")
    @ApiOperation("注解传参")
    public ResponseResult selectLogByParam(@RequestBody SysLog sysLog) {
        String username = sysLog.getUsername();

        String uri = sysLog.getUri();

        List<SysLog> sysLogs = sysLogMapper.selectLogByParam(username, uri);

        return ResponseResult.e(ResponseCode.OK, sysLogs);
    }


    @PostMapping("/selectLogByUserNames")
    @ApiOperation("mybatis  foreach标签 ")
    public ResponseResult selectLogByUserNames(@RequestBody List<String> listUserNames) {


        List<SysLog> sysLogs = sysLogMapper.selectLogByUserNames(listUserNames);

        return ResponseResult.e(ResponseCode.OK, sysLogs);
    }


    @PostMapping("/deleteLogById")
    @ApiOperation("通过id删除")
    public ResponseResult deleteLogById(@RequestBody SysLog sysLog) {
        String id = sysLog.getId();

        sysLogMapper.deleteLogById(id);

        return ResponseResult.e(ResponseCode.OK);
    }


    @PostMapping("/insertLogBatch")
    @ApiOperation("批量插入")
    public ResponseResult insertLogBatch(@RequestBody List<SysLog> sysLogs) {

        sysLogMapper.insertLogBatch(sysLogs);

        return ResponseResult.e(ResponseCode.OK);
    }


}
