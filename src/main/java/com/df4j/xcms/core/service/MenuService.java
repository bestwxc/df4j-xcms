package com.df4j.xcms.core.service;

import com.df4j.xcms.core.dao.MenuRepository;
import com.df4j.xcms.core.pojo.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<MenuEntity> list() {
        return menuRepository.findAll();
    }

    public void add(MenuEntity menuEntity) {
        menuRepository.saveAndFlush(menuEntity);
    }


    public void updateById(MenuEntity menuEntity) {
        menuRepository.saveAndFlush(menuEntity);
    }

    public void deleteById(long id) {
        menuRepository.deleteById(id);
    }
}
