package com.bhattaraibikash.topicfour;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    public String countries[] = {"Nepal", "Kathmandu", "China", "Beijing", "India", "New Delhi", "USA", "Washington D.C", "UK", "London"};

    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lscountries = findViewById(R.id.lvCountries);

        dictionary = new HashMap<>();
        for (int i = 0; i<countries.length; i+=2){
            dictionary.put(countries[i], countries[i+1]);
        }

        ArrayAdapter countryAd = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1,
                new ArrayList(dictionary.keySet())
        );

        lscountries.setAdapter(countryAd);

        lscountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                String capital = dictionary.get(country);
                Intent intent = new Intent(MainActivity.this, CapitalActivity.class);
                intent.putExtra("capital", capital);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(), capital.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
