package dale.springboot.controller;

import dale.springboot.dto.AccessTokenDTO;
import dale.springboot.dto.GithubUser;
import dale.springboot.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xueneng on 2019/11/7.
 *         Description:
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                           @RequestParam("state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("ae4d7b7f585c5d24f28f");
        accessTokenDTO.setClient_secret("aaf5f0e079bca8865cbb89cba6bab5d22ee60fc5");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user =githubProvider.getUser(accessToken);
        System.out.println(user);
        return "index";
    }
}
