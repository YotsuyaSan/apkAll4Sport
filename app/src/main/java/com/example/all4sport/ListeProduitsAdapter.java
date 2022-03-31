package com.example.all4sport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListeProduitsAdapter extends RecyclerView.Adapter<ListeProduitsViewHolder> {
    Context context;
    List<Item> items;

    public ListeProduitsAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ListeProduitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListeProduitsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListeProduitsViewHolder holder, int position) {
        String name = items.get(position).getNom();
        holder.nameView.setText(name);
        String quantite = items.get(position).getQuantite();
        holder.quantiteView.setText(quantite);
      //  holder.imageView.setImageResource(items.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
