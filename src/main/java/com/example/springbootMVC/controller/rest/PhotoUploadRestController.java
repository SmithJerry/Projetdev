//package com.example.springbootMVC.controller.rest;
//
//import com.example.springbootMVC.RespStat;
//import com.example.springbootMVC.entity.Photo;
//import com.example.springbootMVC.service.RoleService;
//import com.example.springbootMVC.service.UploadService;
//import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Liang
// * @date 2020/12/8 - 18:52
// * restful风格URI的controller
// * 只和用户交换JSON数据
// */
//@RestController
//@RequestMapping("/api/v1/upload/photo")
//public class PhotoUploadRestController {
//
//    @Autowired
//    UploadService uploadSrv;
//
//    @RequestMapping("/add")
//    public RespStat photoAdd(@RequestBody Photo photo){
//
//        System.out.println("photo:" + ToStringBuilder.reflectionToString(photo));
//        uploadSrv.add(photo);
//        return  RespStat.build(200);
//    }
//
//}
