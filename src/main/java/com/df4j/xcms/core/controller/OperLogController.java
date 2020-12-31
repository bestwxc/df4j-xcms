package com.df4j.xcms.core.controller;

import com.df4j.xcframework.base.server.Result;
import com.df4j.xcframework.base.util.PojoUtils;
import com.df4j.xcframework.base.util.ResultUtils;
import com.df4j.xcms.core.pojo.dto.OperLogDto;
import com.df4j.xcms.core.pojo.entity.OperLogEntity;
import com.df4j.xcms.core.service.OperLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/xcms/core/oper/log")
public class OperLogController {
    private Logger logger = LoggerFactory.getLogger(OperLogController.class);

    @Autowired
    private OperLogService operLogService;

    @RequestMapping("/list")
    public Result list(@RequestBody Map<String, ?> map) {
        List<OperLogEntity> list = operLogService.list();
        List<OperLogDto> resultList = PojoUtils.fromList(OperLogDto.class, list);
        return ResultUtils.success(resultList);
    }

}
