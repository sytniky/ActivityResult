package edu.hillel.activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int SECOND_ACTIVITY_CODE = 1001;
    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn  = (Button) findViewById(R.id.btnGetValue);
        btn.setOnClickListener(this);
        tvText = (TextView) findViewById(R.id.tvText);
    }

    @Override
    public void onClick(View v) {
        startActivityForResult(new Intent(this, SecondActivity.class), SECOND_ACTIVITY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == SECOND_ACTIVITY_CODE) {
                tvText.setText(data.getStringExtra("value"));
            }
        } else if (resultCode == RESULT_CANCELED) {
            tvText.setText("CANCELED");
        }
    }
}
