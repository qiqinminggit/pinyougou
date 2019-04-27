package tourism.network.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tourism.network.Product;
import tourism.network.dao.IProductDao;
import tourism.network.service.IProductService;

import java.util.List;
@Service
@Transactional
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product)throws  Exception {
        productDao.save(product);
    }


}
