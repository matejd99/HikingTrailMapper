package me.matej.hikingtrailmapper.service;

import me.matej.hikingtrailmapper.contracts.CreateTrailRequest;
import me.matej.hikingtrailmapper.dtos.TrailDto;
import me.matej.hikingtrailmapper.model.Trail;

import java.util.List;

public interface TrailService {
    public List<TrailDto> getTrails();

    public List<TrailDto> getMyTrails(Long userId);

    public TrailDto createTrail(Long userId, CreateTrailRequest request);

    public TrailDto updateTrail(Long userId, Long trailId, CreateTrailRequest request);

    public TrailDto deleteTrail(Long userId, Long trailId);
}
