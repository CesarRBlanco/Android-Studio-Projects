package com.example.dialogtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Mi dialogo");
        builder.setIcon(android.R.drawable.ic_lock_lock);
        builder.setMessage("A lo largo de este tema veremos cómo cambiar entre Activities así como distintos elementos que se pueden\n" +
                "incluir en la interfaz de usuario");
        builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "He pulsado", Toast.LENGTH_SHORT).show();
                TextView tv=getActivity().findViewById(R.id.textView);
//                ((MainActivity) getActivity()).setText("Posive");
            tv.setText("lalallala");
            }
        });
        builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "He pulsado N", Toast.LENGTH_SHORT).show();

                ((MainActivity) getActivity()).setText("Nega");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "He pulsado NNeutral", Toast.LENGTH_SHORT).show();

                ((MainActivity) getActivity()).setText("Neu");
            }
        });
        return builder.show();
    }
}
