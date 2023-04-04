package com.photo.photoblog.controller;

import com.photo.photoblog.dao.entities.Comment;
import com.photo.photoblog.dao.entities.Photo;
import com.photo.photoblog.dao.entities.Users;
import com.photo.photoblog.dao.repository.CommentRepository;
import com.photo.photoblog.dao.repository.PhotoRepository;
import com.photo.photoblog.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("adminIndex")
    public ModelAndView adminHome(Model model) {
        List<Users> users = userRepository.findAll();
        List<Photo> photo = photoRepository.findAll();
        List<Comment> comment = commentRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute("photo", photo);
        model.addAttribute("comment", comment);

        ModelAndView mav = new ModelAndView("/adminIndex");
        return mav;
    }


}