package com.siddhantbhardwaj.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.CustomViewHolder> {

    private List<Item> itemList;

    public ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener clickListener){
        this.itemClickListener=clickListener;
    }

    public CustomAdaptor(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout,parent,false);
        
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.title.setText(item.getItemName());
        holder.description.setText(item.getItemDesc());
        holder.imageView.setImageResource(item.getImage());

    }

    @Override
    public int getItemCount() {

        return itemList.size();
    }

    public  class CustomViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;

        TextView title;

        TextView description;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.itemTitle);
            description = itemView.findViewById(R.id.descriptionText);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null){
                itemClickListener.onClick(v,getAdapterPosition());
            }
        }
    }

}
