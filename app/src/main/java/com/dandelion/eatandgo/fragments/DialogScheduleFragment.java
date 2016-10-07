package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.dandelion.eatandgo.R;

public class DialogScheduleFragment extends DialogFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_schedule, container, false);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        EditText dialogGrams = (EditText) view.findViewById(R.id.dialogGrams);
        EditText dialogHours = (EditText) view.findViewById(R.id.dialogHours);

        TextView dialogSubmit = (TextView) view.findViewById(R.id.dialogSubmit);
        dialogSubmit.setOnClickListener(this);
        TextView dialogDelete = (TextView) view.findViewById(R.id.dialogDelete);
        dialogDelete.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialogSubmit:
//                добавляем данные в CardView и отправляем на сервер
                break;
            case R.id.dialogDelete:
//                удаляем выбранную CardView
                break;
        }
    }
}
