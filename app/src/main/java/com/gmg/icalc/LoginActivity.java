package com.gmg.icalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.gmg.icalc.CustomViews.CustomFontButton;
import com.gmg.icalc.CustomViews.CustomFontEditText;
import com.gmg.icalc.utils.GeneralUtils;

import butterknife.BindView;

/**
 * Created by Kevin Murvie on 8/28/2017. IC
 */

public class LoginActivity extends BaseActivity implements LoginAPIIntf {
    @BindView(R.id.login_email)
    CustomFontEditText email;
    @BindView(R.id.login_pasword)
    CustomFontEditText password;
    @BindView(R.id.login_login_btn)
    CustomFontButton loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(LoginActivity.this, getString(R.string.complete_information_required), Toast.LENGTH_SHORT).show();
                } else {
                    LoginAPI loginAPI = new LoginAPI();
                    loginAPI.email = email.getText().toString();
                    loginAPI.password = password.getText().toString();
                    loginAPI.device_imei = GeneralUtils.getImei(LoginActivity.this);

                    LoginAPIFunc loginAPIFunc = new LoginAPIFunc(LoginActivity.this, LoginActivity.this);
                    loginAPIFunc.execute(loginAPI);
                }
            }
        });
    }

    @Override
    public void onFinishLogin(LoginAPIResult loginAPIResult) {
        if (loginAPIResult.status_code == 200){
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_ID, loginAPIResult.id);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_EMAIL, loginAPIResult.email);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_FIRST_NAME, loginAPIResult.first_name);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_LAST_NAME, loginAPIResult.last_name);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_AGENCY, loginAPIResult.agency);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_DATE_JOIN, loginAPIResult.date_join);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_DATE_EXPIRED, loginAPIResult.date_expired);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_PHOTO, loginAPIResult.photo);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_PHONE, loginAPIResult.phone);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_LICENSE, loginAPIResult.license);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_DEVICE_IMEI, loginAPIResult.device_imei);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_STATUS, loginAPIResult.status);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_CREATED_AT, loginAPIResult.created_at);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_UPDATED_AT, loginAPIResult.updated_at);
            SharedPreferenceUtilities.setUserInformation(this, SharedPreferenceUtilities.USER_API_TOKEN, loginAPIResult.api_token);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, getString(R.string.error_connection), Toast.LENGTH_SHORT).show();
        }
    }
}
