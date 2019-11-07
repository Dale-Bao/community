package dale.springboot.dto;

import lombok.Data;

/**
 * @author xueneng on 2019/11/7.
 *         Description:
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
