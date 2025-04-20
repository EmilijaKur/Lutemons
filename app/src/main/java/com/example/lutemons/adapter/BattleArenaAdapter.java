/*package com.example.lutemons.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemons.R;
import com.example.lutemons.model.Lutemon;

import java.util.List;

public class BattleArenaAdapter extends RecyclerView.Adapter<BattleArenaAdapter.BattleArenaViewHolder>{
    private Context context;
    private List<Lutemon> lutemons;
    public BattleArenaAdapter(Context context, List<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public BattleArenaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_battle_arena, parent, false);
        return new BattleArenaViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull BattleArenaViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.name.setText(lutemon.getName());
        holder.hp.setText("HP: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());
        holder.image.setImageResource(R.drawable.lutemon);  // Replace with your actual Lutemon image
        holder.bg.setBackgroundResource(getFrameResource(lutemon.getColor()));
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    private int getFrameResource(String color) {
        switch (color.toLowerCase()) {
            case "white": return R.drawable.lutemon_frame_white;
            case "green": return R.drawable.lutemon_frame_green;
            case "pink": return R.drawable.lutemon_frame_green;
            case "orange": return R.drawable.lutemon_frame_orange;
            case "black": return R.drawable.lutemon_frame_black;
            default: return R.drawable.lutemon_frame_white;
        }
    }
    public static class BattleArenaViewHolder extends RecyclerView.ViewHolder {
        TextView name, hp;
        ImageView image;
        View bg;

        public BattleArenaViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameLutemon);
            hp = itemView.findViewById(R.id.hpLutemon);
            image = itemView.findViewById(R.id.imageLutemon);
            bg = itemView.findViewById(R.id.bgLutemon);
        }
    }

}*/
