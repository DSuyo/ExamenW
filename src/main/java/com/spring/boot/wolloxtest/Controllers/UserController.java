package com.spring.boot.wolloxtest.Controllers;

import com.spring.boot.wolloxtest.Exceptions.UserException;
import com.spring.boot.wolloxtest.Services.UserService;
import com.spring.boot.wolloxtest.mappers.User;

import feign.FeignException.FeignClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("api/users")
public class UserController {

    private final Logger logger = Logger.getLogger(UserController.class.toString());

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getUsers(){

        logger.info("get all users");

        try {
            List<User> users = this.userService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (FeignClientException e) {
            e.printStackTrace();
            logger.info("Users not found");
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Users not found", e );
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
