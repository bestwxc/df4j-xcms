package com.df4j.xcms.core.controller;

import com.df4j.xcframework.base.server.Result;
import com.df4j.xcframework.base.util.PojoUtils;
import com.df4j.xcframework.base.util.ResultUtils;
import com.df4j.xcms.core.pojo.dto.MenuDto;
import com.df4j.xcms.core.pojo.entity.MenuEntity;
import com.df4j.xcms.core.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/xcms/api/core/menu")
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping("/list")
    public Result list(@RequestBody Map<String, ?> map) {
        List<MenuEntity> list = menuService.list();
        List<MenuDto> resultList = PojoUtils.fromList(MenuDto.class, list);
        return ResultUtils.success(resultList);
    }
}
