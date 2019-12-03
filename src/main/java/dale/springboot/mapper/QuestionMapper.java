package dale.springboot.mapper;

import dale.springboot.model.Question;
import org.apache.ibatis.annotations.Insert;

/**
 * @author xueneng on 2019/12/3.
 *         Description:
 */
public class QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values ({#title},{#description},{#gmt_create},{#gmt_modified},{#creator},{#tag})")
    public void create(Question question){

    }
}
