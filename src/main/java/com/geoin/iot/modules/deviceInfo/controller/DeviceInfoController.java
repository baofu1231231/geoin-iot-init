package com.geoin.iot.modules.deviceInfo.controller;

import com.geoin.iot.common.utils.PageUtils;
import com.geoin.iot.common.utils.R;
import com.geoin.iot.modules.deviceInfo.entity.DeviceInfoEntity;
import com.geoin.iot.modules.deviceInfo.service.DeviceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 
 */
@Api(value = "设备基本信息", description = "活动相关接口")
@RestController
@RequestMapping("generator/deviceinfo")
public class DeviceInfoController {
    @Autowired
    private DeviceInfoService deviceInfoService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("generator:deviceinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = deviceInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("generator:deviceinfo:info")
    public R info(@PathVariable("id") Integer id){
		DeviceInfoEntity deviceInfo = deviceInfoService.getById(id);

        return R.ok().put("deviceInfo", deviceInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("generator:deviceinfo:save")
    public R save(@RequestBody DeviceInfoEntity deviceInfo){
		deviceInfoService.save(deviceInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("generator:deviceinfo:update")
    public R update(@RequestBody DeviceInfoEntity deviceInfo){
		deviceInfoService.updateById(deviceInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("generator:deviceinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		deviceInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     * 查询sn
     */
    @ApiOperation("获取sn号")
    @GetMapping("获取sn号")
    public R selectAllSn(Model model){
        List<String> list=deviceInfoService.selectAllSn();
        return R.ok().put("data",list);
    }
    /**
     * 查询设备详情
     */
    @ApiOperation("获取设备详情")
    @GetMapping("获取设备详情")
    public R queryEntityBySn(String sn){
        List<Map<String,Object>> entity = deviceInfoService.queryEntityBySn(sn);
        return R.ok().put("data",entity);
    }
}
