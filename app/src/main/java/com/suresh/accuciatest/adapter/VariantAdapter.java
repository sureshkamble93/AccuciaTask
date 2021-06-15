package com.suresh.accuciatest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suresh.accuciatest.R;
import com.suresh.accuciatest.models.Variant;

import java.util.List;

public class VariantAdapter extends RecyclerView.Adapter<VariantAdapter.ViewHolder> {
    Context mContext;
    List<Variant> variantList;
    View view;
    public VariantAdapter(Context context, List<Variant> variants) {
        this.mContext=context;
        this.variantList=variants;

    }

    @NonNull
    @Override
    public VariantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.varinttitem, parent, false);
        return new VariantAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VariantAdapter.ViewHolder holder, int position) {

        holder.txtprodcolor.setText(variantList.get(position).getColor());
        holder.tvprodsize.setText(variantList.get(position).getSize().toString());
        holder.txtpriceprod.setText(variantList.get(position).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return variantList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtprodcolor,tvprodsize,txtpriceprod;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtprodcolor =itemView.findViewById(R.id.txtprodcolor);
            tvprodsize=itemView.findViewById(R.id.tvprodsize);
            txtpriceprod=itemView.findViewById(R.id.txtpriceprod);
        }
    }
}
