package com.spring.boot.wolloxtest.client;

import com.spring.boot.wolloxtest.Models.Album;
import com.spring.boot.wolloxtest.Models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "externalServiceClient", url="${external-service.url}")
public interface ExternalServiceClient {

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);

    @GetMapping("/albums/{id}")
    Album getAlbumById(@PathVariable("id") Long id);
}
