package com.gmg.icalc.car;

/**
 * Created by KM on 9/25/2017. KSM
 */

public class CalculateResultModel {
    private String nama_tertanggung;
    private String kategori_kendaraan;
    private String jenis_asuransi;
    private String tahun_kendaraan;
    private String agent_name;
    private double nilai_pertanggungan;
    private double premi;
    private double rate;
    private String third_party;
    private String personal_accident;
    private String merek_kendaraan;
    private String user_email;
    private double TSFWD_rate; // %age
    private double EQVET_rate;
    private double SRCCTS_rate;
    private double personal_accident_driver_rate;
    private double personal_accident_penumpang_4_orang_rate;
    private double third_party_rate;
    private double TSFWD_tsi; // Vehicle Price
    private double EQVET_tsi;
    private double SRCCTS_tsi;
    private double personal_accident_driver_tsi;
    private double personal_accident_penumpang_4_orang_tsi;
    private double third_party_tsi;
    private double TSFWD_premi; // Result of rate * tsi
    private double EQVET_premi;
    private double SRCCTS_premi;
    private double personal_accident_driver_premi;
    private double personal_accident_penumpang_4_orang_premi;
    private double third_party_premi;

    public CalculateResultModel() {
        nama_tertanggung = "";
        kategori_kendaraan = "";
        jenis_asuransi = "";
        tahun_kendaraan = "";
        agent_name = "";
        nilai_pertanggungan = 0.0;
        premi = 0.0;
        rate = 0.0;
        third_party = "";
        personal_accident = "";
        merek_kendaraan = "";
        user_email = "";
        TSFWD_rate = 0.0;
        EQVET_rate = 0.0;
        SRCCTS_rate = 0.0;
        personal_accident_driver_rate = 0.0;
        personal_accident_penumpang_4_orang_rate = 0.0;
        third_party_rate = 0.0;
        TSFWD_tsi = 0.0;
        EQVET_tsi = 0.0;
        SRCCTS_tsi = 0.0;
        personal_accident_driver_tsi = 0.0;
        personal_accident_penumpang_4_orang_tsi = 0.0;
        third_party_tsi = 0.0;
        TSFWD_premi = 0.0;
        EQVET_premi = 0.0;
        SRCCTS_premi = 0.0;
        personal_accident_driver_premi = 0.0;
        personal_accident_penumpang_4_orang_premi = 0.0;
        third_party_premi = 0.0;
    }


    public static final String CALC_RESULT_EXTRA = "CALC_RESULT_EXTRA";

    public String getNama_tertanggung() {
        return nama_tertanggung;
    }

    public void setNama_tertanggung(String nama_tertanggung) {
        this.nama_tertanggung = nama_tertanggung;
    }

    public String getKategori_kendaraan() {
        return kategori_kendaraan;
    }

    public void setKategori_kendaraan(String kategori_kendaraan) {
        this.kategori_kendaraan = kategori_kendaraan;
    }

    public String getJenis_asuransi() {
        return jenis_asuransi;
    }

    public void setJenis_asuransi(String jenis_asuransi) {
        this.jenis_asuransi = jenis_asuransi;
    }

    public String getTahun_kendaraan() {
        return tahun_kendaraan;
    }

