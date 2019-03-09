package com.example.UsersApp.frag;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.UsersApp.R;
import com.example.UsersApp.controller.UserAdapter;
import com.example.UsersApp.data.JsonString;
import com.example.UsersApp.model.Address;
import com.example.UsersApp.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment{
    List<User> userList = new ArrayList<>();
    RecyclerView recyclerView;

    public MainFragment() {
    }

    public MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            JSONArray jsonArray = new JSONArray(JsonString.originalJsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject allUsers = jsonArray.getJSONObject(i);
                JSONObject addresses = allUsers.getJSONObject("address");
                Address address = new Address(addresses.getString("street"),
                        addresses.getString("suite"),
                        addresses.getString("city"),
                        addresses.getString("zipcode"));
                User user = new User(allUsers.getString("name"),
                        allUsers.getString("phone"),
                        allUsers.getString("email"),
                        address);
                userList.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new UserAdapter(userList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


}
