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
        //查询用户是否存在，存在时list则会有数据
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

    /**
     * 添加用户
     * @param user User类
     * @return boolean
     */
    public boolean add(User user) {
        String sql = "insert into users(username, password, sex, birthday, hobby) values (?,?,?,?,?)";
        Object[] obj = {user.getUsername(), user.getPassword(), user.getSex(), user.getBirthday(), user.getHobby()};
        //调用DBUtil方法，返回插入的ID
        Integer result = DBUtil.insert(sql, obj);
        //判断ID是否大于0或不为NULL，大于0或不为NULL说明添加成功
        if (result != null && result > 0) {
            return true;
        }
        return false;
    }
}
