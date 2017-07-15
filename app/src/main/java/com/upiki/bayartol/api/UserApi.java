package com.upiki.bayartol.api;

import android.content.Context;

import com.upiki.bayartol.api.ApiClass.User;

import java.util.HashMap;
import java.util.Map;

public class UserApi extends Api {

    public void postRegisterUid(Context context, String email, String password, String name, String phone_number, String address, ApiListener<UserInfo> apiListener) {
        Map<String, String> form = new HashMap<>();
        form.put("role", "user");
        form.put("email", email);
        form.put("email", email);
        form.put("email", email);
        form.put("email", email);

        callGetApi(context, ApiConstanta.REGISTER, form, null, User.class, apiListener);
    }

    public void getUserProfile(Context context, ApiListener<UserInfo> apiListener) {

        callPostApi(context, ApiConstanta.GET_PROFILE, null, getHeaders(context), User.class, apiListener);
    }

    public class UserInfo extends Api<User> {}
}

