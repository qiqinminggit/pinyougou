package tourism.network.dao;

import org.apache.ibatis.annotations.Select;
import tourism.network.Hotel;

import java.util.List;

public interface IHotelDao {
    @Select("select * from hotelmess")
    List<Hotel> findAll() throws Exception;
}
