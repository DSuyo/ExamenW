package com.spring.boot.wolloxtest.Entities;

import com.spring.boot.wolloxtest.Entities.keys.AlbumUserId;

import javax.persistence.*;

@Entity
@Table(name = "albums_user")
@IdClass(AlbumUserId.class)
public class AlbumUser {

    @Id
    private Long albumId;

    @Id
    private Long userId;

    @Id
    @ManyToOne
    @JoinColumn(name = "authority_name")
    private Authority authority;

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
