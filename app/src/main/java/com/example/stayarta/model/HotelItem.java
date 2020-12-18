package com.example.stayarta.model;

import com.google.gson.annotations.SerializedName;

public class HotelItem{

    @SerializedName("nomor_telp")
    private String nomorTelp;

    @SerializedName("kordinat")
    private String kordinat;

    @SerializedName("nama")
    private String nama;

    @SerializedName("gambar_url")
    private String gambarUrl;

    @SerializedName("id")
    private Integer id;

    @SerializedName("alamat")
    private String alamat;

    public void setNomorTelp(String nomorTelp){
        this.nomorTelp = nomorTelp;
    }

    public String getNomorTelp(){
        return nomorTelp;
    }

    public void setKordinat(String kordinat){
        this.kordinat = kordinat;
    }

    public String getKordinat(){
        return kordinat;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setGambarUrl(String gambarUrl){
        this.gambarUrl = gambarUrl;
    }

    public String getGambarUrl(){
        return gambarUrl;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getAlamat(){
        return alamat;
    }
}