package com.spring.boot.wolloxtest.Repositories;

import com.spring.boot.wolloxtest.Entities.AlbumUser;
import com.spring.boot.wolloxtest.Entities.keys.AlbumUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumUserRepositorty extends JpaRepository<AlbumUser, Long> {
}
