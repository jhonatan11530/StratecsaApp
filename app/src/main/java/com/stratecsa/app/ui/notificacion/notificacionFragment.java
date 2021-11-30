package com.stratecsa.app.ui.notificacion;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.stratecsa.app.R;
import com.stratecsa.app.databinding.FragmentNotificationsBinding;

import java.util.Calendar;
import java.util.Locale;

public class notificacionFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private int mYear, mMonth, mDay;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        EditText CONTRATO = root.findViewById(R.id.CONTRATO);
        EditText CONTRATISTA = root.findViewById(R.id.CONTRATISTA);

        EditText CENTRO_POBLADO = root.findViewById(R.id.CENTRO_POBLADO);
        EditText SEDE_INSTITUCIÓN_EDUCATIVA = root.findViewById(R.id.SEDE_INSTITUCIÓN_EDUCATIVA);
        EditText CODIGO_DANE_DEPARTAMENTO = root.findViewById(R.id.CODIGO_DANE_DEPARTAMENTO);
        EditText CODIGO_DANE_MUNICIPIO = root.findViewById(R.id.CODIGO_DANE_MUNICIPIO);
        EditText CODIGO_DANE_CENTRO = root.findViewById(R.id.CODIGO_DANE_CENTRO);
        EditText CODIGO_DANE_SEDE_EDUCATIVA = root.findViewById(R.id.CODIGO_DANE_SEDE_EDUCATIVA);
        EditText CODIGO_CONTRATISTA = root.findViewById(R.id.CODIGO_CONTRATISTA);
        EditText LONGITUD = root.findViewById(R.id.LONGITUD);
        EditText LATITUD = root.findViewById(R.id.LATITUD);
        EditText ALTITUD = root.findViewById(R.id.ALTITUD);
        EditText ID_BENEFICIARIO = root.findViewById(R.id.ID_BENEFICIARIO);
        EditText NOMBRE_DEL_RESPONSABLE = root.findViewById(R.id.NOMBRE_DEL_RESPONSABLE);
        EditText CC = root.findViewById(R.id.CC);
        EditText Mail = root.findViewById(R.id.Mail);
        EditText Numero_Contacto = root.findViewById(R.id.Numero_Contacto);
        EditText FECHA_DE_INSTALACION = root.findViewById(R.id.FECHA_DE_INSTALACION);
        EditText GRUPO = root.findViewById(R.id.GRUPO);


        CONTRATO.getText().toString();
        CONTRATISTA.getText().toString();

        FECHA_DE_INSTALACION.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                // Get Current Date
                final Calendar c = Calendar.getInstance(Locale.getDefault());
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                FECHA_DE_INSTALACION.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });

        String[] lenguajes = {"Seleccione", "Ruby", "Java", ".NET", "Python", "PHP", "JavaScript", "GO"};

        Spinner Departamento = root.findViewById(R.id.Departamento);
        Departamento.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, lenguajes));
        //Departamento.getSelectedItem().toString();

        Spinner Municipio = root.findViewById(R.id.Municipio);
        Municipio.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, lenguajes));
        //Municipio.getSelectedItem().toString();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}