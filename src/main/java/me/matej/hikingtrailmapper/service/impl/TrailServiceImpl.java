package me.matej.hikingtrailmapper.service.impl;

import me.matej.hikingtrailmapper.contracts.CreateTrailRequest;
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
    public List<Trail> getTrails() {
        return toList(trailRepo.findAll());
    }

    @Override
    public List<Trail> getMyTrails(Long userId) {
        return toList(trailRepo.findByUser_IdIs(userId));
    }

    @Override
    public Trail createTrail(Long userId, CreateTrailRequest request) {
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
                request.isWaterAvailability());

        return trailRepo.save(trail);
    }

    @Override
    public Trail updateTrail(Long userId, Long trailId, CreateTrailRequest request) {
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

        return trailRepo.save(trail.get());
    }

    @Override
    public Trail deleteTrail(Long userId, Long trailId) {
        trailRepo.deleteByUser_IdAndId(userId, trailId);

        return null;
    }

    private List<Trail> toList(Iterable<Trail> iter) {
        return StreamSupport
                .stream(iter.spliterator(), false)
                .collect(Collectors.toList());
    }
}
