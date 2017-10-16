package com.gmg.icalc.calculation;

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
}