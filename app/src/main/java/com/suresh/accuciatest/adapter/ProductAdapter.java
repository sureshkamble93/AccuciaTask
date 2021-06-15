package com.suresh.accuciatest.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suresh.accuciatest.R;
import com.suresh.accuciatest.VariantsActivity;
import com.suresh.accuciatest.models.Product;
import com.suresh.accuciatest.models.Variant;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    Context mContext;
    List<Product> products;
    List<Variant>variants;
    View view;

    public ProductAdapter(Context context, List<Product> productList) {
        this.mContext=context;
        this.products=productList;


    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productitem, parent, false);

        return new  ProductAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {

        holder.tvprodname.setText(products.get(position).getName());
        holder.tvaddeddate.setText(products.get(position).getDateAdded());
        holder.tvvaropts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(mContext, VariantsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position",position);
                variants=products.get(position).getVariants();

                i.putExtras(bundle);
                mContext.startActivity(i);
            }
        });

        holder.taxname.setText(products.get(position).getTax().getName());
        holder.taxval.setText(products.get(position).getTax().getValue().toString());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvprodname,tvaddeddate,tvvaropts,taxname,taxval;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvprodname=itemView.findViewById(R.id.tvprodname);
            tvaddeddate=itemView.findViewById(R.id.tvaddeddate);
            tvvaropts=itemView.findViewById(R.id.tvvaropts);
            taxname=itemView.findViewById(R.id.taxname);
            taxval=itemView.findViewById(R.id.taxval);
        }
    }
}
