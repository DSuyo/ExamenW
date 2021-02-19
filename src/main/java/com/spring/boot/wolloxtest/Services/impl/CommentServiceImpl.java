package com.spring.boot.wolloxtest.Services.impl;

import com.spring.boot.wolloxtest.Clients.ExternalServiceClient;
import com.spring.boot.wolloxtest.Services.CommentService;
import com.spring.boot.wolloxtest.mappers.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ExternalServiceClient externalServiceClient;

    @Override
    public List<Comment> getComments(String name, String email) {
        return this.externalServiceClient.getComments(name, email);
    }
}
