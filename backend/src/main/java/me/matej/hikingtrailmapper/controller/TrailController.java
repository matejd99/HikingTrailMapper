package me.matej.hikingtrailmapper.controller;

import me.matej.hikingtrailmapper.contracts.CreateTrailRequest;
import me.matej.hikingtrailmapper.dtos.TrailDto;
import me.matej.hikingtrailmapper.model.Trail;
import me.matej.hikingtrailmapper.service.TrailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trail")
@CrossOrigin("*")
public class TrailController {
    private final TrailService trailService;

    public TrailController(TrailService trailService) {
        this.trailService = trailService;
    }

    @GetMapping
    public List<TrailDto> getAll() {
        return trailService.getTrails();
    }

    @GetMapping("one/{trailId}")
    public TrailDto getOne(@PathVariable Long trailId) {
        return trailService.getTrail(trailId);
    }

    @GetMapping("/{userId}")
    public List<TrailDto> getMy(@PathVariable Long userId) {
        return trailService.getMyTrails(userId);
    }

    @PostMapping("/{userId}")
    public TrailDto create(@PathVariable Long userId, @RequestBody CreateTrailRequest request) {
        return trailService.createTrail(userId, request);
    }

    @PutMapping("/{userId}/{trailId}")
    public TrailDto update(@PathVariable Long userId, @PathVariable Long trailId, @RequestBody CreateTrailRequest request) {
        return trailService.updateTrail(userId, trailId, request);
    }

    @DeleteMapping("/{userId}/{trailId}")
    public TrailDto delete(@PathVariable Long userId, @PathVariable Long trailId) {
        return trailService.deleteTrail(userId, trailId);
    }
}
