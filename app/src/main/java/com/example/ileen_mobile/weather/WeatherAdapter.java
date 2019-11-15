package com.example.ileen_mobile.weather;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {
    //1 dataset
    private List<Weather> listWeather = new ArrayList<>();
    Dialog myDialog;


    //2 constructor
    public WeatherAdapter(List<Weather> listWeather) {
        this.listWeather = listWeather;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_weather,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        myDialog = new Dialog(viewGroup.getContext());
        myDialog.setContentView(R.layout.weather_popup);


        viewHolder.weatherItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView weatherBing = myDialog.findViewById(R.id.bing);
                TextView weatherBind = myDialog.findViewById(R.id.bind);
                ImageView weatherImg = myDialog.findViewById(R.id.img);
                weatherBing.setText(listWeather.get(viewHolder.getAdapterPosition()).getBing());
                weatherBind.setText(listWeather.get(viewHolder.getAdapterPosition()).getBind());
                weatherImg.setImageDrawable(listWeather.get(viewHolder.getAdapterPosition()).getImage());

                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.MyViewHolder holder, int position) {
        Weather item = listWeather.get(position);

        holder.imageWeather.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout weatherItem;
        public ImageView imageWeather;
        public TextView bingTitle;
        public TextView bindTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //6 menghubungkan id di layout ke view holder
            weatherItem = itemView.findViewById(R.id.weather_item);
            imageWeather = itemView.findViewById(R.id.image_weather);
            bindTitle = itemView.findViewById(R.id.bind);
            bingTitle = itemView.findViewById(R.id.bing);
        }
    }
}
