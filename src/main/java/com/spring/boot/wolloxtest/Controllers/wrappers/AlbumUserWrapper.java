package com.spring.boot.wolloxtest.Controllers.wrappers;

import com.spring.boot.wolloxtest.Entities.Authority;
import com.spring.boot.wolloxtest.mappers.Album;
import com.spring.boot.wolloxtest.mappers.User;

import java.util.List;

public class AlbumUserWrapper {

    private Album album;

    private User user;

    private List<String> authorities;


    public AlbumUserWrapper() {
    }

    public AlbumUserWrapper(Album album, User user, List<String> authorities) {
        this.album = album;
        this.user = user;
        this.authorities = authorities;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
