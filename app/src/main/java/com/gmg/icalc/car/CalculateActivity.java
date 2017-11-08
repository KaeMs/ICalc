package com.gmg.icalc.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.gmg.icalc.BaseActivity;
import com.gmg.icalc.CustomViews.CustomFontButton;
import com.gmg.icalc.CustomViews.CustomFontEditText;
import com.gmg.icalc.CustomViews.CustomFontRadioButton;
import com.gmg.icalc.CustomViews.CustomFontTextView;
import com.gmg.icalc.InsuranceTypeContent;
import com.gmg.icalc.R;
import com.gmg.icalc.SharedPreferenceUtilities;
import com.gmg.icalc.utils.CalculateUtils;
import com.gmg.icalc.utils.ViewUtils;
import com.google.gson.Gson;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;

/**
 * Created by KM on 8/15/2017. IC
 */

public class CalculateActivity extends BaseActivity {

    @BindView(R.id.calculate_vehicle_avatar)
    ImageView avatar;
    @BindView(R.id.calculate_vehicle_title)
    CustomFontTextView title;
    @BindView(R.id.calculate_vehicle_price)
    CustomFontEditText vehiclePriceET;
    @BindView(R.id.calculate_vehicle_manufacturer_til)
    TextInputLayout vehicleManufacturerTil;
    @BindView(R.id.calculate_vehicle_manufacturer_et)
    CustomFontEditText vehicleManufacturerET;
    @BindView(R.id.calculate_prospect_til)
    TextInputLayout prospectTil;
    @BindView(R.id.calculate_prospect_et)
    CustomFontEditText prospectET;
    @BindView(R.id.calculate_malerb)
    CustomFontRadioButton maleRb;
    @BindView(R.id.calculate_vehicle_category_spinner)
    Spinner categorySpinner;
    CalculateSpinnerAdapter categorySpinnerAdapter;
    @BindView(R.id.calculate_insurance_type_spinner)
    Spinner insuranceTypeSpinner;
    CalculateSpinnerAdapter insuranceTypeSpinnerAdapter;
    @BindView(R.id.calculate_vehicle_year_spinner)
    Spinner vehicleYearSpinner;
    CalculateSpinnerAdapter vehicleYearSpinnerAdapter;
    @BindView(R.id.calculate_region_spinner)
    Spinner regionSpinner;
    CalculateSpinnerAdapter regionSpinnerAdapter;
    @BindView(R.id.calculate_add_opts_btn)
    CustomFontButton addititionalOptsBtn;
    @BindView(R.id.calculate_calculate_btn)
    CustomFontButton calculatebtn;

    private CalculateAddOptComprehensiveModel calculateAddOptComprehensiveModel;

    private final int ADDITIONAL_INFO_REQ_CODE = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        ViewUtils.setAvatarToView(this, avatar);

        title.setText(getString(R.string.vehicle));

        final AwesomeValidation mAwesomeValidation = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        mAwesomeValidation.addValidation(this, R.id.calculate_vehicle_price_til, RegexTemplate.NOT_EMPTY, R.string.vehicle_price_missing);
        mAwesomeValidation.addValidation(this, R.id.calculate_vehicle_manufacturer_til, RegexTemplate.NOT_EMPTY, R.string.vehicle_manufacturer_missing);
        mAwesomeValidation.addValidation(this, R.id.calculate_prospect_til, RegexTemplate.NOT_EMPTY, R.string.insured_name_missing);

        categorySpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getCategory());
        categorySpinner.setAdapter(categorySpinnerAdapter);
        insuranceTypeSpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getType());
        insuranceTypeSpinner.setAdapter(insuranceTypeSpinnerAdapter);
        vehicleYearSpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getVehicleYear());
        vehicleYearSpinner.setAdapter(vehicleYearSpinnerAdapter);
        regionSpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getArea());
        regionSpinner.setAdapter(regionSpinnerAdapter);

        calculateAddOptComprehensiveModel = new CalculateAddOptComprehensiveModel();

        vehicleManufacturerET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                    if (editable.length() == 0)
                        vehicleManufacturerTil.setError(getString(R.string.vehicle_manufacturer_missing));
                    else
                        vehicleManufacturerTil.setError(null);
            }
        });

        prospectET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0)
                    prospectTil.setError(getString(R.string.insured_name_missing));
                else
                    prospectTil.setError(null);
            }
        });

        addititionalOptsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (insuranceTypeSpinner.getSelectedItemPosition() == 1){
                    Intent intent = new Intent(CalculateActivity.this, CalculateAdditionalOptionsComprehensiveActivity.class);
                    Gson gson = new Gson();
                    intent.putExtra(CalculateUtils.ADDITIONAL_INFO_INTENT, gson.toJson(calculateAddOptComprehensiveModel));
                    startActivityForResult(intent, ADDITIONAL_INFO_REQ_CODE);
                } else if (insuranceTypeSpinner.getSelectedItemPosition() == 2){

                } else {
                    Toast.makeText(CalculateActivity.this, getString(R.string.otomate_no_add_opt), Toast.LENGTH_SHORT).show();
                }
            }
        });

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAwesomeValidation.validate()){
                    double vehiclePriceDbl = Double.parseDouble(vehiclePriceET.getText().toString().replace(".", "").replace(",", ""));
                    PremiModel premiModel = CalculateUtils.calculate(vehiclePriceET.getText().toString(),
                            insuranceTypeSpinnerAdapter.getItem(insuranceTypeSpinner.getSelectedItemPosition()).getId(), calculateAddOptComprehensiveModel);

                    CalculateResultModel calculateResultModel = new CalculateResultModel();
                    String prospectName = maleRb.isChecked() ? getString(R.string.mister): getString(R.string.miss) + prospectET.getText().toString();
                    calculateResultModel.setNama_tertanggung(prospectName);
                    calculateResultModel.setKategori_kendaraan(categorySpinnerAdapter.getItem(categorySpinner.getSelectedItemPosition()).getName());
                    calculateResultModel.setJenis_asuransi(insuranceTypeSpinnerAdapter.getItem(insuranceTypeSpinner.getSelectedItemPosition()).getName());
                    calculateResultModel.setTahun_kendaraan(vehicleYearSpinnerAdapter.getItem(insuranceTypeSpinner.getSelectedItemPosition()).getName());
                    String agentName = SharedPreferenceUtilities.getFromSessionSP(CalculateActivity.this, SharedPreferenceUtilities.USER_FIRST_NAME) + " " +
                            SharedPreferenceUtilities.getFromSessionSP(CalculateActivity.this, SharedPreferenceUtilities.USER_LAST_NAME);
                    calculateResultModel.setAgent_name(agentName);
                    calculateResultModel.setNilai_pertanggungan(CalculateUtils.stringToDouble(vehiclePriceET.getText().toString()));
                    calculateResultModel.setPremi(premiModel.getPremi());
                    calculateResultModel.setRate(premiModel.getRate());
                    calculateResultModel.setMerek_kendaraan(vehicleManufacturerET.getText().toString());
                    calculateResultModel.setUser_email("");

                    if (calculateResultModel.getJenis_asuransi().equals(InsuranceTypeContent.COMPREHENSIVE.getName())){
                        // TSFWD
                        calculateResultModel.setTSFWD_tsi(vehiclePriceDbl);
                        calculateResultModel.setTSFWD_rate(premiModel.getTSFWD());
                        calculateResultModel.setTSFWD_premi(premiModel.getTSFWD() * vehiclePriceDbl);
                        // EQVET
                        calculateResultModel.setEQVET_tsi(vehiclePriceDbl);
                        calculateResultModel.setEQVET_rate(premiModel.getEQVET());
                        calculateResultModel.setEQVET_premi(premiModel.getEQVET() * vehiclePriceDbl);
                        // SRCCTS
                        calculateResultModel.setSRCCTS_tsi(vehiclePriceDbl);
                        calculateResultModel.setSRCCTS_rate(premiModel.getSRCCTS());
                        calculateResultModel.setSRCCTS_premi(premiModel.getSRCCTS() * vehiclePriceDbl);

                        calculateResultModel.setPersonal_accident_driver_premi(premiModel.getPersonalAccidentDriver());
                        calculateResultModel.setPersonal_accident_penumpang_4_orang_premi(premiModel.getPersonalAccidentPassenger());
                        calculateResultModel.setThird_party_premi(premiModel.getThirdParty());
                    }

                    Gson gson = new Gson();
                    String calcResExtra = gson.toJson(calculateResultModel);

                    Intent intent = new Intent(CalculateActivity.this, CalculateResultActivity.class);
                    intent.putExtra(CalculateResultModel.CALC_RESULT_EXTRA, calcResExtra);
                    startActivity(intent);
                }
            }
        });

        vehiclePriceET.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                vehiclePriceET.removeTextChangedListener(this);
                if (s.length() > 0) {
                    String editedStr = String.format(Locale.GERMAN, "%,d", new BigInteger(vehiclePriceET.getText().toString().replaceAll("\\.", "").replaceAll(",", "")));
                    vehiclePriceET.setText(editedStr);
                }
                vehiclePriceET.setSelection(vehiclePriceET.getText().length());
                vehiclePriceET.addTextChangedListener(this);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADDITIONAL_INFO_REQ_CODE) {
            if (resultCode == RESULT_OK) {
                Gson gson = new Gson();
                calculateAddOptComprehensiveModel = gson.fromJson(data.getStringExtra(CalculateUtils.ADDITIONAL_INFO_INTENT), CalculateAddOptComprehensiveModel.class);
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.translate_bottom_to_start, R.anim.translate_start_to_down);
    }

    private List<CalculateModel> getCategory() {
        List<CalculateModel> returnCategory = new ArrayList<>();

        returnCategory.add(new CalculateModel("0", getString(R.string.non_truck)));
        returnCategory.add(new CalculateModel("1", getString(R.string.truck_pickup_box)));
        returnCategory.add(new CalculateModel("2", getString(R.string.bus)));

        return returnCategory;
    }

    private List<CalculateModel> getType() {
        List<CalculateModel> returnRegion = new ArrayList<>();

        returnRegion.add(new CalculateModel(InsuranceTypeContent.OTOMATE.getId(), getString(R.string.otomate)));
        returnRegion.add(new CalculateModel(InsuranceTypeContent.COMPREHENSIVE.getId(), getString(R.string.comprehensive)));
        returnRegion.add(new CalculateModel(InsuranceTypeContent.TOTAL_LOST.getId(), getString(R.string.total_lost_only)));

        return returnRegion;
    }

    private List<CalculateModel> getVehicleYear() {
        List<CalculateModel> returnVehicleYear = new ArrayList<>();


        for (int i = 0; i < 8; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -i);
            returnVehicleYear.add(new CalculateModel(String.valueOf(i), String.valueOf(calendar.get(Calendar.YEAR))));
        }

        return returnVehicleYear;
    }

    private List<CalculateModel> getArea() {
        List<CalculateModel> returnInsType = new ArrayList<>();

        returnInsType.add(new CalculateModel("0", getString(R.string.area_1)));
        returnInsType.add(new CalculateModel("1", getString(R.string.area_2)));
        returnInsType.add(new CalculateModel("2", getString(R.string.area_3)));

        return returnInsType;
    }
}
