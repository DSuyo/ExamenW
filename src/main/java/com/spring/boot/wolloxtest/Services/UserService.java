package com.spring.boot.wolloxtest.Services;

import com.spring.boot.wolloxtest.Exceptions.UserException;
import com.spring.boot.wolloxtest.mappers.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUserById(Long id);

}
