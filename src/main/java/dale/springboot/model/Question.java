package dale.springboot.model;

import lombok.Data;

/**
 * @author xueneng on 2019/12/3.
 *         Description:
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
