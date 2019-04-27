package tourism.network.dao;

import org.apache.ibatis.annotations.Select;
import tourism.network.Member;

public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;

}
