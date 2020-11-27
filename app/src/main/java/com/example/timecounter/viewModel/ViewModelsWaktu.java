package com.example.timecounter.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.timecounter.model.Waktu;

public class ViewModelsWaktu extends ViewModel {

    public Waktu waktu = new Waktu();
    private int jamKeDetik;
    private int menitKeDetik;
    private int detikKeDetik;


    public int JamKeDetik() {
        jamKeDetik = waktu.getJam()*3600;
        return jamKeDetik;
    }

    public int MenitKeDetik() {
        menitKeDetik = waktu.getMenit()*60;
        return menitKeDetik;
    }

    public int DetikKeDetik() {
        detikKeDetik = waktu.getDetik();
        return detikKeDetik;
    }


    public void hitungTotal(){

        waktu.setTotal(JamKeDetik()+MenitKeDetik()+DetikKeDetik());

    }

}
