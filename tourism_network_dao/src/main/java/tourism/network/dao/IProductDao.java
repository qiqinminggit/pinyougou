package tourism.network.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tourism.network.Product;

import java.util.List;
public interface IProductDao {
    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id)throws Exception;


    //查询
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
    //增加
    @Insert("insert into product(roomNum,roomType,productPrice,productStatus,roomDesc) " +
            "values(#{roomNum},#{roomType},#{productPrice},#{productStatus},#{roomDesc})")
    void save(Product product);



}
