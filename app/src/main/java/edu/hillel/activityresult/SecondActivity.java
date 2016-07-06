package edu.hillel.activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et = (EditText) findViewById(R.id.edText);
        Button btn = (Button) findViewById(R.id.btnSetValue);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String value = et.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("value", value);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("value", "CANCEL ALL");
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
