package com.geoin.iot.modules.DeviceSupplement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geoin.iot.modules.DeviceSupplement.entity.DeviceSupplementEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 */
@Mapper
public interface DeviceSupplementDao extends BaseMapper<DeviceSupplementEntity> {
    List<Map<String ,Object>> queryTrack(String sn);
    List<Map<String ,Object>> alarmList();
    List<Map<String ,Object>> currentPosition(String sn);
    List<String>alarmMessage();
    List<Map<String,Object>> positionalTrajectory(String sn);
}
