package dale.springboot.model;

import lombok.Data;

/**
 * @author xueneng on 2019/11/12.
 *         Description:
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
}
