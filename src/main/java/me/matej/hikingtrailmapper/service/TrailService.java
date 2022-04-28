package me.matej.hikingtrailmapper.service;

import me.matej.hikingtrailmapper.contracts.CreateTrailRequest;
import me.matej.hikingtrailmapper.model.Trail;

import java.util.List;

public interface TrailService {
    public List<Trail> getTrails();

    public List<Trail> getMyTrails(Long userId);

    public Trail createTrail(Long userId, CreateTrailRequest request);

    public Trail updateTrail(Long userId, Long trailId, CreateTrailRequest request);

    public Trail deleteTrail(Long userId, Long trailId);
}
