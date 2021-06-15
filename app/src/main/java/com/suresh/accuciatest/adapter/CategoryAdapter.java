package com.suresh.accuciatest.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suresh.accuciatest.MainActivity;
import com.suresh.accuciatest.R;
import com.suresh.accuciatest.models.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {
    Context mContext;
    List<Category> categories;
    private int row_index = -1;
    private boolean isSelected = false;
    View view;
    private int currentpos=-1;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.mContext=context;
        this.categories=categoryList;
        row_index=0;
    }

    @NonNull
    @Override
    public CategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prodcatitem, parent, false);

        return new CategoryAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Viewholder holder, int position) {

        holder.tvcatname.setText(categories.get(position).getName());
        holder.tvcatname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentpos=row_index;
                if (position!=currentpos){
                    isSelected = true;
                    row_index = position;
                    ((MainActivity) mContext).showItems(position);

                }else {
                    isSelected = false;
                    row_index = 0;
                    ((MainActivity) mContext).showItems(position);
                }
                notifyDataSetChanged();
            }
        });
        if (row_index == position) {
            holder.laycatbg.setBackgroundResource(R.drawable.catbg2);
            holder.tvcatname.setTextColor(Color.parseColor("#ffffff"));
        } else {
            holder.laycatbg.setBackgroundResource(R.drawable.catbg);
            holder.tvcatname.setTextColor(Color.parseColor("#000000"));
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tvcatname;
        LinearLayout laycatbg;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tvcatname = (TextView) itemView.findViewById(R.id.tvcatname);
            laycatbg = (LinearLayout) itemView.findViewById(R.id.laycatbg);
        }
    }
}
