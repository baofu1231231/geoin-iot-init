package com.geoin.iot.modules.DeviceSupplement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geoin.iot.common.utils.PageUtils;
import com.geoin.iot.modules.DeviceSupplement.entity.DeviceSupplementEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 */
public interface DeviceSupplementService extends IService<DeviceSupplementEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<Map<String ,Object>> queryTrack(String sn);
    List<Map<String ,Object>> alarmList();
    List<Map<String ,Object>> currentPosition(String sn);
    List<String>alarmMessage();
    List<Map<String,Object>> positionalTrajectory(String sn);
}

