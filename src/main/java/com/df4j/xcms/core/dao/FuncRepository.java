package com.df4j.xcms.core.dao;

import com.df4j.xcms.core.pojo.entity.FuncEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncRepository extends JpaRepository<FuncEntity, Long> {
    FuncEntity findByApplicationNameAndClassNameAndMethodNameAndFuncCode(String applicationName, String className,
                                                                         String methodName, String funcCode);
    FuncEntity findByFuncCode(String funcCode);
}
