package tourism.network.service;

import tourism.network.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String ordersId) throws Exception;

    void delete(String id) throws Exception;
}
