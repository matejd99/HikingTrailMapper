package me.matej.hikingtrailmapper.service.impl;

import me.matej.hikingtrailmapper.contracts.CreateTrailRequest;
import me.matej.hikingtrailmapper.dtos.TrailDto;
import me.matej.hikingtrailmapper.model.Trail;
import me.matej.hikingtrailmapper.model.User;
import me.matej.hikingtrailmapper.repository.TrailRepository;
import me.matej.hikingtrailmapper.repository.UserRepository;
import me.matej.hikingtrailmapper.service.TrailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TrailServiceImpl implements TrailService {
    private final TrailRepository trailRepo;
    private final UserRepository userRepository;

    public TrailServiceImpl(TrailRepository trailRepo, UserRepository userRepository) {
        this.trailRepo = trailRepo;
        this.userRepository = userRepository;
    }

    @Override
    public List<TrailDto> getTrails() {
        return toList(trailRepo.findAll());
    }

    @Override
    public List<TrailDto> getMyTrails(Long userId) {
        return toList(trailRepo.findByUser_IdIs(userId));
    }

    @Override
    public TrailDto createTrail(Long userId, CreateTrailRequest request) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            // TODO throw something
        }

        // TODO trail validations

        Trail trail = new Trail(user.get(),
                request.getTrailName(),
                request.getTrailDescription(),
                request.getSuggestedGear(),
                request.getTrailLength(),
                request.getHikeDuration(),
                request.isWaterAvailability(),
                request.getPath());

        return trailRepo.save(trail).toDto();
    }

    @Override
    public TrailDto updateTrail(Long userId, Long trailId, CreateTrailRequest request) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            // TODO throw something
        }


        Optional<Trail> trail = trailRepo.findById(trailId);

        if (trail.isEmpty()) {
            // TODO throw something
        }

        if (trail.get().getUser().getId() != userId) {
            // TODO throw something
        }

        // TODO trail validations

        trail.get().setTrailName(request.getTrailName());
        trail.get().setTrailDescription(request.getTrailDescription());
        trail.get().setSuggestedGear(request.getSuggestedGear());
        trail.get().setTrailLength(request.getTrailLength());
        trail.get().setHikeDuration(request.getHikeDuration());
        trail.get().setWaterAvailability(request.isWaterAvailability());
        trail.get().setPath(request.getPath());

        return trailRepo.save(trail.get()).toDto();
    }

    @Override
    public TrailDto deleteTrail(Long userId, Long trailId) {
        trailRepo.deleteByUser_IdAndId(userId, trailId);

        return null;
    }

    private List<TrailDto> toList(Iterable<Trail> iter) {
        return StreamSupport
                .stream(iter.spliterator(), false)
                .map((t) -> t.toDto())
                .collect(Collectors.toList());
    }
}
