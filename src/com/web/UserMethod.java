package com.web;

import com.web.entity.User;
import com.web.util.DBUtil;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class UserMethod {

    /**
     * 查询用户是否存在
     * @param username 用户名
     * @return User
     */
    public User query (String username) {
        String sql = "select * from users where username=?";
        List<Map<String, String>> list = DBUtil.query(sql, username);
        User user = null;
        if (list != null && !list.isEmpty()) {
            user = new User();
            try {
                BeanUtils.populate(user, list.get(0));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public boolean add(User user) {
        String sql = "insert into users(username, password, sex, birthday, hobby) values (?,?,?,?,?)";
        Object[] obj = {user.getUsername(), user.getPassword(), user.getSex(), user.getBirthday(), user.getHobby()};
        Integer result = DBUtil.insert(sql, obj);
        if (result != null && result > 0) {
            return true;
        }
        return false;
    }
}
