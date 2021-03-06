package com.bdxh.backend.controller.school;

import com.bdxh.backend.configration.security.utils.SecurityUtils;
import com.bdxh.common.utils.wrapper.WrapMapper;
import com.bdxh.common.utils.wrapper.Wrapper;
import com.bdxh.school.dto.*;
import com.bdxh.school.entity.SchoolDevice;
import com.bdxh.school.feign.SchoolDeviceControllerClient;
import com.bdxh.school.vo.SchoolDeviceShowVo;
import com.bdxh.system.entity.User;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 学校门禁信息
 * @Author: Kang
 * @Date: 2019/3/27 17:37
 */
@RestController
@RequestMapping("/schoolDeviceWebController")
@Validated
@Slf4j
@Api(value = "学校门禁信息", tags = "学校门禁信息交互API")
public class SchoolDeviceWebController {

    @Autowired
    private SchoolDeviceControllerClient schoolDeviceControllerClient;

    @PostMapping("/addSchoolDevice")
    @ApiOperation(value = "增加门禁信息", response = Boolean.class)
    public Object addSchoolDevice(@Validated @RequestBody AddSchoolDeviceDto addSchoolDeviceDto) {
        //获取当前用户
        User user = SecurityUtils.getCurrentUser();
        //设置操作人
        addSchoolDeviceDto.setOperator(user.getId());
        addSchoolDeviceDto.setOperatorName(user.getUserName());
        Wrapper wrapper = schoolDeviceControllerClient.addSchoolDevice(addSchoolDeviceDto);
        return wrapper;
    }

    @PostMapping("/modifySchoolDevice")
    @ApiOperation(value = "修改门禁信息", response = Boolean.class)
    public Object modifySchoolDevice(@Validated @RequestBody ModifySchoolDeviceDto modifySchoolDeviceDto) {
        //获取当前用户
        User user = SecurityUtils.getCurrentUser();
        //设置操作人
        modifySchoolDeviceDto.setOperator(user.getId());
        modifySchoolDeviceDto.setOperatorName(user.getUserName());
        Wrapper wrapper = schoolDeviceControllerClient.modifySchoolDevice(modifySchoolDeviceDto);
        return wrapper;
    }

    @PostMapping("/delSchoolDeviceById")
    @ApiOperation(value = "删除门禁信息", response = Boolean.class)
    public Object delSchoolDeviceById(@RequestParam("id") Long id) {
        Wrapper wrapper = schoolDeviceControllerClient.delSchoolDeviceById(id);
        return wrapper;
    }

    @PostMapping("/delBatchSchoolDeviceInIds")
    @ApiOperation(value = "批量删除门禁信息", response = Boolean.class)
    public Object delBatchSchoolDeviceInIds(@RequestParam("ids") List<Long> ids) {
        Wrapper wrapper = schoolDeviceControllerClient.delBatchSchoolDeviceInIds(ids);
        return wrapper;
    }

    @GetMapping("/findSchoolDeviceById")
    @ApiOperation(value = "id查询门禁信息", response = SchoolDevice.class)
    public Object findSchoolDeviceById(@RequestParam("id") Long id) {
        Wrapper wrapper = schoolDeviceControllerClient.findSchoolDeviceById(id);
        return WrapMapper.ok(wrapper.getResult());
    }

    @PostMapping("/findSchoolDeviceInConditionPage")
    @ApiOperation(value = "门禁信息根据条件分页查询", response = PageInfo.class)
    public Object findSchoolDeviceInConditionPage(@RequestBody SchoolDeviceQueryDto schoolDeviceQueryDto) {
        Wrapper<PageInfo<SchoolDeviceShowVo>> wrapper = schoolDeviceControllerClient.findSchoolDeviceInConditionPage(schoolDeviceQueryDto);
        return WrapMapper.ok(wrapper.getResult());
    }
}
