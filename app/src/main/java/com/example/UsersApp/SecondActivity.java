package com.example.UsersApp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.UsersApp.view.UserViewHolder.ADDRESS;
import static com.example.UsersApp.view.UserViewHolder.EMAIL;
import static com.example.UsersApp.view.UserViewHolder.NAME;
import static com.example.UsersApp.view.UserViewHolder.PHONE;

public class SecondActivity extends AppCompatActivity {
    private static final String MESSAGE = "message";
    private TextView nameTextview;
    private TextView phoneTextview;
    private TextView emailTextview;
    private TextView addressTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameTextview = findViewById(R.id.second_name_textview);
        phoneTextview = findViewById(R.id.second_phone_textview);
        emailTextview = findViewById(R.id.second_email_textview);
        addressTextview = findViewById(R.id.second_address_textview);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        final String name = bundle.getString(NAME);
        final String phone = bundle.getString(PHONE);
        final String email = bundle.getString(EMAIL);
        String address = bundle.getString(ADDRESS);

        nameTextview.setText(name);
        phoneTextview.setText(phone);
        emailTextview.setText(email);
        addressTextview.setText(address);

        phoneTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                v.getContext().startActivity(intent);
            }
        });

        emailTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                v.getContext().startActivity(intent);
            }
        });

    }
}
