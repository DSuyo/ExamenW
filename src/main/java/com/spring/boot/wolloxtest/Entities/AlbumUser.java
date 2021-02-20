package com.spring.boot.wolloxtest.Entities;

import com.spring.boot.wolloxtest.Entities.keys.AlbumUserId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album_user")
@IdClass(AlbumUserId.class)
public class AlbumUser {

    @Id
    @Column(name = "album_id")
    private Long albumId;

    @Id
    @Column(name = "user_id")
    private Long userId;

    @ManyToMany
    @JoinTable(
            name = "album_user_authority",
            joinColumns = {
                    @JoinColumn(name = "album_id", referencedColumnName = "album_id"),
                    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "authority_name", referencedColumnName = "authority_name")
            }
    )
    private List<Authority> authorities;

    public AlbumUser() {
    }

    public AlbumUser(Long albumId, Long userId, List<Authority> authorities) {
        this.albumId = albumId;
        this.userId = userId;
        this.authorities = authorities;
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

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public void addAuthority(Authority authority){

        if ( this.authorities == null)
            this.authorities = new ArrayList<>();

        this.getAuthorities().add(authority);
    }
}
