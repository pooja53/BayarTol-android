package com.upiki.bayartol.page.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.upiki.bayartol.R;
import com.upiki.bayartol.api.Api;
import com.upiki.bayartol.api.ApiClass.User;
import com.upiki.bayartol.api.BayarTolApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Login and Register activity.
 * @author Martino Christanto Khuangga <martino.aksel.11@gmail.com>
 * @since 2017.07.24
 */
public class LoginAndRegisterActivity extends AppCompatActivity {

    private EditText etEmail;
    private boolean isEmailExist = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);
        etEmail = (EditText) findViewById(R.id.login_email_field);
    }

    public void onSubmitClick(View view) {
        etEmail.setError(null);
        String email = etEmail.getText().toString();
        if (email.isEmpty()) {
            etEmail.setError(getString(R.string.error_field_required));
            return;
        }
        if (!isEmailValid(email)) {
            etEmail.setError(getString(R.string.error_email_format_invalid));
            return;
        }
        BayarTolApi.userApi.getUserId(getApplicationContext(), email, new Api.ApiListener<User>() {
            @Override
            public void onApiSuccess(User result, String rawJson) {
                Toast.makeText(getApplicationContext(), "Berhasil login " + result.name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onApiError(String errorMessage) {
                Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
                Log.d("LOGIN VOLLEY", errorMessage);
            }
        });
        if (isEmailExist) {
            login();
        } else {
            registerAndLogin();
        }
    }

    private boolean isEmailValid(String email) {
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }

    private void registerAndLogin() {

    }

    private void login() {
    }
}
