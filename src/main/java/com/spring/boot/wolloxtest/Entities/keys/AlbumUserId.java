package com.spring.boot.wolloxtest.Entities.keys;

import java.io.Serializable;

public class AlbumUserId implements Serializable {

    private Long albumId;

    private Long userId;

    private String authority;

    public AlbumUserId(Long albumId, Long userId, String authorityName) {
        this.albumId = albumId;
        this.userId = userId;
        this.authority = authorityName;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
