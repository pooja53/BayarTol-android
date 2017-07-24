package com.upiki.bayartol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.upiki.bayartol.page.login.LoginAndRegisterActivity;
import com.upiki.bayartol.page.profile.ProfileFragment;

/**
 * Splash screen activity to check if local data exist.
 * @author Martino Christanto Khuangga <martino.aksel.11@gmail.com>
 * @since 2017.07.24
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences sp = getSharedPreferences(
                ProfileFragment.PROFILE,
                MODE_PRIVATE);
        String uid = sp.getString(ProfileFragment.UID, "");
        try {
            Thread.sleep(1000);
            if (uid.isEmpty()) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        LoginAndRegisterActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}