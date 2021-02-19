package com.spring.boot.wolloxtest.Services;

import com.spring.boot.wolloxtest.mappers.Album;

import java.util.List;

public interface AlbumService {

    List<Album> getAlbums();
    List<Album> getAlbumsByUserId(Long userId);
}
