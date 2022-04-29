package me.matej.hikingtrailmapper.controller;

import me.matej.hikingtrailmapper.contracts.CreateTrailRequest;
import me.matej.hikingtrailmapper.model.Trail;
import me.matej.hikingtrailmapper.service.TrailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trail")
public class TrailController {
    private final TrailService trailService;

    public TrailController(TrailService trailService) {
        this.trailService = trailService;
    }

    @GetMapping
    public List<Trail> getAll() {
        return trailService.getTrails();
    }

    @GetMapping("/{userId}")
    public List<Trail> getMy(@RequestParam Long userId) {
        return trailService.getMyTrails(userId);
    }

    @PostMapping("/{userId}")
    public Trail create(@RequestParam Long userId, @RequestBody CreateTrailRequest request) {
        return trailService.createTrail(userId, request);
    }

    @PutMapping("/{userId}/{trailId}")
    public Trail update(@RequestParam Long userId, @RequestParam Long trailId, @RequestBody CreateTrailRequest request) {
        return trailService.updateTrail(userId, trailId, request);
    }

    @DeleteMapping("/{userId}/{trailId}")
    public Trail delete(@RequestParam Long userId, @RequestParam Long trailId) {
        return trailService.deleteTrail(userId, trailId);
    }
}
