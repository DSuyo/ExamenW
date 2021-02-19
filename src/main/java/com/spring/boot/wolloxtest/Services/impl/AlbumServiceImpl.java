package com.spring.boot.wolloxtest.Services.impl;

import com.spring.boot.wolloxtest.Clients.ExternalServiceClient;
import com.spring.boot.wolloxtest.Services.AlbumService;
import com.spring.boot.wolloxtest.mappers.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private ExternalServiceClient externalServiceClient;

    @Override
    public List<Album> getAlbums() {
        return this.externalServiceClient.getAlbums();
    }

    @Override
    public List<Album> getAlbumsByUserId(Long userId) {
        return this.externalServiceClient.getAlbumsByUserId(userId);
    }
}
