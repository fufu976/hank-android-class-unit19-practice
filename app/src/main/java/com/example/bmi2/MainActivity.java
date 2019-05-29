package com.example.bmi2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText weight;
    private EditText height;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        weight = findViewById(R.id.ed_weight);
        height = findViewById(R.id.ed_height);
        bHelp  = findViewById(R.id.b_help);
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(getText(R.string.help))
                        .setMessage(getText(R.string.bmi_info))
                        .setPositiveButton(getText(R.string.close_alert), null)
                        .show();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void bmiCalculate(View v) {
        String weight_s = weight.getText().toString();
        String height_s = height.getText().toString();
        if(TextUtils.isEmpty(weight_s)) {
            weight_s = "0";
        }
        if(TextUtils.isEmpty(height_s)) {
            height_s = "0";
        }
        float w = Float.parseFloat(weight_s);
        float h = Float.parseFloat(height_s);
        if( w > 0 && h > 0 ) {
            float bmi = w / (h * h);
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("BMI", bmi);
            startActivity(intent);
//            new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("BMI")
//                    .setMessage("Your BMI is:" + bmi)
//                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        private static final String TAG = "bmiCalculate";
//
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Log.d(TAG, "onClick: ");
//                        }
//                    }).show();

        } else {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(getText(R.string.warning))
                    .setMessage(getText(R.string.data_input_warning))
                    .setPositiveButton(getText(R.string.ok), new DialogInterface.OnClickListener() {
                        private static final String TAG = "bmiCalculate";

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d(TAG, "onClick: ");
                        }
                    }).show();
        }
    }

}
