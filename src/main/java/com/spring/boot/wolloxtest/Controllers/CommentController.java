package com.spring.boot.wolloxtest.Controllers;

import com.spring.boot.wolloxtest.Services.CommentService;
import com.spring.boot.wolloxtest.mappers.Comment;
import feign.FeignException;
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
@RequestMapping("api/comments")
public class CommentController {

    private final Logger logger = Logger.getLogger(CommentController.class.toString());

    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public ResponseEntity<?> getComments(@RequestParam(required = false) String name, @RequestParam(required = false) String email){
        logger.info("get albums");

        try{
            List<Comment> comments = this.commentService.getComments(name, email);

            return new ResponseEntity<>( comments, HttpStatus.OK);

        } catch (FeignClientException e){
            e.printStackTrace();
            logger.info("Error obtaining comments");
            throw new ResponseStatusException( e.status(), "Error obtaining comments", e );

        } catch (Exception e){
            e.printStackTrace();
            logger.info("Internal server error");
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e );
        }

    }
}
