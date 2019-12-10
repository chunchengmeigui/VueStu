package com.example.mybatisplustest.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplustest.entity.JsonResult;
import com.example.mybatisplustest.entity.User;
import com.example.mybatisplustest.exception.MyException;
import com.example.mybatisplustest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2019-12-10
 */
@RestController
public class UserController {
    @Autowired
    IUserService iUserService;

    @Autowired
    HttpServletResponse response;

    @RequestMapping("login")
    public Object login(@RequestBody Map<String, Object> map,HttpServletRequest request) {
        String code = String.valueOf(map.get("code"));
        HttpSession session = request.getSession();
       String code1= (String) session.getAttribute("code");
        if (!code.equals(code1)) {
            throw new MyException("验证码错误");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", map.get("name"));
        queryWrapper.eq("password", map.get("password"));
        User user1 = iUserService.getOne(queryWrapper);
        if (user1 == null) {
            throw new MyException("账号或密码错误");
        }
        return JsonResult.buildSuccess("成功");
    }


    /**
     * desc:
     * param:
     * return:
     * author: CDN
     * date: 2019/12/10
     */
    @RequestMapping("code")
    public void code(HttpServletRequest request) throws IOException {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(150, 40, 4, 4);
        captcha.write(response.getOutputStream());
        HttpSession session = request.getSession();
        session.setAttribute("code", captcha.getCode());
        System.out.println(session.getId());
    }
}
