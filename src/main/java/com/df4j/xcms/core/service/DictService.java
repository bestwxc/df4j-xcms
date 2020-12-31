package com.df4j.xcms.core.service;

import com.df4j.xcms.core.dao.DictRepository;
import com.df4j.xcms.core.pojo.entity.DictEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictService {

    @Autowired
    private DictRepository dictRepository;

    public List<DictEntity> list() {
        return dictRepository.findAll();
    }
}
