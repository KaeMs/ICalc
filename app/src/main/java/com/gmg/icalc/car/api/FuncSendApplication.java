package com.gmg.icalc.car.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;

import com.gmg.icalc.APIUtils;
import com.gmg.icalc.R;
import com.gmg.icalc.ResponseAPI;
import com.gmg.icalc.car.CalculateResultModel;
import com.gmg.icalc.utils.APIConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by KM on 10/16/2017. IC
 */

public class FuncSendApplication extends AsyncTask<CalculateResultModel, Integer, ResponseAPI> {
    private Context context;
    private ProgressDialog progressDialog;
    private SendApplicationIntf intf;

    public interface SendApplicationIntf {
        void onFinishSendApplication(ResponseAPI responseAPI);
    }

    public FuncSendApplication(Context context, SendApplicationIntf intf) {
        this.context = context;
        this.intf = intf;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.sending_application));
        progressDialog.setIndeterminate(true);
        progressDialog.setIndeterminateDrawable(ContextCompat.getDrawable(context, R.drawable.progressbar_lightgreen100));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected ResponseAPI doInBackground(CalculateResultModel... params) {
        ResponseAPI responseAPI = new ResponseAPI();
        try {
            String url = APIConstants.API_URL + APIConstants.SUBMIT_APPLICATION;

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(APIConstants.connectTimeout, TimeUnit.SECONDS)
                    .writeTimeout(APIConstants.writeTimeout, TimeUnit.SECONDS)
                    .readTimeout(APIConstants.readTimeout, TimeUnit.SECONDS)
                    .build();

            String premiModelStr = APIUtils.getJsonStrFromClass(params[0]);

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Accept", "application/json")
                    .post(APIUtils.getJsonRequestBody(premiModelStr))
                    .build();

            Response response = client.newCall(request).execute();
            responseAPI.status_response = APIUtils.getResponse(context, response.code(), response.body().string());
            responseAPI.status_code = response.code();
            response.body().close();
        } catch (Exception ex) {
            responseAPI.status_code = 504;
        }
        return responseAPI;
    }

    @Override
    protected void onPostExecute(ResponseAPI responseAPI) {
        super.onPostExecute(responseAPI);
        progressDialog.dismiss();
        intf.onFinishSendApplication(responseAPI);
    }
}
