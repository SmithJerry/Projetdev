package com.example.springbootMVC.controller;

import com.example.springbootMVC.entity.Permission;
import com.example.springbootMVC.entity.Role;
import com.example.springbootMVC.service.AccountService;
import com.example.springbootMVC.service.PermissionService;
import com.example.springbootMVC.service.RoleService;
import com.fasterxml.jackson.core.TSFBuilder;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Liang
 * @date 2020/11/30 - 10:39
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    AccountService accountSrv;

    @Autowired
    PermissionService permissionSrv;

    @Autowired
    RoleService roleSrv;

    @RequestMapping("/roleList")
    public String roleList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model){

        PageInfo<Role> page = roleSrv.findByPage(pageNum, pageSize);
        model.addAttribute("page", page);
        return "manager/roleList";
    }
    @RequestMapping("/rolePermission/{id}")
    public String rolePermission(@PathVariable int id, Model model, HttpServletRequest request){

        System.out.println("id :" + id);

        Role role = roleSrv.findById(id);

        System.out.println("role :" + ToStringBuilder.reflectionToString(role));

        List<Permission> pList = permissionSrv.findAllP();
        model.addAttribute("role", role);
        model.addAttribute("pList", pList);
//        Object attribute = request.getSession().getAttribute("account");
//        System.out.println("attribute:" + ToStringBuilder.reflectionToString(attribute));

        return "manager/rolePermission";
    }



    @RequestMapping("/permissionList")
    public String permissionList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model){

        PageInfo<Permission> page = permissionSrv.findByPage(pageNum, pageSize);
        model.addAttribute("page", page);
        return "manager/permissionList";
    }
    @RequestMapping("/permissionUpData")
    public String permissionUpData(@RequestParam int id, Model model){

        Permission permission = permissionSrv.findById(id);

        model.addAttribute("p", permission);

        return "manager/permissionUpData";
    }
    @RequestMapping("/permissionAdd")
    public String permissionAdd(Model model){

        return "manager/permissionUpData";
    }
}
