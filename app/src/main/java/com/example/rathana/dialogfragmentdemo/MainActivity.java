package com.example.rathana.dialogfragmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.rathana.dialogfragmentdemo.callback.OnItemClickListener;
import com.example.rathana.dialogfragmentdemo.dialog.AlterDialogFragment;
import com.example.rathana.dialogfragmentdemo.dialog.CustomAlterDialogFagment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
implements OnItemClickListener{

    @BindView(R.id.btnDialogFragment)
    Button btnDialogFragment;
    @BindView(R.id.gender)
    TextView tvGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnDialogFragment)
    void onButtonDialogFragment(){
        new AlterDialogFragment().show(getFragmentManager(),"alter dialog");
    }

    @OnClick(R.id.btnCustomDialogFragment)
    void onCustomAlterDialog(){
        new CustomAlterDialogFagment().show(getFragmentManager(),"custom alter dialog");
    }


    @Override
    public void onItemClick(String smg) {
        tvGender.setText(smg);
    }

    @Override
    public void onSendObject(User user) {
        Log.e(TAG, "onSendObject: "+user.toString() ); 
    }

    private static final String TAG = "MainActivity";
}
