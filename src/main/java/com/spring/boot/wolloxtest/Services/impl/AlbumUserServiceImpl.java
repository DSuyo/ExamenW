package com.spring.boot.wolloxtest.Services.impl;

import com.spring.boot.wolloxtest.Clients.ExternalServiceClient;
import com.spring.boot.wolloxtest.Controllers.wrappers.AlbumUserWrapper;
import com.spring.boot.wolloxtest.Entities.AlbumUser;
import com.spring.boot.wolloxtest.Entities.Authority;
import com.spring.boot.wolloxtest.Exceptions.AuthorityException;
import com.spring.boot.wolloxtest.Repositories.AlbumUserRepositorty;
import com.spring.boot.wolloxtest.Repositories.AuthorityResponsitorty;
import com.spring.boot.wolloxtest.Services.AlbumUserService;
import com.spring.boot.wolloxtest.mappers.Album;
import com.spring.boot.wolloxtest.mappers.User;
import com.spring.boot.wolloxtest.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AlbumUserServiceImpl implements AlbumUserService {

    @Autowired
    private ExternalServiceClient externalServiceClient;

    @Autowired
    private AlbumUserRepositorty albumUserRepositorty;

    @Autowired
    private AuthorityResponsitorty authorityResponsitorty;

    public AlbumUserServiceImpl() {
    }

    @Override
    public AlbumUserWrapper createAlbumUser(Album album, User user, List<String> authorities) throws AuthorityException {

        User userClient = this.externalServiceClient.getUserById(user.getId());

        Album albumClient = this.externalServiceClient.getAlbumById(album.getId());

        AlbumUser albumUser = new AlbumUser();

        albumUser.setAlbumId( album.getId() );
        albumUser.setUserId( user.getId());

        if(authorities == null || authorities.isEmpty()){
            Authority authority = new Authority(Constants.LECTURA);
            albumUser.addAuthority(authority);
        }
        else if( this.authorityResponsitorty.existsAuthorityByAuthorityNameIn(authorities) ){

            for (String auth: authorities) {
                albumUser.addAuthority( new Authority(auth));
            }
        } else
            throw new AuthorityException("Authority not exists");

        this.albumUserRepositorty.save(albumUser);


        return new AlbumUserWrapper(albumClient, userClient, authorities);


    }

    @Override
    public AlbumUser updateAuthorities(Album album, User user, List<Authority> authorities) {
        return null;
    }
}
