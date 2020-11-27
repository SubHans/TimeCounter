package com.example.timecounter.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.lifecycle.ViewModel;

public class Waktu {
    private int jam ;
    private int menit ;
    private int detik ;
    private int total ;

    public Waktu() {
    }

    public Waktu(int jam, int menit, int detik, int total) {
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
        this.total = total;
    }

    public int getJam() {
        return jam;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public int getMenit() {
        return menit;
    }

    public void setMenit(int menit) {
        this.menit = menit;
    }

    public int getDetik() {
        return detik;
    }

    public void setDetik(int detik) {
        this.detik = detik;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
