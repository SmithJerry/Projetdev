package com.example.springbootMVC.service;

import com.example.springbootMVC.entity.Role;
import com.example.springbootMVC.mapper.RoleExample;
import com.example.springbootMVC.mapper.RoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liang
 * @date 2020/12/3 - 21:23
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper rMapper;


    public PageInfo<Role> findByPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        RoleExample example = new RoleExample();
        PageInfo<Role> pageInfo = new PageInfo<>(rMapper.selectByExample(example));
        return pageInfo;
    }

    public Role findById(int id) {

        return rMapper.findById(id);
    }

    public void addPermission(int id, int[] permissions) {
//这个方法只能用一条sql语句插入
//        for (int p : permissions) {
//
//            rMapper.addPermission(id, p);
//        }
        rMapper.addPermissions(id, permissions);

    }
}
