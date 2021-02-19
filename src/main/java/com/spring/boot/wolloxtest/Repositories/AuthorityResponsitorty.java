package com.spring.boot.wolloxtest.Repositories;

import com.spring.boot.wolloxtest.Entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityResponsitorty extends JpaRepository<Authority, String> {

    boolean existsAuthorityByAuthorityNameIn(List<String> authorities);
}