    public void setTahun_kendaraan(String tahun_kendaraan) {
        this.tahun_kendaraan = tahun_kendaraan;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public double getNilai_pertanggungan() {
        return nilai_pertanggungan;
    }

    public void setNilai_pertanggungan(double nilai_pertanggungan) {
        this.nilai_pertanggungan = nilai_pertanggungan;
    }

    public double getPremi() {
        return premi;
    }

    public void setPremi(double premi) {
        this.premi = premi;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getThird_party() {
        return third_party;
    }

    public void setThird_party(String third_party) {
        this.third_party = third_party;
    }

    public String getPersonal_accident() {
        return personal_accident;
    }

    public void setPersonal_accident(String personal_accident) {
        this.personal_accident = personal_accident;
    }

    public String getMerek_kendaraan() {
        return merek_kendaraan;
    }

    public void setMerek_kendaraan(String merek_kendaraan) {
        this.merek_kendaraan = merek_kendaraan;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public double getTSFWD_rate() {
        return TSFWD_rate;
    }

    public void setTSFWD_rate(double TSFWD_rate) {
        this.TSFWD_rate = TSFWD_rate;
    }

    public double getEQVET_rate() {
        return EQVET_rate;
    }

    public void setEQVET_rate(double EQVET_rate) {
        this.EQVET_rate = EQVET_rate;
    }

    public double getSRCCTS_rate() {
        return SRCCTS_rate;
    }

    public void setSRCCTS_rate(double SRCCTS_rate) {
        this.SRCCTS_rate = SRCCTS_rate;
    }

    public double getPersonal_accident_driver_rate() {
        return personal_accident_driver_rate;
    }

    public void setPersonal_accident_driver_rate(double personal_accident_driver_rate) {
        this.personal_accident_driver_rate = personal_accident_driver_rate;
    }

    public double getPersonal_accident_penumpang_4_orang_rate() {
        return personal_accident_penumpang_4_orang_rate;
    }

    public void setPersonal_accident_penumpang_4_orang_rate(double personal_accident_penumpang_4_orang_rate) {
        this.personal_accident_penumpang_4_orang_rate = personal_accident_penumpang_4_orang_rate;
    }

    public double getThird_party_rate() {
        return third_party_rate;
    }

    public void setThird_party_rate(double third_party_rate) {
        this.third_party_rate = third_party_rate;
    }

    public double getTSFWD_tsi() {
        return TSFWD_tsi;
    }

    public void setTSFWD_tsi(double TSFWD_tsi) {
        this.TSFWD_tsi = TSFWD_tsi;
    }

    public double getEQVET_tsi() {
        return EQVET_tsi;
    }

    public void setEQVET_tsi(double EQVET_tsi) {
        this.EQVET_tsi = EQVET_tsi;
    }

    public double getSRCCTS_tsi() {
        return SRCCTS_tsi;
    }

    public void setSRCCTS_tsi(double SRCCTS_tsi) {
        this.SRCCTS_tsi = SRCCTS_tsi;
    }

    public double getPersonal_accident_driver_tsi() {
        return personal_accident_driver_tsi;
    }

    public void setPersonal_accident_driver_tsi(double personal_accident_driver_tsi) {
        this.personal_accident_driver_tsi = personal_accident_driver_tsi;
    }

    public double getPersonal_accident_penumpang_4_orang_tsi() {
        return personal_accident_penumpang_4_orang_tsi;
    }

    public void setPersonal_accident_penumpang_4_orang_tsi(double personal_accident_penumpang_4_orang_tsi) {
        this.personal_accident_penumpang_4_orang_tsi = personal_accident_penumpang_4_orang_tsi;
    }

    public double getThird_party_tsi() {
        return third_party_tsi;
    }

    public void setThird_party_tsi(double third_party_tsi) {
        this.third_party_tsi = third_party_tsi;
    }

    public double getTSFWD_premi() {
        return TSFWD_premi;
    }

    public void setTSFWD_premi(double TSFWD_premi) {
        this.TSFWD_premi = TSFWD_premi;
    }

    public double getEQVET_premi() {
        return EQVET_premi;
    }

    public void setEQVET_premi(double EQVET_premi) {
        this.EQVET_premi = EQVET_premi;
    }

    public double getSRCCTS_premi() {
        return SRCCTS_premi;
    }

    public void setSRCCTS_premi(double SRCCTS_premi) {
        this.SRCCTS_premi = SRCCTS_premi;
    }

    public double getPersonal_accident_driver_premi() {
        return personal_accident_driver_premi;
    }

    public void setPersonal_accident_driver_premi(double personal_accident_driver_premi) {
        this.personal_accident_driver_premi = personal_accident_driver_premi;
    }

    public double getPersonal_accident_penumpang_4_orang_premi() {
        return personal_accident_penumpang_4_orang_premi;
    }

    public void setPersonal_accident_penumpang_4_orang_premi(double personal_accident_penumpang_4_orang_premi) {
        this.personal_accident_penumpang_4_orang_premi = personal_accident_penumpang_4_orang_premi;
    }

    public double getThird_party_premi() {
        return third_party_premi;
    }

    public void setThird_party_premi(double third_party_premi) {
        this.third_party_premi = third_party_premi;
    }

    public static String getCalcResultExtra() {
        return CALC_RESULT_EXTRA;
    }
}