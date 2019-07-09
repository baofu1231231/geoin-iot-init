package com.geoin.iot.modules.DeviceSupplement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geoin.iot.common.utils.PageUtils;
import com.geoin.iot.common.utils.Query;
import com.geoin.iot.modules.DeviceSupplement.dao.DeviceSupplementDao;
import com.geoin.iot.modules.DeviceSupplement.entity.DeviceSupplementEntity;
import com.geoin.iot.modules.DeviceSupplement.service.DeviceSupplementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("deviceSupplementService")
public class DeviceSupplementServiceImpl extends ServiceImpl<DeviceSupplementDao, DeviceSupplementEntity> implements DeviceSupplementService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DeviceSupplementEntity> page = this.page(
                new Query<DeviceSupplementEntity>().getPage(params),
                new QueryWrapper<DeviceSupplementEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> queryTrack(String sn) {
        return baseMapper.queryTrack(sn);
    }

    @Override
    public List<Map<String, Object>> alarmList() {
        return  baseMapper.alarmList();
    }

    @Override
    public List<Map<String, Object>> currentPosition(String sn) {
        return baseMapper.currentPosition(sn);
    }

    @Override
    public List<String> alarmMessage() {
        return baseMapper.alarmMessage();
    }

    @Override
    public List<Map<String, Object>> positionalTrajectory(String sn) {
        return baseMapper.positionalTrajectory(sn);
    }

}