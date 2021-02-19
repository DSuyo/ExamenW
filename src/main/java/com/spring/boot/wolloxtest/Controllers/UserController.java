package com.spring.boot.wolloxtest.Controllers;

import com.spring.boot.wolloxtest.Exceptions.AlbumUserException;
import com.spring.boot.wolloxtest.Exceptions.AuthorityException;
import com.spring.boot.wolloxtest.Exceptions.UserException;
import com.spring.boot.wolloxtest.Services.AlbumUserService;
import com.spring.boot.wolloxtest.Services.UserService;
import com.spring.boot.wolloxtest.mappers.User;

import feign.FeignException.FeignClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("api/users")
public class UserController {

    private final Logger logger = Logger.getLogger(UserController.class.toString());

    @Autowired
    private UserService userService;

    @Autowired
    private AlbumUserService albumUserService;

    @GetMapping("")
    public ResponseEntity<?> getUsers(@RequestParam(required = false) String authority, @RequestParam(required = false) Long albumId){

        logger.info("get all users");
        List<User> users;

        try {

            if(authority!=null && albumId != null)
                users = this.albumUserService.getUsersByAlbumAndAuthority(authority, albumId);
            else
                users = this.userService.getUsers();

            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (FeignClientException e) {

            e.printStackTrace();
            logger.info("Users not found");
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Users not found", e );

        } catch (AlbumUserException e) {

            e.printStackTrace();
            logger.info(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);

        } catch (AuthorityException e) {

            e.printStackTrace();
            logger.info(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Internal server error");
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id ){
        logger.info("get users by id");

        try {
            User user = this.userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);

        }
        catch (FeignClientException e) {
            e.printStackTrace();
            logger.info("User not found");
            throw new ResponseStatusException( e.status(), "Feign User not found", e );
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.info("Internal server error");
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e );
        }

    }
}
