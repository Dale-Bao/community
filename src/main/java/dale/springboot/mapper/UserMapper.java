package dale.springboot.mapper;

import dale.springboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xueneng on 2019/11/12.
 *         Description:
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}