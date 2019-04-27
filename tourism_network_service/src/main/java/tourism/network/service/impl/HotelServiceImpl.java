package tourism.network.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tourism.network.Hotel;
import tourism.network.dao.IHotelDao;
import tourism.network.service.IHotelService;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private IHotelDao hotelDao;
    @Override
    public List<Hotel> findAll() throws Exception {
        return hotelDao.findAll();
    }
}
