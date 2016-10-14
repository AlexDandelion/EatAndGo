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
import com.dandelion.eatandgo.listeners.NewListener;

public class ScheduleDialogFragment extends DialogFragment implements View.OnClickListener {

    private static NewListener listener;
    private EditText dialogGrams;
    private EditText dialogHours;

    public static ScheduleDialogFragment getInstance(NewListener listener) {

        ScheduleDialogFragment fragment = new ScheduleDialogFragment();

        ScheduleDialogFragment.listener = listener;

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_schedule, container, false);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        dialogGrams = (EditText) view.findViewById(R.id.dialogGrams);
        dialogHours = (EditText) view.findViewById(R.id.dialogHours);

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
                listener.itemCallback(dialogGrams.getText().toString(), dialogHours.getText().toString());
                dismiss();
                break;
            case R.id.dialogDelete:
//                удаляем выбранную CardView
                dismiss();
                break;
        }
    }


}
