package com.spring.boot.wolloxtest.Services;

import com.spring.boot.wolloxtest.mappers.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments( String name, String email );
}
