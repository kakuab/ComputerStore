package com.cy.store.controller;

import com.cy.store.commons.utils.JsonResult;
import com.cy.store.commons.utils.UUIDUtils;
import com.cy.store.controller.ex.*;
import com.cy.store.entity.User;
import com.cy.store.service.UserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> register(User user){
        userService.register(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User user=userService.login(username,password);
        //给session绑定数据
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());
        return new JsonResult<User>(OK,user);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uidFromSession = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uidFromSession,username,oldPassword,newPassword);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getUserByUid(HttpSession session){
        User data = userService.getUserByid(getUidFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("change_user")
    public JsonResult<Void> changeUser(HttpSession session,User user){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.updateUser(uid,username,user);
        return new JsonResult<>(OK);
    }

    //定义头像文件的大小
    public static final int AVATAR_SIZE=10*1024*1024;

    //定义文件的上传格式
    public static final List<String> AVATAR_TYPE=new ArrayList<>();

    static{
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    /**
     *
     * @param session
     * @param file MultipartFile SpringMVC提供的接口，用于接收任意的文件
     * @return
     */
    @RequestMapping("import_avatar")
    public JsonResult<String> importAvatar(HttpSession session, MultipartFile file){
        if (file.isEmpty()){
            throw new FileEmptyException("文件为空异常");
        }
        if (file.getSize() > AVATAR_SIZE){
            throw new FileSizeException("文件超出限制异常");
        }
        //contains做比较
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("文件格式错误");
        }
        //上传的文件/upload/文件.png
        String upload = "D:\\java\\E-commerceStore\\src\\main\\resources\\static\\upload";
        File dir = new File(upload);
        if (!dir.exists()){//检测文件是否存在
            dir.mkdirs();//创建当前目录
        }
        System.out.println(dir);
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String subFile = originalFilename.substring(index);
        String fileName= UUIDUtils.getUUID()+subFile;
        File dest = new File(dir,fileName);//空文件
        //参数file文件写入到这个空文件中
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        } catch (FileStateException e){
            throw new FileStateException("文件状态异常");
        }
        //返回路径的头像
        String avatar = "/upload/"+fileName;
        userService.impportAvatar(getUidFromSession(session),getUsernameFromSession(session),avatar);
        return new JsonResult<>(OK,avatar);
    }
}
