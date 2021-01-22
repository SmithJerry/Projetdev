package com.example.springbootMVC.service;

import com.example.springbootMVC.RespStat;
import com.example.springbootMVC.entity.Account;
import com.example.springbootMVC.entity.Permission;
import com.example.springbootMVC.mapper.PermissionExample;
import com.example.springbootMVC.mapper.PermissionMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liang
 * @date 2020/12/3 - 21:22
 */
@Service
public class PermissionService {

    @Autowired
    PermissionMapper pMapper;

    public PageInfo<Permission> findByPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        PermissionExample example = new PermissionExample();

        List<Permission> list = pMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    public Permission findById(int id) {

        return pMapper.selectByPrimaryKey(id);
    }

    public void updata(Permission permission) {

        pMapper.updateByPrimaryKeySelective(permission);
    }

    public void add(Permission permission) {
        pMapper.insert(permission);
    }

    public RespStat deleteById(int id) {
        int row = pMapper.deleteByPrimaryKey(id);
        if(row == 1){
            return RespStat.build(200);
        }else {
            return RespStat.build(500, "删除出错");
        }
    }

    public List<Permission> findAllP() {

        PermissionExample example = new PermissionExample();
        return pMapper.selectByExample(example);
    }
}
