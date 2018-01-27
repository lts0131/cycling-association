package com.lts.school.service;

import com.lts.commen.ActionResult;

import javax.swing.*;

/**
 * @description
 * @Author liutiansheng
 * @Email liutiansheng@encdata.cn
 * @Date 2018年01月27日
 */
public interface SchoolService {
    /**
     * 根据学校列表查询学校详情
     * @param schoolId
     * @return
     */
    ActionResult<Object> selectSchool(Integer schoolId);

}
