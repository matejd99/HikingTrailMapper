package me.matej.hikingtrailmapper.repository;

import me.matej.hikingtrailmapper.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    long deleteByUser_IdAndId(Long userId, Long commentId);
}
