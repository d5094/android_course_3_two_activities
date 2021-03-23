package com.example.twoactivities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    public static final int REQUEST_CODE_REPLY = 1;

    EditText txtMessage;
    TextView tvReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage = findViewById(R.id.txtMessage);
        tvReply = findViewById(R.id.tvReply);

        if(savedInstanceState != null) {
            if(savedInstanceState.containsKey("reply")) {
                String reply = savedInstanceState.getString("reply");
                tvReply.setText(reply);
            }
        }

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

    public void sendMessage(View view) {
        String message = txtMessage.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message", message);

        // do not expect result
//        startActivity(intent);

        // expect result
        startActivityForResult(intent, REQUEST_CODE_REPLY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_REPLY) {
            if(resultCode == Activity.RESULT_OK) {
                String reply = data.getStringExtra("reply");
                tvReply.setText(reply);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        String reply = tvReply.getText().toString();
        outState.putString("reply", reply);

        super.onSaveInstanceState(outState);
    }
}