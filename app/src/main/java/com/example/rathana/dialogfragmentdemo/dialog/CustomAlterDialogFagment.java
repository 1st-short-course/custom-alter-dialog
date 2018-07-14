package com.example.rathana.dialogfragmentdemo.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.rathana.dialogfragmentdemo.R;
import com.example.rathana.dialogfragmentdemo.User;
import com.example.rathana.dialogfragmentdemo.callback.OnItemClickListener;

public class CustomAlterDialogFagment extends DialogFragment{
    String[] genders={"male","female"};
    OnItemClickListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnItemClickListener) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("My Dialog Fragment");
        //builder.setMessage("Hi My new Dialog fragment");

        /*
        * custom layout
        * */
        View view= LayoutInflater.from(getActivity()).inflate(R.layout.custom_alert_dialog_layout,null);

        final EditText etUserName=view.findViewById(R.id.username);
        final EditText etPassword=view.findViewById(R.id.password);
        builder.setView(view);

        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e(TAG, "onClick: OK" );
                //listener.onItemClick(genders[0]);
                listener.onSendObject(new User(etUserName.getText().toString(),
                        etPassword.getText().toString()));

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e(TAG, "onClick: cancel" );
                listener.onItemClick(genders[1]);
            }
        });

        return builder.create();
    }

    private static final String TAG = "AlterDialogFragment";
}
