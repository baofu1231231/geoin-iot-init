package com.geoin.iot.modules.deviceInfo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geoin.iot.common.utils.PageUtils;
import com.geoin.iot.modules.deviceInfo.entity.DeviceInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 */
public interface DeviceInfoService extends IService<DeviceInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
     List<String> selectAllSn();
    List<Map<String ,Object>> queryEntityBySn(String sn);

}

