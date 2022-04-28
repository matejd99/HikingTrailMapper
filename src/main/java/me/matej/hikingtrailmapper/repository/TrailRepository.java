package me.matej.hikingtrailmapper.repository;

import me.matej.hikingtrailmapper.model.Trail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrailRepository extends CrudRepository<Trail, Long> {
    List<Trail> findByUser_IdIs(Long id);
    long deleteByUser_IdAndId(Long userId, Long trailId);
}
