package com.spring.boot.wolloxtest.Controllers;

import com.spring.boot.wolloxtest.Services.PhotoService;
import com.spring.boot.wolloxtest.mappers.Photo;
import feign.FeignException.FeignClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/photos")
public class PhotoController {

    private final Logger logger = Logger.getLogger(PhotoController.class.toString());

    @Autowired
    private PhotoService photoService;

    @GetMapping("")
    public ResponseEntity<?> getPhotos(){
        logger.info("get all photos");

        try {

            List<Photo> photos = this.photoService.getPhotos();
            return new ResponseEntity<>(photos, HttpStatus.OK);

        }

        catch (FeignClientException e){
            e.printStackTrace();
            logger.info("Error obtaining photos");
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Error obtaining photos", e );
        }

        catch (Exception e) {
            e.printStackTrace();
            logger.info("Users not found");
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e );
        }
    }
}
