package xyz.yylzsl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yylzsl.mapper.IAdminMapper;
import xyz.yylzsl.pojo.Admin;
import xyz.yylzsl.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminMapper mapper;

    @Override
    public Admin login(Admin admin) {
        return mapper.login(admin);
    }

    @Override
    public void updateUser(Admin admin) {
        mapper.update(admin);
    }

    @Override
    public Admin findById(String id) {
        return mapper.findById(id);
    }


}
