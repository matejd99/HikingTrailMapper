package me.matej.hikingtrailmapper.service;

import me.matej.hikingtrailmapper.contracts.CreateTrailRequest;
import me.matej.hikingtrailmapper.dtos.TrailDto;

import java.util.List;

public interface TrailService { List<TrailDto> getTrails();
    TrailDto getTrail(Long trailId);
    List<TrailDto> getMyTrails(Long userId);
    TrailDto createTrail(Long userId, CreateTrailRequest request);
    TrailDto updateTrail(Long userId, Long trailId, CreateTrailRequest request);
    TrailDto deleteTrail(Long userId, Long trailId);
}
