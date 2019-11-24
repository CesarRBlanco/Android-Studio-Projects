package com.example.mymovielist;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class FechaDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int anio = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, anio, mes, dia);
    }
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        ((NuevaPelicula)getActivity()).fecha( year,monthOfYear,dayOfMonth);

    }
}