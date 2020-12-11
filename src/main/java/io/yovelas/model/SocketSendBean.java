package io.yovelas.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SocketSendBean {

    private JSONObject mResult;
    private JSONArray mMsg;
    private JSONObject mMsg0;

    public SocketSendBean() {
        mResult = new JSONObject();
        mMsg = new JSONArray();
        mMsg0 = new JSONObject();
    }

    public SocketSendBean param(String key, String value) {
        try {
            mMsg0.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public SocketSendBean param(String key, int value) {
        return param(key, String.valueOf(value));
    }

    public SocketSendBean param(String key, JSONObject value) {
        try {
            mMsg0.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public SocketSendBean paramJsonObject(String key, String value) {
        try {
            mMsg0.put(key, new JSONObject(value));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JSONObject create() {
        try {
            mMsg.put(mMsg0);
            mResult.put("retcode", "000000");
            mResult.put("retmsg", "ok");
            mResult.put("msg", mMsg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mResult;
    }
}

