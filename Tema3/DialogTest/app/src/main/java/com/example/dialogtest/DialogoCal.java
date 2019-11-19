package com.example.dialogtest;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoCal extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(),this,2019,11,20);
        return datePickerDialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast.makeText(getContext(), year + "/" + month + "/" + dayOfMonth, Toast.LENGTH_SHORT).show();
        TextView tv = getActivity().findViewById(R.id.textView);
        tv.setText(year + "/" + month + "/" + dayOfMonth);
    }
}
