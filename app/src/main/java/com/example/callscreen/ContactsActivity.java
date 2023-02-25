package com.example.callscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    ArrayList<ContactModel> contactModels = new ArrayList<>();
    int[] contactImages = {R.drawable.agnesjpg, R.drawable.antonio, R.drawable.bob, R.drawable.dave, R.drawable.dr_nefario, R.drawable.dru_gru,
            R.drawable.edith, R.drawable.jerry, R.drawable.kevin, R.drawable.kurito, R.drawable.lucy, R.drawable.macho, R.drawable.margo, R.drawable.mark,
            R.drawable.phil, R.drawable.queen, R.drawable.stuart, R.drawable.tom, R.drawable.vector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        RecyclerView recyclerView = findViewById(R.id.contacts_list);

        setUpContactModels();

        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this, contactModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void setUpContactModels() {
        String[] names = getResources().getStringArray(R.array.contacts);

        for (int i = 0; i < names.length; i++) {
            contactModels.add(new ContactModel(names[i], contactImages[i]));
        }
    }
}