package tourism.network.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tourism.network.Traveller;

import java.util.List;

public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;

    @Select("select * from traveller")
    List<Traveller> findAll();
}
