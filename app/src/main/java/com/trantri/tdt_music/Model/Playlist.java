package com.trantri.tdt_music.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Playlist implements Serializable {

    @SerializedName("IdPlaylist")
    @Expose
    private String idPlaylist;
    @SerializedName("Ten")
    @Expose
    private String ten;
    @SerializedName("hinhAnhPlaylist")
    @Expose
    private String hinhAnhPlaylist;
    @SerializedName("Icon")
    @Expose
    private String icon;

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhAnhPlaylist() {
        return hinhAnhPlaylist;
    }

    public void setHinhAnhPlaylist(String hinhAnhPlaylist) {
        this.hinhAnhPlaylist = hinhAnhPlaylist;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}