package com.spring.boot.wolloxtest.Entities.keys;

import java.io.Serializable;

public class AlbumUserId implements Serializable {

    private Long albumId;

    private Long userId;

    private String authorityName;

    public AlbumUserId(Long albumId, Long userId, String authorityName) {
        this.albumId = albumId;
        this.userId = userId;
        this.authorityName = authorityName;
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

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
}
