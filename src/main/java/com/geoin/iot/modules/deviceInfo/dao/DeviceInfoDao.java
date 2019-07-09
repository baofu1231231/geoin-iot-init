package com.geoin.iot.modules.deviceInfo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geoin.iot.modules.deviceInfo.entity.DeviceInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 */
@Mapper
public interface DeviceInfoDao extends BaseMapper<DeviceInfoEntity> {
    List<String> selectAllSn();
    List<Map<String ,Object>> queryEntityBySn(String sn);

}
