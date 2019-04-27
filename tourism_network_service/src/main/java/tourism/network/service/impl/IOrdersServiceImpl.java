package tourism.network.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tourism.network.Orders;
import tourism.network.dao.IOrdersDao;
import tourism.network.service.IOrdersService;

import java.util.List;
@Service
@Transactional
public class IOrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao iOrdersDao;
    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //参数pageNum是页码值，参数pageSize代表每页显示条数
        PageHelper.startPage(page, size);
        return  iOrdersDao.findAll();
    }
    @Override
    public Orders findById(String ordersId) throws Exception {
        return iOrdersDao.finById(ordersId);
    }

    @Override
    public void delete(String id) throws  Exception{
        iOrdersDao.delete(id);
    }
}
