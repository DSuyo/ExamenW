package com.spring.boot.wolloxtest.entities;

import com.spring.boot.wolloxtest.entities.keys.AlbumUserId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "albums_user")
@IdClass(AlbumUserId.class)
public class AlbumUser {

    @Id
    private Long albumId;

    @Id
    private Long userId;

    public AlbumUser() {
    }

    public AlbumUser(Long albumId, Long userId) {
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
