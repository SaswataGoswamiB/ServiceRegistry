package com.Service.HotelService.services;



import java.util.List;

import com.Service.HotelService.Entity.Hotel;

public interface HotelService {

    //create

    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);

}