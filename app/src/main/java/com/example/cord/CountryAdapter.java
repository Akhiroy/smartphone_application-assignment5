package com.example.cord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private List<Country> countryList;
    private OnItemClickListener listener;

    public CountryAdapter(List<Country> countryList, OnItemClickListener listener) {
        this.countryList = countryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countryList.get(position);

        // Bind data to views
        holder.textViewName.setText(country.getName());

        double population = country.getPopulation();
        String formattedPopulation;
        if (population >= 1_000_000_000) {
            formattedPopulation = String.format("%.3f billion", population / 1_000_000_000);
        } else if (population >= 1_000_000) {
            formattedPopulation = String.format("%.3f million", population / 1_000_000);
        } else {
            formattedPopulation = String.format("%.0f", population);
        }
        holder.textViewPopulation.setText("Population: " + formattedPopulation);
        holder.imageViewFlag.setImageResource(country.getFlagResId());

        // Set OnClickListener to open the URL
        holder.textViewName.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(country.getUrl()));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewPopulation;
        ImageView imageViewFlag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewCountryName);
            textViewPopulation = itemView.findViewById(R.id.textViewPopulation);
            imageViewFlag = itemView.findViewById(R.id.imageViewFlag);
        }
    }
}

