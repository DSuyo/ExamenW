package com.spring.boot.wolloxtest.Services;

import com.spring.boot.wolloxtest.Controllers.wrappers.AlbumUserWrapper;
import com.spring.boot.wolloxtest.Exceptions.AlbumUserException;
import com.spring.boot.wolloxtest.Exceptions.AuthorityException;
import com.spring.boot.wolloxtest.mappers.Album;
import com.spring.boot.wolloxtest.mappers.User;

import java.util.List;

public interface AlbumUserService {

    AlbumUserWrapper createAlbumUser(Album album, User user, List<String> authorities) throws AuthorityException;

    void updateAuthorities(Album album, User user, List<String> authorities) throws AlbumUserException, AuthorityException;

    List<User> getUsersByAlbumAndAuthority(String authority, Long albumId) throws AlbumUserException, AuthorityException;
}
