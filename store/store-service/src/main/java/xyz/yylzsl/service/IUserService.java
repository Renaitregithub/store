package xyz.yylzsl.service;

import xyz.yylzsl.pojo.User;

import java.util.List;

/**
 * 用户业务层
 */
public interface IUserService {

    void regist(User user) throws Exception;

    void activeUser(String code) throws Exception;

    User findByUserAndPassword(User user) throws Exception;

    User findByUsername(String username);

    List<User> findAll(Integer page,Integer pageSize);

    void delete(String uid);

    User findbyUid(String uid);

    void update(User user);
}
