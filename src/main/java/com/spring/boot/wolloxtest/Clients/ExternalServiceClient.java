package com.spring.boot.wolloxtest.Clients;

import com.spring.boot.wolloxtest.mappers.Album;
import com.spring.boot.wolloxtest.mappers.Photo;
import com.spring.boot.wolloxtest.mappers.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "externalServiceClient", url="${external-service.url}")
public interface ExternalServiceClient {

    @GetMapping("/users")
    List<User> getUsers();

    @GetMapping("/photos")
    List<User> getPhotos();

    @GetMapping("/albums")
    List<Album> getAlbums();

    /**
     *
     * @param id
     * @return User
     */
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);

    /**
     *
     * @param id
     * @return Album
     */
    @GetMapping("/albums/{id}")
    Album getAlbumById(@PathVariable("id") Long id);

    @GetMapping("/users/{id}/albums")
    List<Photo> getAlbumsByUserId(@PathVariable("id") Long id);



}
