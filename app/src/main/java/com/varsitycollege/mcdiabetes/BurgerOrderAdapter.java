package com.varsitycollege.mcdiabetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BurgerOrderAdapter extends RecyclerView.Adapter<BurgerOrderAdapter.MyViewHolder> {
    Context context;
    Product product;
ArrayList<Product>placedOrders;
    public BurgerOrderAdapter(Context context, Product product, ArrayList<Product> placedOrders) {
        this.context = context;
        this.product = product;
        this.placedOrders=placedOrders;
    }

    @NonNull
    @Override
    //which view
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.order_recycler_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    //what data
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txtBurgerPriceDisplay.setText(placedOrders.get(0).getProductPrice());
        holder.txtBurgerNameDisplay.setText(placedOrders.get(0).getProductName());

    }

    @Override
    //size of te array you are passig
    public int getItemCount() {
        return placedOrders.size();
    }

    //what widget you want to use
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSmallBurger;
        TextView txtBurgerPriceDisplay;
        TextView txtBurgerNameDisplay;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSmallBurger = itemView.findViewById(R.id.imgSmallBurger);
            txtBurgerNameDisplay = itemView.findViewById(R.id.txtBurgerNameDisplay);
            txtBurgerPriceDisplay = itemView.findViewById(R.id.txtBurgerPriceDisplay);
        }
    }
}
