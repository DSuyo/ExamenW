package com.spring.boot.wolloxtest.Services.impl;

import com.spring.boot.wolloxtest.Clients.ExternalServiceClient;
import com.spring.boot.wolloxtest.Controllers.wrappers.AlbumUserWrapper;
import com.spring.boot.wolloxtest.Entities.AlbumUser;
import com.spring.boot.wolloxtest.Entities.Authority;
import com.spring.boot.wolloxtest.Exceptions.AlbumUserException;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        else if( existAllAuthorities(authorities) ){

            for (String auth: authorities) {
                albumUser.addAuthority( new Authority(auth));
            }
        } else
            throw new AuthorityException("Authorities not exists");

        this.albumUserRepositorty.save(albumUser);


        return new AlbumUserWrapper(albumClient, userClient, authorities);


    }

    private boolean existAllAuthorities(List<String> authorities){
        return this.authorityResponsitorty.existsAuthorityByAuthorityNameIn(authorities);
    }

    @Override
    public void updateAuthorities(Album album, User user, List<String> authorities) throws AlbumUserException, AuthorityException {

        if( !existAlbumUser(album, user))
            throw new AlbumUserException("Error not exist album shared");

        else if(!existAllAuthorities(authorities))
            throw new AuthorityException("Error. Authorities not exists");
        else {
            AlbumUser albumUser = new AlbumUser();
            albumUser.setUserId(user.getId());
            albumUser.setAlbumId(album.getId());

            for ( String auth: authorities) {
                Authority authority = new Authority(auth);
                albumUser.addAuthority(authority);
            }

            albumUserRepositorty.save(albumUser);
        }
    }

    private boolean existAlbumUser( Album album, User user){
        return albumUserRepositorty.existsByAlbumIdAndUserId(album.getId(), user.getId());
    }

    public List<User> getUsersByAlbumAndAuthority(String authority, Long albumId) throws AlbumUserException, AuthorityException {

        Authority auth = new Authority( authority );
        List<User> users = new ArrayList<>();
        if( !existAlbumUserByAlbum(albumId))
            throw new AlbumUserException("Error. Not exist album user");

        else if( !existAllAuthorities( new ArrayList<>(Arrays.asList(authority) ) ))
            throw new AuthorityException("Error. Authorities not exists");

        else {
            List<AlbumUser> albumUsers = this.albumUserRepositorty.findAllByAlbumIdAndAuthoritiesIn( albumId, new ArrayList<>( Arrays.asList(auth)) );

            users = albumUsers.stream().map(
                    albumUser -> this.externalServiceClient.getUserById( albumUser.getUserId() )
            ).collect(Collectors.toList());

            return users;
        }
    }

    private boolean existAlbumUserByAlbum(Long albumId){
        return albumUserRepositorty.existsAlbumUserByAlbumId(albumId);
    }
}
