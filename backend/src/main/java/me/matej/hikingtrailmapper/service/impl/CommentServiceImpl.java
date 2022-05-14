package me.matej.hikingtrailmapper.service.impl;

import me.matej.hikingtrailmapper.contracts.CreateCommentRequest;
import me.matej.hikingtrailmapper.dtos.CommentDto;
import me.matej.hikingtrailmapper.model.Comment;
import me.matej.hikingtrailmapper.model.Trail;
import me.matej.hikingtrailmapper.model.User;
import me.matej.hikingtrailmapper.repository.CommentRepository;
import me.matej.hikingtrailmapper.repository.TrailRepository;
import me.matej.hikingtrailmapper.repository.UserRepository;
import me.matej.hikingtrailmapper.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final TrailRepository trailRepo;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(TrailRepository trailRepo, UserRepository userRepository, CommentRepository commentRepository) {
        this.trailRepo = trailRepo;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(Long userId, Long trailId, CreateCommentRequest request) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Trail> trail = trailRepo.findById(trailId);

        if (user.isEmpty() || trail.isEmpty()) {
            // TODO throw something
        }

        // TODO comment validations

        Comment comment = new Comment(request.getComment(), user.get(), trail.get());

        return commentRepository.save(comment).toDto();
    }

    @Override
    public CommentDto updateComment(Long userId, Long commentId, CreateCommentRequest request) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            // TODO throw something
        }

        Optional<Comment> comment = commentRepository.findById(commentId);

        if (comment.isEmpty()) {
            // TODO throw something
        }

        // TODO comment validations

        comment.get().setComment(request.getComment());

        return commentRepository.save(comment.get()).toDto();
    }

    @Override
    public CommentDto deleteComment(Long userId, Long commentId) {
        commentRepository.deleteByUser_IdAndId(userId, commentId);

        return null;
    }
}
