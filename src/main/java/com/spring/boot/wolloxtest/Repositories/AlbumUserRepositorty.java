package com.spring.boot.wolloxtest.Repositories;

import com.spring.boot.wolloxtest.Entities.AlbumUser;
import com.spring.boot.wolloxtest.Entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumUserRepositorty extends JpaRepository<AlbumUser, Long> {

    boolean existsByAlbumIdAndUserId(Long albumId, Long userId);

    boolean existsAlbumUserByAlbumId(Long albumId);

    List<AlbumUser> findAllByAlbumIdAndAuthoritiesIn(Long albumId, List<Authority> authorities);
}
