package com.lts.school.service.impl;

import com.lts.commen.ActionResult;
import com.lts.commen.ResultEnum;
import com.lts.school.mapper.LSchoolMapper;
import com.lts.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @Author liutiansheng
 * @Email liutiansheng@encdata.cn
 * @Date 2018年01月27日
 */
@Service
public class SchoolServiceImpl implements SchoolService{
    @Autowired
    LSchoolMapper lSchoolMapper;
    /**
     * 根据学校列表查询学校详情
     *
     * @param schoolId
     * @return
     */
    @Override
    public ActionResult<Object> selectSchool(Integer schoolId) {
        ActionResult result = new ActionResult();
        try {
            result.setData(lSchoolMapper.selectByPrimaryKey(schoolId));
        } catch (Exception e) {
            result.setCode(ResultEnum.BAD_PARAM_REQUEST.getCode());
            result.setMessage(ResultEnum.BAD_PARAM_REQUEST.getDesc());
            return result;
        }
        return result;
    }
}
