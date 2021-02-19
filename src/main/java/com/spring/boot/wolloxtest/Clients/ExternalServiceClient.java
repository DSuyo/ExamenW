package com.spring.boot.wolloxtest.Clients;

import com.spring.boot.wolloxtest.mappers.Album;
import com.spring.boot.wolloxtest.mappers.Comment;
import com.spring.boot.wolloxtest.mappers.Photo;
import com.spring.boot.wolloxtest.mappers.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "externalServiceClient", url="${external-service.url}")
public interface ExternalServiceClient {

    @GetMapping("/users")
    List<User> getUsers();

    @GetMapping("/photos")
    List<Photo> getPhotos();

    @GetMapping("/albums")
    List<Album> getAlbums();

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);

    @GetMapping("/albums/{id}")
    Album getAlbumById(@PathVariable("id") Long id);

    @GetMapping("/users/{id}/albums")
    List<Album> getAlbumsByUserId(@PathVariable("id") Long id);

    @GetMapping("/comments")
    List<Comment> getComments(@RequestParam(required = false) String name, @RequestParam(required = false) String email);
}
