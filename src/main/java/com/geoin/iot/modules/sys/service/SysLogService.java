package com.geoin.iot.modules.sys.service;


import com.geoin.iot.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.geoin.iot.modules.sys.entity.SysLogEntity;

import java.util.Map;

/**
 * 系统日志
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
