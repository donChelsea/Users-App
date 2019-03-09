package com.example.UsersApp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.UsersApp.R;
import com.example.UsersApp.SecondActivity;
import com.example.UsersApp.model.User;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public static final String NAME = "name";
    public static final String PHONE = "phone number";
    public static final String EMAIL = "email";
    public static final String ADDRESS = "address";
    private TextView textView;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.name_textview);
    }

    public void onBind(final User user) {
        textView.setText(user.getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                bundle.putString(NAME, user.getName());
                bundle.putString(PHONE, user.getPhoneNumber());
                bundle.putString(EMAIL, user.getEmail());
                bundle.putString(ADDRESS, user.getAddress());
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
    }
}
