package com.example.lutemons.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemons.R;
import com.example.lutemons.model.Lutemon;

import java.util.ArrayList;

public class LutemonAdapter extends RecyclerView.Adapter<LutemonAdapter.LutemonViewHolder> {
    private ArrayList<Lutemon> lutemons;
    public LutemonAdapter(ArrayList<Lutemon> lutemons){
        this.lutemons=lutemons;

    }
    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lutemon, parent, false);
        return new LutemonViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position){
        Lutemon l=lutemons.get(position);
        holder.txtName.setText(l.getName());
        holder.txtStats.setText("ATK: " + l.getAttackPower() + " | DEF: " + l.getDefense() +
                "\nHealth Points: " + l.getHealth() + "/" + l.getMaxHealth() +
                " \nXP: " + l.getExperience());
        switch (l.getColor().toLowerCase()){
            case "white":
                holder.itemBackground.setBackgroundColor(0xFFEDEDED);
                break;
            case "green":
                holder.itemBackground.setBackgroundColor(0xFFABCB82);
                break;
            case "pink":
                holder.itemBackground.setBackgroundColor(0xFFEB97C4);
                break;
            case "orange":
                holder.itemBackground.setBackgroundColor(0xFFE3A97A);
                break;
            case "black":
                holder.itemBackground.setBackgroundColor(0xFF757474);
                break;
            default:
                holder.itemBackground.setBackgroundColor(0xFFFFFFFF);

        }
        holder.imgLutemon.setImageResource(R.drawable.lutemon);
    }
    @Override
    public int getItemCount(){
        return lutemons.size();
    }
    public static class LutemonViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtStats;
        View itemBackground;
        ImageView imgLutemon;
        public LutemonViewHolder(@NonNull View itemView){
            super(itemView);
            txtName=itemView.findViewById(R.id.txtLutemonName);
            txtStats=itemView.findViewById(R.id.txtLutemonStats);
            itemBackground=itemView.findViewById(R.id.itemBackground);
            imgLutemon=itemView.findViewById(R.id.imageLutemon);
        }
    }
}
