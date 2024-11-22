package com.example.cord;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Create a list of countries
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Bangladesh", 173_000_000, R.drawable.bd_flag,"https://en.wikipedia.org/wiki/Bangladesh"));
        countryList.add(new Country("United States", 334_900_000, R.drawable.usa_flag,"https://en.wikipedia.org/wiki/United_States"));
        countryList.add(new Country("Canada", 40_100_000, R.drawable.canada_flag,"https://en.wikipedia.org/wiki/Canada"));
        countryList.add(new Country("United Kingdom", 68_350_000, R.drawable.uk_flag,"https://en.wikipedia.org/wiki/United_Kingdom"));
        countryList.add(new Country("Germany", 84_480_000, R.drawable.germany_flag,"https://en.wikipedia.org/wiki/Germany"));
        countryList.add(new Country("India", 1_429_000_000, R.drawable.indian_flag,"https://en.wikipedia.org/wiki/India"));
        countryList.add(new Country("Oman", 4_644_000, R.drawable.oman_flag,"https://en.wikipedia.org/wiki/Oman"));
        countryList.add(new Country("Qatar", 2_716_000, R.drawable.qatar_flag,"https://en.wikipedia.org/wiki/Qatar"));
        countryList.add(new Country("Finland", 5_584_000, R.drawable.finland_flag,"https://en.wikipedia.org/wiki/Finland"));
        countryList.add(new Country("Brazil", 216_400_000, R.drawable.brazil_flag,"https://en.wikipedia.org/wiki/Brazil"));
        countryList.add(new Country("Denmark", 5_947_000, R.drawable.denmark_flag,"https://en.wikipedia.org/wiki/Denmark"));
        countryList.add(new Country("Yemen", 41_039_753, R.drawable.yemen_flag,"https://en.wikipedia.org/wiki/Yemen"));
        countryList.add(new Country("Romania", 19_060_000, R.drawable.romania_flag,"https://en.wikipedia.org/wiki/Romania"));
        countryList.add(new Country("South Africa", 60_410_000, R.drawable.south_africa_flag,"https://en.wikipedia.org/wiki/South_Africa"));
        countryList.add(new Country("Argentina", 46_650_000, R.drawable.argentina_flag,"https://en.wikipedia.org/wiki/Argentina"));
        countryList.add(new Country("Mexico", 128_500_000, R.drawable.mexico_flag,"https://en.wikipedia.org/wiki/Mexico"));
        countryList.add(new Country("Russia", 143_800_000, R.drawable.russia_flag,"https://en.wikipedia.org/wiki/Russia"));
        countryList.add(new Country("Ireland", 5_262_000, R.drawable.ireland_flag,"https://en.wikipedia.org/wiki/Ireland"));
        countryList.add(new Country("Belgium", 11_820_000, R.drawable.belgium_flag,"https://en.wikipedia.org/wiki/Belgium"));
        countryList.add(new Country("Australia", 26_640_000, R.drawable.australia_flag,"https://en.wikipedia.org/wiki/Australia"));


        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CountryAdapter adapter = new CountryAdapter(countryList, country -> {
            // Handle click event
            Toast.makeText(MainActivity.this,
                    "Clicked: " + country.getName(),
                    Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);
    }
}
