package me.matej.hikingtrailmapper.service;

import me.matej.hikingtrailmapper.contracts.CreateCommentRequest;
import me.matej.hikingtrailmapper.dtos.CommentDto;

public interface CommentService {
    CommentDto createComment(Long userId, Long trailId, CreateCommentRequest request);
    CommentDto updateComment(Long userId, Long commentId, CreateCommentRequest request);
    CommentDto deleteComment(Long userId, Long commentId);
}
