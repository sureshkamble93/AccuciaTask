package com.suresh.accuciatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.suresh.accuciatest.adapter.CategoryAdapter;
import com.suresh.accuciatest.adapter.VariantAdapter;
import com.suresh.accuciatest.apis.RetrofitClient;
import com.suresh.accuciatest.models.Category;
import com.suresh.accuciatest.models.Product;
import com.suresh.accuciatest.models.ProductsModel;
import com.suresh.accuciatest.models.Variant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VariantsActivity extends AppCompatActivity {

    Context context=VariantsActivity.this;
    int position;
    List<Variant> variants=new ArrayList<>();

    RecyclerView varrecyclerView;
    VariantAdapter variantAdapter;
    private List<Category> categoryList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variants);


        varrecyclerView=findViewById(R.id.varrecyclerView);
        Intent i=getIntent();
        position=i.getIntExtra("position",0);



        variants=Constants.products.get(position).getVariants();
        variantAdapter=new VariantAdapter(context,variants);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);

        varrecyclerView.setLayoutManager(layoutManager);
        varrecyclerView.setAdapter(variantAdapter);
        varrecyclerView.setHasFixedSize(true);

    }

}