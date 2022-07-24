package com.cy.store.controller;

import com.cy.store.commons.utils.JsonResult;
import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {
    //操作成功的状态码
    public static final int OK=200;

    //请求异常处理方法，当发生异常直接拦截返回给前端
    @ExceptionHandler({ServiceException.class,FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("用户注册产生位置的异常");
        }else if (e instanceof UserNotFoundException){
            result.setState(5001);
            result.setMessage("用户不存在异常");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(5002);
            result.setMessage("密码错误异常");
        }else if (e instanceof UpdateException){
            result.setState(5003);
            result.setMessage("更新数据时产生未知的异常");
        }else if (e instanceof DeleteException){
            result.setState(5004);
            result.setMessage("删除数据时产生未知的异常");
        }else if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用异常");
        }else if (e instanceof AddressCountLimitException){
            result.setState(4001);
            result.setMessage("用户收货地址超出异常");
        }else if (e instanceof AddressNotFoundException){
            result.setState(4002);
            result.setMessage("收货地址不存在异常");
        }else if (e instanceof AccessDeniedException){
            result.setState(4003);
            result.setMessage("收货地址非法访问");
        }else if (e instanceof ProductNotFoundException){
            result.setState(4004);
            result.setMessage("商品数据不存异常");
        }else if (e instanceof CartNotFoundException){
            result.setState(4005);
            result.setMessage("购物车商品数据不存异常");
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }
        return result;
    }

    /**
     * 在session对象中获取uid
     * @param session
     * @return
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
