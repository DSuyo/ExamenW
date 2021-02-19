package com.spring.boot.wolloxtest.Controllers;

import com.spring.boot.wolloxtest.Services.AlbumService;
import com.spring.boot.wolloxtest.mappers.Album;
import feign.FeignException.FeignClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/albums")
public class AlbumController {

    private final Logger logger = Logger.getLogger(AlbumController.class.toString());

    @Autowired
    private AlbumService albumService;

    @GetMapping("")
    public ResponseEntity<?> getAlbums(@RequestParam(required = false) Long userId){
        logger.info("get all albums");

        try {
            List<Album> albums = new ArrayList<>();

            if(userId == null)
                albums = this.albumService.getAlbums();
            else if ( userId != null)
                albums = this.albumService.getAlbumsByUserId(userId);

            return new ResponseEntity<>(albums, HttpStatus.OK);
        }
        catch (FeignClientException e){
            e.printStackTrace();
            logger.info("Error obtaining albums");
            throw new ResponseStatusException( e.status(), "Error obtaining albums", e );
        }
        catch ( Exception e){
            e.printStackTrace();
            logger.info("Internal server error");
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e );
        }
    }
}
