package com.hx.edu.modules.user.controller;

import com.hx.edu.core.constant.SystemConstant;
import com.hx.edu.core.model.R;
import com.hx.edu.core.utils.JwtUtils;
import com.hx.edu.modules.user.entity.User;
import com.hx.edu.modules.user.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DT人 on 2018/4/10 22:25.
 */
@Api(value = "LoginController", description = "用户登录登出接口")
@RestController
public class LoginController implements Serializable {
    @Resource
    UserRepository userRepository;

    @ApiOperation(value="用户登录", notes="用户登录接口")
    @RequestMapping(value="login",method = RequestMethod.POST)
    public R login(String username, String password, HttpServletResponse response) {
        User user =  userRepository.findByUsername(username);
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        userRepository.getCountByUserName(map);
        System.out.println(user+"===================="+map.get("totalPepole"));
        if(user!=null){
            if(user.getPassword().equals(password)){
                //把token返回给客户端-->客户端保存至cookie-->客户端每次请求附带cookie参数
                String JWT = JwtUtils.createJWT("1", username, SystemConstant.JWT_TTL);
                return R.ok(JWT);
            }else{
                return R.error();
            }
        }else{
            return R.error();
        }
    }
    @ApiOperation(value="获取用户信息")
    @RequestMapping(value="description",method = RequestMethod.POST)
    public R  description(String username) {
        User user =  userRepository.findByUsername(username);
        return R.ok(user.getDescription());
    }

    @RequestMapping("/test/{username}")
    public R list(@PathVariable String username) {
        User user =  userRepository.findByUsername(username);
        if(user == null){
            return R.error();
        }else{
            return R.ok().put("user",user);
        }
    }
}
