package com.example.springbootMVC.service;

import com.example.springbootMVC.RespStat;
import com.example.springbootMVC.entity.Account;
import com.example.springbootMVC.mapper.AccountExample;
import com.example.springbootMVC.mapper.AccountMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liang
 * @date 2020/12/1 - 16:36
 */
@Service
public class AccountService {
    @Autowired
    AccountMapper accMapper;

    public Account findByLoginNameAndPassword(String loginName, String password) {
        AccountExample example = new AccountExample();
        example.createCriteria().andLoginNameEqualTo(loginName).andPasswordEqualTo(password);
        List<Account> list = accMapper.selectByExample(example);
        return list.size() == 0 ? null : list.get(0);
    }

    public List<Account> findAll() {
        AccountExample example = new AccountExample();

        return accMapper.selectByExample(example);
    }

    public PageInfo<Account> findByPage(int pageNum, int pageSize) {

        List<Account> list = accMapper.selectByPermission();
        Account account = list.get(0);

        System.out.println("account getPermissionList:" + account.getPermissionList().size());
        System.out.println("account getRoleList:" + account.getRoleList().size());

        System.out.println("alist.size() + " + list.size());
        System.out.println(ToStringBuilder.reflectionToString(list.get(0)));


        PageHelper.startPage(pageNum,pageSize);
        AccountExample example = new AccountExample();
        PageInfo<Account> pageInfo = new PageInfo<Account>(accMapper.selectByExample(example), 5);

        return pageInfo;
    }

    public RespStat deleteById(int id) {
        int row = accMapper.deleteByPrimaryKey(id);
        if(row == 1){
            return RespStat.build(200);
        }else {
            return RespStat.build(500, "删除出错");
        }
    }
}
