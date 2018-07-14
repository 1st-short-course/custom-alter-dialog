package com.example.rathana.dialogfragmentdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class SweetAlterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_alter);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAlertTextMessage)
    void onAlterWithTextMessage(){
        new SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE)

                .setTitleText("Login")
                .setContentText("Unless required by applicable law or agreed to in writing, software\n" +
                        "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                        "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                        "See the License for the specific language governing permissions and\n" +
                        "limitations under the License.")
                .setConfirmButton("OK", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }
    @OnClick(R.id.btnAlertProgress)
    void onAlterWithProgress(){

       SweetAlertDialog  sweetAlter= new SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE);
        sweetAlter.getProgressHelper().setBarColor(Color.parseColor("#FF4081" ));
        sweetAlter.show();

    }
}
