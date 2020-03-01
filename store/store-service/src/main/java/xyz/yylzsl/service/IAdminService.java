package xyz.yylzsl.service;

import xyz.yylzsl.pojo.Admin;

public interface IAdminService {

    Admin login(Admin admin);

    void updateUser(Admin admin);

    Admin findById(String id);
}
