package com.spring.boot.wolloxtest.Controllers;

import com.spring.boot.wolloxtest.Controllers.wrappers.AlbumUserWrapper;
import com.spring.boot.wolloxtest.Services.AlbumUserService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/album-user")
public class AlbumUserController {

    private final Logger logger = Logger.getLogger(AlbumUserController.class.toString());

    @Autowired
    private AlbumUserService albumUserService;

    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody AlbumUserWrapper albumUserWrapper){
        logger.info("create album user and authority");
        try{
            AlbumUserWrapper albumUserWrapperResult = this.albumUserService.createAlbumUser(albumUserWrapper.getAlbum(), albumUserWrapper.getUser(), albumUserWrapper.getAuthorities());
            return new ResponseEntity<>(albumUserWrapperResult, HttpStatus.CREATED);
        }
        catch (FeignException.FeignClientException e){
            e.printStackTrace();
            logger.info("Error creating album user");
            throw new ResponseStatusException( e.status(), "Error creating album user", e );
        }
        catch (Exception e){
            e.printStackTrace();
            logger.info("Internal server error");
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e );
        }
    }
}
