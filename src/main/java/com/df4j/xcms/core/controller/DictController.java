package com.df4j.xcms.core.controller;

import com.df4j.xcframework.base.server.Result;
import com.df4j.xcframework.base.util.PojoUtils;
import com.df4j.xcframework.base.util.ResultUtils;
import com.df4j.xcms.core.pojo.dto.DictDto;
import com.df4j.xcms.core.pojo.entity.DictEntity;
import com.df4j.xcms.core.service.DictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/xcms/core/dict")
public class DictController {

    private Logger logger = LoggerFactory.getLogger(DictController.class);

    @Autowired
    private DictService dictService;

    @RequestMapping("/list")
    public Result list(@RequestBody Map<String, ?> map) {
        List<DictEntity> list = dictService.list();
        List<DictDto> resultList = PojoUtils.fromList(DictDto.class, list);
        return ResultUtils.success(resultList);
    }

}
