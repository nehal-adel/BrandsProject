package com.brands.dto;

import com.brands.dao.Users;

import java.util.List;

public class UserImp implements UserDto {

    @Override
    public boolean addCredit(String code) {
        return false;
    }

    @Override
    public boolean updateCreditWhenBuying(int user_id) {
        return false;
    }

    @Override
    public boolean addUser(Users user) {
        return false;
    }

    @Override
    public boolean updateUser(Users user) {
        return false;
    }

    @Override
    public Users getUserById(int id) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return null;
    }

    @Override
    public boolean login(Users user) {
        return false;
    }

    @Override
    public boolean register(Users user) {
        return false;
    }

    @Override
    public boolean isExist(Users user) {
        return false;
    }

    @Override
    public boolean logOut(Users user) {
        return false;
    }
}
