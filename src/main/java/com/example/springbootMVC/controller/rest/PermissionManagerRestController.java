package com.example.springbootMVC.controller.rest;

import com.example.springbootMVC.RespStat;
import com.example.springbootMVC.entity.Permission;
import com.example.springbootMVC.service.PermissionService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liang
 * @date 2020/12/8 - 18:52
 * restful风格URI的controller
 * 只和用户交换JSON数据
 */
@RestController
@RequestMapping("/api/v1/manager/permission")
public class PermissionManagerRestController {

    @Autowired
    PermissionService permissionSrv;


    @RequestMapping("/updata")
    public RespStat updata(@RequestBody Permission permission){

        System.out.println("permission:" + ToStringBuilder.reflectionToString(permission));
        permissionSrv.updata(permission);
        return  RespStat.build(200);
    }
    @RequestMapping("/add")
    public RespStat add(@RequestBody Permission permission){

        System.out.println("permission:" + ToStringBuilder.reflectionToString(permission));
        permissionSrv.add(permission);
        return  RespStat.build(200);
    }
    @RequestMapping("/deleteById")
    @ResponseBody
    public RespStat deleteById(int id){

        RespStat stat  = permissionSrv.deleteById(id);

        return stat;
    }
}
