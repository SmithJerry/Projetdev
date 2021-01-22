package com.example.springbootMVC.controller.rest;

import com.example.springbootMVC.RespStat;
import com.example.springbootMVC.service.RoleService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Permissions;

/**
 * @author Liang
 * @date 2020/12/8 - 18:52
 * restful风格URI的controller
 * 只和用户交换JSON数据
 */
@RestController
@RequestMapping("/api/v1/manager/role")
public class RoleManagerRestController {

    @Autowired
    RoleService roleSrv;

    @RequestMapping("/permission/add")
    public RespStat permissionAdd(
            @RequestParam(value = "permissions") int[] permissions,
            @RequestParam(value = "id") int id
    ){

        roleSrv.addPermission(id, permissions);

        System.out.println("permissions:" + ToStringBuilder.reflectionToString(permissions));
        return RespStat.build(200);
    }

}
