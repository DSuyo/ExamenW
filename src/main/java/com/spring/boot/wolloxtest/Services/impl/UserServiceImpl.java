package com.spring.boot.wolloxtest.Services.impl;

import com.spring.boot.wolloxtest.Clients.ExternalServiceClient;
import com.spring.boot.wolloxtest.Exceptions.UserException;
import com.spring.boot.wolloxtest.Services.UserService;
import com.spring.boot.wolloxtest.mappers.User;
import feign.FeignException.FeignClientException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private ExternalServiceClient externalServiceClient;

    public UserServiceImpl(ExternalServiceClient externalServiceClient) {
        this.externalServiceClient = externalServiceClient;
    }

    @Override
    public List<User> getUsers() {
        return this.externalServiceClient.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return this.externalServiceClient.getUserById(id);
    }
}
