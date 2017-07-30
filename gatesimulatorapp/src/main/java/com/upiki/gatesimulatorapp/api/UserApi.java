package com.upiki.gatesimulatorapp.api;

import android.content.Context;

import com.upiki.gatesimulatorapp.api.ApiClass.MessageResponse;
import com.upiki.gatesimulatorapp.api.ApiClass.User;

import java.util.HashMap;
import java.util.Map;

public class UserApi extends Api {

    public void postRegisterUser(Context context, String email, String name, String phone_number, String address, ApiListener<User> apiListener) {
        Map<String, String> body = new HashMap<>();
        body.put("role", "user");
        body.put("email", email);
        body.put("name", name);
        body.put("phone_number", phone_number);
        body.put("address", address);

        callPostApi(context, ApiConstanta.REGISTER, null, body, null, User.class, apiListener);
    }

    public void postEditProfile(Context context, String uid, String email, String name, String phone_number, String address, ApiListener<MessageResponse> apiListener) {
        Map<String, String> body = new HashMap<>();
        body.put("uid", uid);
        body.put("email", email);
        body.put("name", name);
        body.put("phone_number", phone_number);
        body.put("address", address);
        callPostApi(context, ApiConstanta.EDIT, null, body, null, MessageResponse.class, apiListener);
    }

    public void getUserProfile(Context context, String uid, ApiListener<User> apiListener) {
        callGetApi(context, String.format(ApiConstanta.GET_PROFILE, uid), null, User.class, apiListener);
    }

    public void getUserId(Context context, String email, ApiListener<User> apiListener) {
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        callPostApi(context, ApiConstanta.LOGIN, null, body, null, User.class, apiListener);
    }

    public void getTollTransaction(Context context, String tid, String uid, ApiListener<MessageResponse> apiListener) {
        callGetApi(context, String.format(ApiConstanta.TOLL_TRANSACTION, uid, tid), null, MessageResponse.class, apiListener);
    }
}

