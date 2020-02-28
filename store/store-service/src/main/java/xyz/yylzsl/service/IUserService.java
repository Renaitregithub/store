package xyz.yylzsl.service;

import xyz.yylzsl.pojo.User;

/**
 * 用户业务层
 */
public interface IUserService {

    void regist(User user) throws Exception;

    void activeUser(String code) throws Exception;

    User findByUserAndPassword(User user) throws Exception;

    User findByUsername(String username);
}
