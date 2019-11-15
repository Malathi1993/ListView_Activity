package com.example.listview_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BroadcastReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
    }
    public void onClickShowBroadcast(View view){
        EditText st = (EditText)findViewById(R.id.txtMsg);
        Intent intent = new Intent();
        intent.putExtra("msg",(CharSequence)st.getText().toString());
        intent.setAction("com.tutlane.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
}

