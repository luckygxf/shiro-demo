package com.gxf.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroDemo {
    public static void main(String[] args) {
        //读取配置文件  初始化SecurityManager工厂IniSecurityManagerFactory

        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_ream.ini");
        //获得SecurityManager实例
        SecurityManager instance = factory.getInstance();
        //把SecurityManager的实例绑定到SecurityUtils上面
        SecurityUtils.setSecurityManager(instance);
        //获取当前执行的用户
        Subject subject = SecurityUtils.getSubject();
        //创建token 令牌  用户名/密码
        UsernamePasswordToken token=new UsernamePasswordToken("guanxianseng", "123456");
        try{
            //登录/身份认证
            subject.login(token);
            System.out.println("身份认证成功...");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("身份认证失败...");
        }
        //退出
        subject.logout();
    }
}
