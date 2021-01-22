package com.example.springbootMVC.controller;

import com.example.springbootMVC.RespStat;
import com.example.springbootMVC.entity.Account;
import com.example.springbootMVC.service.AccountService;
import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Liang
 * @date 2020/11/30 - 10:39
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    FastFileStorageClient fc;

    @Autowired
    AccountService accountSrv;


    @RequestMapping("/login")
    public String login() {

        return "account/login";
    }

    @RequestMapping("/validataAccount")
    @ResponseBody
    public String validataAccount(String loginName, String password, HttpServletRequest request) {

        System.out.println("loginName" + loginName);
        System.out.println("password" + password);

        //1.直接返回是否登陆成功
        //2.返回Account对象，对象是空在controller里做业务逻辑


        Account account = accountSrv.findByLoginNameAndPassword(loginName, password);

        if (account == null) {
            return "登陆失败";
        } else {
            //登陆成功

            request.getSession().setAttribute("account", account);
            return "success";
        }
    }
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request){
          request.getSession().removeAttribute("account");
          return "index";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model){

        PageInfo<Account> page = accountSrv.findByPage(pageNum, pageSize);
        model.addAttribute("page", page);
        return "account/list";
    }
    @RequestMapping("/deleteById")
    @ResponseBody
    public RespStat deleteById(int id){

         RespStat stat  = accountSrv.deleteById(id);

        return stat;
    }

    // FastDFS



    @RequestMapping("/profile")
    public String profile () {

        return "account/profile";
}


//    /**
//     * 中文字符
//     * @param filename
//     * @param password
//     * @return
//     */
//    @RequestMapping("/fileUploadController")
//    public String fileUpload (MultipartFile filename, String password) {
//        System.out.println("password:" + password);
//        System.out.println("file:" + filename.getOriginalFilename());
//        try {
//
//            File path = new File(ResourceUtils.getURL("classpath:").getPath());
//            File upload = new File(path.getAbsolutePath(), "static/upload/");
//
//            System.out.println("upload:" + upload);
//
//            filename.transferTo(new File(upload+"/"+filename.getOriginalFilename()));
//
//
//        } catch (IllegalStateException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return "profile";
//    }


}
