package com.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.web.UserMethod;
import com.web.entity.User;

/**
 * User的action类
 */
public class UserAction extends ActionSupport{

    private User user;

    @Override
    public String execute() throws Exception {

        //判断是否为空
        if (user != null) {
            UserMethod userMethod = new UserMethod();
            //判断用户名是否重复
            User userQuery = userMethod.query(user.getUsername());
            //null为不存在,可以进行插入操作创建新用户
            if (userQuery == null) {
                boolean bool = userMethod.add(user);
                //插入操作是否成功
                if (bool) {
                    return SUCCESS;
                } else {
                    return ERROR;
                }
            } else {
                return "being";
            }
        }

        return LOGIN;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
