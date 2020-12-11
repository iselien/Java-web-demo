package io.yovelas;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.yovelas.model.JsonBean;
import io.yovelas.model.RobotLive;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class HttpClient {

    private static final int TIMEOUT = 50000;
    private static HttpClient sInstance;
    private OkHttpClient mOkHttpClient;
    private String mUrl;

    private HttpClient() {
        mUrl = "https://jianzhengmx.com/api/public/?service=";
    }

    public static HttpClient getInstance() {
        if (sInstance == null) {
            synchronized (HttpClient.class) {
                if (sInstance == null) {
                    sInstance = new HttpClient();
                }
            }
        }
        return sInstance;
    }

    public void init(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS);
        builder.readTimeout(TIMEOUT, TimeUnit.MILLISECONDS);
        builder.writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS);
        builder.retryOnConnectionFailure(true);
        mOkHttpClient = builder.build();
    }

    /**
     * 获取主播，机器用户
     */
    public RobotLive getRobotLive() throws IOException {
        Response response = null;
        response = mOkHttpClient.newCall(new Request.Builder()
                .url("https://zhibo.jianzhengmx.com/api/public/?service=Live.getliveAll&isuser=1").build())
                .execute();
        String string = response.body().string();
        JsonBean jsonBean = JSON.parseObject(string, JsonBean.class);
        RobotLive robotLive = JSON.parseObject(jsonBean.getData().getInfo(), RobotLive.class);
        return robotLive;

    }

}
