/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.zs5s.dao.Impl;

import com.zs5s.dao.SeleniumInfoDao;
import com.zs5s.entity.SeleniumInfo;
import com.zs5s.mapper.SeleniumInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author yangle
 * @version $Id SeleniumInfoDaoImpl.java, v 0.1 2017-01-22 下午4:45 yangle Exp $$
 */
@Component
public class SeleniumInfoDaoImpl implements SeleniumInfoDao {

    private final SeleniumInfoMapper seleniumInfoMapper;

    SeleniumInfoDaoImpl(@Autowired SeleniumInfoMapper seleniumInfoMapper) {
        this.seleniumInfoMapper = seleniumInfoMapper;
    }

    @Override
    public SeleniumInfo getSeleniumInfo(int id) {
        LogUtil.info(this,"id:" + id);
        return seleniumInfoMapper.findById(id);
    }

    @Override
    public List<SeleniumInfo> getSeleniumInfoList(List<Integer> ids) {
        LogUtil.info(this,"idsSize:" + ids.size());
        return seleniumInfoMapper.findListInIds(ids);
    }

    @Override
    public int insertSeleniumInfo(SeleniumInfo seleniumInfo) {
        LogUtil.info(this,"id:" + seleniumInfo.getId());
        return seleniumInfoMapper.insert(seleniumInfo);
    }

    @Override
    public int deleteSeleniumInfo(SeleniumInfo seleniumInfo) {
        LogUtil.info(this,"id:" + seleniumInfo.getId());
        return seleniumInfoMapper.deleteById(seleniumInfo.getId());
    }

    @Override
    public int updateSeleniumInfo(SeleniumInfo seleniumInfo) {
        LogUtil.info(this,"id:" + seleniumInfo.getId());
        return seleniumInfoMapper.updateById(seleniumInfo);
    }

    @Override
    public List<SeleniumInfo> findAll() {
        LogUtil.info(this,"findAll");
        return seleniumInfoMapper.findAll();
    }

    @Override
    public SeleniumInfo findLast() {
        LogUtil.info(this,"findAll");
        return seleniumInfoMapper.findLast();
    }
}