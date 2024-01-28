package com.Rating.RatingService.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rating.RatingService.entities.Rating;
import com.Rating.RatingService.repositoy.RatingRepo;
import com.Rating.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    private RatingRepo repository;

    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}