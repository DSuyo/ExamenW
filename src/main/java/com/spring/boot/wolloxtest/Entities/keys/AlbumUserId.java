package com.spring.boot.wolloxtest.Entities.keys;

import java.io.Serializable;

public class AlbumUserId implements Serializable {

    private Long albumId;

    private Long userId;

    public AlbumUserId() {
    }

    public AlbumUserId(Long albumId, Long userId) {
        this.albumId = albumId;
        this.userId = userId;
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

}
