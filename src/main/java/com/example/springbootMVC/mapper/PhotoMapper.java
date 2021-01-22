package com.example.springbootMVC.mapper;

import com.example.springbootMVC.entity.Photo;
import org.springframework.stereotype.Repository;

/**
 * PhotoMapper继承基类
 */
@Repository
public interface PhotoMapper extends MyBatisBaseDao<Photo, Integer, PhotoExample> {
}