package dale.springboot.provider;

import com.alibaba.fastjson.JSON;
import dale.springboot.dto.AccessTokenDTO;
import dale.springboot.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author xueneng on 2019/11/7.S
 *         Description:
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO asccessTokenDTO){
       MediaType mediaType = MediaType.get("application/json; charset=utf-8");
       OkHttpClient client = new OkHttpClient();
       RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(asccessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string =  response.body().string();
                String token = string.split("&")[0].split("=")[1];
                return token;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return  null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.github.com/user?access_token="+accessToken).build();
        try {
            Response response = client.newCall(request).execute();
             String string = response.body().string();
             GithubUser user = JSON.parseObject(string,GithubUser.class);
             return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
