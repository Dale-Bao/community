package dale.springboot.dto;

import lombok.Data;

/**
 * @author xueneng on 2019/11/7.
 *         Description:
 */
@Data
public class GithubUser {
    private String name;
    private long id;
    private String bio;
    private String avatarUrl;
}
