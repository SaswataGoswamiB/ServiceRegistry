package com.Service.HotelService.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Service.HotelService.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}