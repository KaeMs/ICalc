package com.gmg.icalc;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;

import com.gmg.icalc.utils.APIConstants;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by GMG-Developer on 8/28/2017.
 */

public class LoginAPIFunc extends AsyncTask<LoginAPI, Integer, LoginAPIResult> {
    private LoginAPIIntf delegate;
    private Context context;
    private ProgressDialog progressDialog;

    public LoginAPIFunc(Context context, LoginAPIIntf delegate) {
        this.context = context;
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.logging_in));
        progressDialog.setIndeterminate(true);
        progressDialog.setIndeterminateDrawable(ContextCompat.getDrawable(context, R.drawable.progressbar_lightgreen100));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected LoginAPIResult doInBackground(LoginAPI... params) {
        LoginAPIResult loginAPIResult = new LoginAPIResult();
        try {
            String url = APIConstants.API_URL + APIConstants.LOGIN;

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(APIConstants.connectTimeout, TimeUnit.SECONDS)
                    .writeTimeout(APIConstants.writeTimeout, TimeUnit.SECONDS)
                    .readTimeout(APIConstants.readTimeout, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder()
                    .add("email", params[0].email)
                    .add("password", params[0].password)
                    .add("device_imei", params[0].device_imei)
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Accept", "application/json")
                    .post(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            String responseStr = APIUtils.getResponse(context, response.code(), response.body().string());
            loginAPIResult = new Gson().fromJson(responseStr, LoginAPIResult.class);
            loginAPIResult.status_code = response.code();
            response.body().close();
        } catch (Exception ex) {
            loginAPIResult.status_code = 504;
        }
        return loginAPIResult;
    }

    @Override
    protected void onPostExecute(LoginAPIResult loginAPIResult) {
        super.onPostExecute(loginAPIResult);
        progressDialog.dismiss();
        delegate.onFinishLogin(loginAPIResult);
    }
}
