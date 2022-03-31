package com.example.all4sport;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListeProduitsViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView, quantiteView;

    public ListeProduitsViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.nom);
        imageView = itemView.findViewById(R.id.imageView);
        quantiteView = itemView.findViewById(R.id.quantite);

    }
}
