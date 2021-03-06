package com.kaishengit.util;

import com.kaishengit.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

    /**
     * 判断当前是否登录状态
     * @return
     */
    public static boolean isCurrentUser(){
        return getCurrentUser() != null;
//        return true;
    }


    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 查询当前登录者信息
     * @return ShiroUser
     */
    public static User getCurrentUser() {
        return  (User) getSubject().getPrincipal();
    }

    /**
     * 判断当前用户是否是管理员
     * @return
     */
    public static boolean isAdmin () {
        return getSubject().hasRole("管理员");
    }

    /**
     * 判断当前用户是否是经理
     * @return
     */
    public static boolean isManager() {
        return getSubject().hasRole("经理");
    }

    /**
     * 判断当前用户是否是普通员工
     * @return
     */
    public static boolean isEmployee() {
        return getSubject().hasRole("员工");
    }



    /**
     * 查询当前登录者 用户名
     * @return
     */
    public static String getCurrentUserName() {
        return getCurrentUser().getUsername();
    }
    /**
     * 查询当前登录者 用户Id
     * @return
     */
    public static Integer getCurrentUserId() {
        return getCurrentUser().getId();
    }

}
