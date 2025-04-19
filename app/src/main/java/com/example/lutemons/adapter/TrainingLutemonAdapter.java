package com.example.lutemons.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemons.R;
import com.example.lutemons.model.Lutemon;

import java.util.ArrayList;

public class TrainingLutemonAdapter extends RecyclerView.Adapter<TrainingLutemonAdapter.ViewHolder> {
    private ArrayList<Lutemon> lutemons;
    private Context context;

    public TrainingLutemonAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lutemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lutemon l = lutemons.get(position);
        holder.txtName.setText(l.getName());
        holder.txtStats.setText("ATK: " + l.getAttackPower() + " | DEF: " + l.getDefense() +
                "\nHP: " + l.getHealth() + "/" + l.getMaxHealth() +
                " \nXP: " + l.getExperience());

        holder.imgLutemon.setImageResource(R.drawable.lutemon);

        holder.btnTrain.setText("Train");
        holder.btnTrain.setOnClickListener(v -> {
            l.gainXP();
            Toast.makeText(context, l.getName() + " trained! XP: " + l.getExperience(), Toast.LENGTH_SHORT).show();
            notifyItemChanged(position);
        });

        holder.btnSendHome.setText("Send Home");
        holder.btnSendHome.setOnClickListener(v -> {
            l.setLocation("home");
            lutemons.remove(position);
            notifyItemRemoved(position);
            Toast.makeText(context, l.getName() + " sent back home.", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtStats;
        ImageView imgLutemon;
        Button btnTrain;
        Button btnSendHome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtLutemonName);
            txtStats = itemView.findViewById(R.id.txtLutemonStats);
            imgLutemon = itemView.findViewById(R.id.imageLutemon);
            btnSendHome = itemView.findViewById(R.id.btnSendHome);
            btnTrain = itemView.findViewById(R.id.btnactionButton);
        }
    }
}
