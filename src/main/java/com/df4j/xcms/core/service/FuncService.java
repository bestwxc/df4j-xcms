package com.df4j.xcms.core.service;

import com.df4j.xcframework.base.id.IdentityGenerator;
import com.df4j.xcms.core.constants.ResourceType;
import com.df4j.xcms.core.dao.FuncRepository;
import com.df4j.xcms.core.pojo.entity.FuncEntity;
import com.df4j.xcms.core.utils.IdentityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

import static com.df4j.xcms.core.constants.Constants.SYSTEM_NAME;

@Service
public class FuncService {
    @Autowired
    private FuncRepository funcRepository;

    @Autowired
    private IdentityGenerator<Long> identityGenerator;

    @Transactional
    public FuncEntity save(String applicationName, String className, String methodName, String url) {
        FuncEntity funcEntity = funcRepository.findByApplicationNameAndClassNameAndMethodNameAndFuncCode(applicationName, className, methodName, url);
        LocalDateTime now = LocalDateTime.now();
        if (ObjectUtils.isEmpty(funcEntity)) {
            Long id = identityGenerator.generate(SYSTEM_NAME, IdentityUtils.getName(FuncEntity.class));
            String uniqueStr = String.format("%010d", id);
            String funcCode = className + "." + methodName;
            String funcName = className.substring(className.lastIndexOf(".") + 1) + "." + methodName;
            String funcContent = url;
            funcEntity = new FuncEntity();
            funcEntity.setId(id);
            funcEntity.setUniqueStr(uniqueStr);
            funcEntity.setFuncCode(funcCode);
            funcEntity.setFuncContent(funcContent);
            funcEntity.setFuncName(funcName);
            funcEntity.setApplicationName(applicationName);
            funcEntity.setClassName(className);
            funcEntity.setMethodName(methodName);

            funcEntity.setCreatedBy("XCMS");
            funcEntity.setLastModifiedBy("XCMS");
            funcEntity.setCreatedDate(now);
            funcEntity.setLastModifiedDate(now);
            funcEntity.setState(1);
            funcEntity.setSysCode("XCMS");
            funcEntity.setOrderNum(0);
            funcEntity.setResourceType(ResourceType.Func.getTargetType());
        } else {
            funcEntity.setLastModifiedDate(now);
        }
        funcRepository.save(funcEntity);
        return funcEntity;
    }
}
