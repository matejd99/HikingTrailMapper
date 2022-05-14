package me.matej.hikingtrailmapper.controller;

import me.matej.hikingtrailmapper.contracts.CreateCommentRequest;
import me.matej.hikingtrailmapper.dtos.CommentDto;
import me.matej.hikingtrailmapper.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@CrossOrigin("http://localhost:4200")
public class CommentController {
    private final CommentService commentRepo;

    public CommentController(CommentService commentRepo) {
        this.commentRepo = commentRepo;
    }


    @PostMapping("/{userId}/{trailId}")
    public CommentDto create(@PathVariable Long userId, @PathVariable Long trailId, @RequestBody CreateCommentRequest request) {
        return commentRepo.createComment(userId, trailId, request);
    }

    @PutMapping("/{userId}/{commentId}")
    public CommentDto update(@PathVariable Long userId, @PathVariable Long commentId, @RequestBody CreateCommentRequest request) {
        return commentRepo.updateComment(userId, commentId, request);
    }

    @DeleteMapping("/{userId}/{commentId}")
    public CommentDto delete(@PathVariable Long userId, @PathVariable Long commentId) {
        return commentRepo.deleteComment(userId, commentId);
    }
}
