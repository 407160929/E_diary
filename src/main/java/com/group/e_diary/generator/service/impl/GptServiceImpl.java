package com.group.e_diary.generator.service.impl;

import com.group.common.utils.R;
import com.group.e_diary.generator.service.GptService;
import okhttp3.*;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.io.*;




@Service
public class GptServiceImpl implements GptService {

    public static final String API_KEY = "dVyXqtUx7po0C2dqOnvvq3dU";
    public static final String SECRET_KEY = "IhtIFBfjbx77qOQrI0POZT6oGiObu7mW";

    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    @Override
    public R get(String query) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"messages\":[{\"role\":\"user\",\"content\":\""+query+"\"}]}");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions_pro?access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());

        return R.ok().put("data", response.body().string());
    }

    /**
     * 从用户的AK，SK生成鉴权签名（Access Token）
     *
     * @return 鉴权签名（Access Token）
     * @throws IOException IO异常
     */
    static String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
                + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return new JSONObject(response.body().string()).getString("access_token");
    }
}
