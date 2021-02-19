package com.spring.boot.wolloxtest.Services;

import com.spring.boot.wolloxtest.Controllers.wrappers.AlbumUserWrapper;
import com.spring.boot.wolloxtest.Entities.AlbumUser;
import com.spring.boot.wolloxtest.Entities.Authority;
import com.spring.boot.wolloxtest.Exceptions.AuthorityException;
import com.spring.boot.wolloxtest.mappers.Album;
import com.spring.boot.wolloxtest.mappers.User;

import java.util.List;

public interface AlbumUserService {

    AlbumUserWrapper createAlbumUser(Album album, User user, List<String> authorities) throws AuthorityException;

    AlbumUser updateAuthorities(Album album, User user, List<Authority> authorities);
}
