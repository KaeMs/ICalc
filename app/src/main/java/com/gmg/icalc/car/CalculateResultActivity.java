package com.gmg.icalc.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.gmg.icalc.APIUtils;
import com.gmg.icalc.BaseActivity;
import com.gmg.icalc.CustomViews.CustomFontButton;
import com.gmg.icalc.CustomViews.CustomFontEditText;
import com.gmg.icalc.CustomViews.CustomFontTextView;
import com.gmg.icalc.InsuranceTypeContent;
import com.gmg.icalc.MainActivity;
import com.gmg.icalc.R;
import com.gmg.icalc.ResponseAPI;
import com.gmg.icalc.car.api.FuncSendApplication;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by KM on 8/21/2017. IC
 */

public class CalculateResultActivity extends BaseActivity implements FuncSendApplication.SendApplicationIntf {

    @BindView(R.id.calculate_result_vehicle_type)
    CustomFontTextView vehicleType;
    @BindView(R.id.calculate_result_total_premi)
    CustomFontTextView premi;
    @BindView(R.id.calculate_result_insurance_type)
    CustomFontTextView insuranceType;

    @BindView(R.id.calculate_result_email_til)
    TextInputLayout emailTil;
    @BindView(R.id.calculate_result_email_et)
    CustomFontEditText email;
    @BindView(R.id.calculate_result_send_application)
    CustomFontButton sendApplication;

    private boolean sendPressed = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_result);

        final String calcResExtra = getIntent().getStringExtra(CalculateResultModel.CALC_RESULT_EXTRA);
        final CalculateResultModel calculateResultModel = new Gson().fromJson(calcResExtra, CalculateResultModel.class);

        vehicleType.setText(calculateResultModel.getKategori_kendaraan());
        premi.setText(getString(R.string.premi_colon, calculateResultModel.getPremi()));
        insuranceType.setText(calculateResultModel.getJenis_asuransi());

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (sendPressed){
                    if (editable.length() == 0)
                        email.setError(getString(R.string.email_missing));
                    else
                        email.setError(null);
                }
            }
        });

        sendApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPressed = true;
                if (TextUtils.isEmpty(email.getText().toString())){
                    emailTil.setError(getString(R.string.email_missing));
                    return;
                } else {
                    emailTil.setError(null);
                }
                calculateResultModel.setUser_email(email.getText().toString());
                FuncSendApplication funcSendApplication =
                        new FuncSendApplication(CalculateResultActivity.this,
                                InsuranceTypeContent.getAppropiateUrl(calculateResultModel.getJenis_asuransi()), CalculateResultActivity.this);
                funcSendApplication.execute(calculateResultModel);
                sendApplication.setEnabled(false);
            }
        });
    }

    @Override
    public void onFinishSendApplication(ResponseAPI responseAPI) {
        if (responseAPI.status_code == APIUtils.SUCCESS) {
            sendApplication.setEnabled(true);
            Toast.makeText(this, getString(R.string.application_sent), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            sendApplication.setEnabled(true);
        }
    }
}
