package com.example.babybuy.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.telephony.SmsManager;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.babybuy.R;

public class SmsAct extends AppCompatActivity {

    EditText smobile;
    Button btnsendsms;
    ImageView backimg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sms);

        // Change notification color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.greencolor));
        }

        smobile = findViewById(R.id.smobile);
        btnsendsms = findViewById(R.id.btnsendsms);
        backimg = findViewById(R.id.sbackimgf);

        // Call SendMessage method
        btnsendsms.setOnClickListener(v -> {
            SendMessage();
        });

        backimg.setOnClickListener(view -> {
            startActivity(new Intent(SmsAct.this, MainAct.class));
        });
    }

    // SMS send method
    public void SendMessage() {
        String stringPhone = smobile.getText().toString().trim();

        if (stringPhone.equals("")) {
            Toast.makeText(this, "Enter the mobile number", Toast.LENGTH_SHORT).show();
        } else {
            SmsManager smsman = SmsManager.getDefault();
            String message = "This is a test message"; // Customize your message here
            smsman.sendTextMessage(stringPhone, null, message, null, null);
            Toast.makeText(this, "SMS sent successfully", Toast.LENGTH_SHORT).show();
            smobile.getText().clear();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SmsAct.this, MainAct.class);
        startActivity(intent);
    }
}
