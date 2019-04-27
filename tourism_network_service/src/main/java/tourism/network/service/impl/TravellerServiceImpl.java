package tourism.network.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tourism.network.Traveller;
import tourism.network.dao.ITravellerDao;
import tourism.network.service.ITravellerService;

import java.util.List;

@Service
@Transactional
public class TravellerServiceImpl implements ITravellerService {

    @Autowired
    private ITravellerDao travellerDao;
    @Override
    public List<Traveller> findAll() {
        return travellerDao.findAll();
    }
}
