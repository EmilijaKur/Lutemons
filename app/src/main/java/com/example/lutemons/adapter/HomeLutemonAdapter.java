package com.example.lutemons.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemons.BattleActivity;
import com.example.lutemons.R;
import com.example.lutemons.logic.Storage;
import com.example.lutemons.model.Lutemon;

import java.util.ArrayList;

public class HomeLutemonAdapter extends RecyclerView.Adapter<HomeLutemonAdapter.ViewHolder> {
    private ArrayList<Lutemon> lutemons;
    private Context context;
    //Constructor
    public HomeLutemonAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(context).inflate(R.layout.item_lutemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lutemon l = lutemons.get(position);
        // Set name and stats
        holder.txtName.setText(l.getName());
        holder.txtStats.setText("ATK: " + l.getAttackPower() + " | DEF: " + l.getDefense() +
                "\nHealth Points: " + l.getHealth() + "/" + l.getMaxHealth() +
                "\nXP: " + l.getExperience());
        // Change background color based on Lutemon color
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
        // Set default image
        holder.imgLutemon.setImageResource(R.drawable.lutemon);

        // Hide sendHome button if present in layout
        View btnSendHome = holder.itemView.findViewById(R.id.btnSendHome);
        if (btnSendHome != null) {
            btnSendHome.setVisibility(View.GONE);
        }
        // Only show moveToBattle if Lutemon is at home
        holder.btnMoveToBattle.setVisibility(
                l.getLocation().equals("home") ? View.VISIBLE : View.GONE
        );
        // Logic depending on current location
        if (l.getLocation().equals("home")) {
            // Button to move to training
            holder.actionButton.setText("Move to Training");
            holder.actionButton.setOnClickListener(v -> {

                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {

                    l.setLocation("training");
                    lutemons.remove(position);
                    notifyItemRemoved(position);
                    Toast.makeText(context, l.getName() + " moved to training.", Toast.LENGTH_SHORT).show();

                }
                });
            // Button to move to battle arena
            holder.btnMoveToBattle.setOnClickListener(v -> {

                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {

                    l.setLocation("battle");
                    Storage.getInstance().updateLutemon(l);
                    lutemons.remove(position);
                    notifyItemRemoved(position);
                    Toast.makeText(context, l.getName() + " moved to battle arena.", Toast.LENGTH_SHORT).show();

                }
                });


        } else if (l.getLocation().equals("training")) {
            // If in training, allow training action
            holder.actionButton.setText("Train");
            holder.actionButton.setOnClickListener(v -> {

                l.gainXP();
                Toast.makeText(context, l.getName() + " trained! XP: " + l.getExperience(), Toast.LENGTH_SHORT).show();
                notifyItemChanged(position); // update just this item
            });
            // Hide "Move to Battle" button in training activity
            holder.btnMoveToBattle.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtStats;
        ImageView imgLutemon;
        View itemBackground;
        Button actionButton, btnMoveToBattle;
        //Viewholder constructer
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Get references to the views in the layout
            txtName = itemView.findViewById(R.id.txtLutemonName);
            txtStats = itemView.findViewById(R.id.txtLutemonStats);
            imgLutemon = itemView.findViewById(R.id.imageLutemon);
            itemBackground=itemView.findViewById(R.id.itemBackground);
            actionButton = itemView.findViewById(R.id.btnactionButton);
            btnMoveToBattle = itemView.findViewById(R.id.btnMoveToBattle);
        }
    }
}
