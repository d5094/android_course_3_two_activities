package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    TextView tvMessage;
    EditText txtReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvMessage = findViewById(R.id.tvMessage);
        txtReply = findViewById(R.id.txtReply);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        tvMessage.setText(message);

        Log.v(TAG, "onCreate called");
        Toast.makeText(this, "onCreate called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart called");
        Toast.makeText(this, "onStart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume called");
        Toast.makeText(this, "onResume called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause called");
        Toast.makeText(this, "onPause called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "onStop called");
        Toast.makeText(this, "onStop called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy called");
        Toast.makeText(this, "onDestroy called", Toast.LENGTH_SHORT).show();
    }

    public void reply(View view) {
        String reply = txtReply.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("reply", reply);

        setResult(Activity.RESULT_OK, intent);

        finish();
    }
}