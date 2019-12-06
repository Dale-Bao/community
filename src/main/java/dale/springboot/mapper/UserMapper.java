package dale.springboot.mapper;

import dale.springboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xueneng on 2019/11/12.
 *         Description:
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (name,account_id,token,avatar_url,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{avatar_url},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("SELECT * FROM USER WHERE TOKEN = #{token}")
    User findByToken(@Param("token") String token);
}