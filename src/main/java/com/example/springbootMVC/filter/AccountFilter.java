package com.example.springbootMVC.filter;

import com.example.springbootMVC.entity.Account;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Liang
 * @date 2020/12/1 - 17:20
 * 用户权限处理
 */
@Component
@WebFilter(urlPatterns = "/*")
public class AccountFilter implements Filter {

    // 不需要登录的 URI
    private final String[] IGNORE_URI = {"/index","/account/validataAccount","/css/","/js/","/account/login","/images","/errorPage"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();

        //当前访问的URI是不是在Ignore列表里
        boolean pass = canPassIgnore(uri);
        if(pass){
            //在的话放行
            System.out.println("------pass--------");
            filterChain.doFilter(request, response);
            return;
        }

        System.out.println("--------------------------");
        //是否已登录，从session里找Account
        Account account = (Account) request.getSession().getAttribute("account");
        System.out.println("getsession account" + account);
        if(null == account){
            response.sendRedirect("/account/login");
            return;
        }
        // 已登录用户是否有权限访问当前页面
//		if(!hasAuth(account.getPermissionList(),uri)) {
//
//			request.setAttribute("msg", "您无权访问当前页面:" + uri);
//			request.getRequestDispatcher("/errorPage").forward(request, response);
//			return;
//		}


        System.out.println("-----filter-----" + uri);
        filterChain.doFilter(request, response);
    }

    //	private boolean hasAuth(List<Permission> permissionList, String uri) {
//		// TODO Auto-generated method stub
//		for (Permission permission : permissionList) {
//			if(uri.startsWith(permission.getUri())) {
//				return true;
//			}
//		}
//		return false;
//	}

    private boolean canPassIgnore(String uri) {

        for (String val : IGNORE_URI){
            if(uri.startsWith(val)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-----------AccountFilter Init----------------");
        Filter.super.init(filterConfig);
    }
}
