package com.example.inv_management;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Product_Adapter extends FirebaseRecyclerAdapter<Product, Product_Adapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Product_Adapter(@NonNull FirebaseRecyclerOptions<Product> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Product model) {
        holder.prod_name.setText(model.getProd_name());
        holder.prod_color.setText(model.getProd_col());
        holder.prod_price.setText(model.getPrice());

        Glide.with(holder.img.getContext())
                .load(model.getUrl())
                .into(holder.img);
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);

        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView prod_name, prod_color, prod_price;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView)itemView.findViewById(R.id.img1);
            prod_name = (TextView)itemView.findViewById(R.id.tvProdName);
            prod_color = (TextView)itemView.findViewById(R.id.tvProdCol);
            prod_price = (TextView)itemView.findViewById(R.id.tvProdPrice);

        }
    }
}
