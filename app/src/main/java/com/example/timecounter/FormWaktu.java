package com.example.timecounter;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timecounter.databinding.FragmentFormWaktuBinding;
import com.example.timecounter.model.Waktu;
import com.example.timecounter.viewModel.ViewModelsWaktu;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FormWaktu extends Fragment {
    public ViewModelsWaktu mViewModels;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final FragmentFormWaktuBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_form_waktu,container,false);

        mViewModels = new ViewModelProvider(this).get(ViewModelsWaktu.class);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(binding.txtJam.getText().toString().length()==0){
                    binding.txtJam.setError("Waktu Jam diperlukan!");
                }
                else if (binding.txtMenit.getText().toString().length()==0){
                    binding.txtMenit.setError("Waktu Menit diperlukan!");
                }
                else if (binding.txtDetik.getText().toString().length()==0){
                    binding.txtDetik.setError("Waktu Detik diperlukan!");
                }
                else {
                    mViewModels.waktu.setJam(Integer.parseInt(binding.txtJam.getText().toString()));
                    mViewModels.waktu.setMenit(Integer.parseInt(binding.txtMenit.getText().toString()));
                    mViewModels.waktu.setDetik(Integer.parseInt(binding.txtDetik.getText().toString()));
                    mViewModels.hitungTotal();
                    binding.texthasil.setText(Integer.toString(mViewModels.waktu.getTotal())+" Detik") ;
                }
            }
        });
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}