package dale.springboot.controller;

import dale.springboot.dto.AccessTokenDTO;
import dale.springboot.dto.GithubUser;
import dale.springboot.mapper.UserMapper;
import dale.springboot.model.User;
import dale.springboot.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author xueneng on 2019/11/7.
 *         Description:
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String id;

    @Value("${github.client.secret}")
    private String secret;

    @Value("${github.redirect.uri}")
    private String uri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                           @RequestParam("state") String state,
                            HttpServletRequest request
                             ){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(id);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser =githubProvider.getUser(accessToken);
        if(githubUser != null){
            request.getSession().setAttribute("user",githubUser);
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
}
