package xyz.yylzsl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yylzsl.mapper.IUserMapper;
import xyz.yylzsl.pojo.User;
import xyz.yylzsl.service.IUserService;
import xyz.yylzsl.utils.MailUtils;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;


    @Override
    public void regist(User user) throws Exception {
        userMapper.save(user);
        MailUtils.sendMail(user.getEmail(),user.getCode());
    }

    @Override
    public void activeUser(String code) throws Exception {
        User user = userMapper.findByCode(code);
        if (user==null){
            throw new RuntimeException("用户激活码无效，请重试或重新发送激活邮件");
        }
        user.setState(1);
        user.setCode(null);
        userMapper.update(user);
    }

    @Override
    public User findByUserAndPassword(User user)  throws Exception {
        return userMapper.findByUserAndPassword(user);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
