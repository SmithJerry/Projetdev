package com.example.springbootMVC.service;

import com.example.springbootMVC.RespStat;
import com.example.springbootMVC.entity.Account;
import com.example.springbootMVC.entity.Photo;
import com.example.springbootMVC.mapper.AccountExample;
import com.example.springbootMVC.mapper.AccountMapper;
import com.example.springbootMVC.mapper.PhotoMapper;
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
public class UploadService {

    @Autowired
    PhotoMapper pMapper;

//    public void update(Photo photo) {
//        pMapper.updateByPrimaryKeySelective(photo);
//    }

    public void add(Photo photo) {
        System.out.println("success");
        pMapper.insert(photo);
    }

    public Photo findById(int id) {
        return pMapper.selectByPrimaryKey(id);
    }
}
