package tourism.network.service;

import tourism.network.Hotel;

import java.util.List;

public interface IHotelService {
    List<Hotel> findAll() throws Exception;
}
