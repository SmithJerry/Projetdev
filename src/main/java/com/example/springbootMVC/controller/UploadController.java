package com.example.springbootMVC.controller;


import com.example.springbootMVC.entity.Account;
import com.example.springbootMVC.entity.Photo;
import com.example.springbootMVC.service.UploadService;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Liang
 * @date 2020/11/30 - 10:39
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    FastFileStorageClient fc;

    @Autowired
    UploadService uploadSrv;


    @RequestMapping("/upFile")
    public String upload () {

        return "upload/upFile";
    }
    @RequestMapping("/fileUploadController")

    public String fileUpload (MultipartFile filename, String pname, HttpServletRequest request) {
        System.out.println("pname:" + pname);
        System.out.println("file:" + filename.getOriginalFilename());
        try {

//            File path = new File(ResourceUtils.getURL("classpath:").getPath());
//            File upload = new File(path.getAbsolutePath(), "static/uploads/");
//
//            System.out.println("upload:" + upload);
//
//            filename.transferTo(new File(upload+"/"+filename.getOriginalFilename()));
            // 元数据
            Set<MetaData> metaDataSet = new HashSet<MetaData>();
            metaDataSet.add(new MetaData("Author", "liang"));
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式


            String now = dateFormat.format(date);
            metaDataSet.add(new MetaData("CreateDate", now));


            Account account = (Account)request.getSession().getAttribute("account");
            //Photo photo = (Photo)request.getSession().getAttribute("photo");
            //Role role = (Role)request.getSession().getAttribute("role");
            try {
                StorePath uploadFile = null;
                uploadFile = fc.uploadFile(filename.getInputStream(), filename.getSize(), FilenameUtils.getExtension(filename.getOriginalFilename()), metaDataSet);

                Photo photo = new Photo();
                photo.setPname(pname);
                photo.setUrl(uploadFile.getPath());
                System.out.println("photo:" + photo);
                uploadSrv.add(photo);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            //getsession,好像只能get到你登录账户属性

            //            System.out.println("photo:" + photo);
//            photo.setPname(pname);
//            photo.setUrl(filename.getOriginalFilename());
//            String uri =
//            uploadSrv.addPhoto(pname, uri);


        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "upload/upFile";
    }



    // FastDFS




}
