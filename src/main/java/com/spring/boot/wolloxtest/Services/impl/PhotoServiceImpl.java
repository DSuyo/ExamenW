package com.spring.boot.wolloxtest.Services.impl;

import com.spring.boot.wolloxtest.Clients.ExternalServiceClient;
import com.spring.boot.wolloxtest.Services.PhotoService;
import com.spring.boot.wolloxtest.mappers.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private ExternalServiceClient externalServiceClient;

    @Override
    public List<Photo> getPhotos() {
        return this.externalServiceClient.getPhotos();
    }
}
