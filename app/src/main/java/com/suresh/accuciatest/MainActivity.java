package com.suresh.accuciatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.suresh.accuciatest.adapter.CategoryAdapter;
import com.suresh.accuciatest.adapter.ProductAdapter;
import com.suresh.accuciatest.apis.RetrofitClient;
import com.suresh.accuciatest.models.Category;
import com.suresh.accuciatest.models.Product;
import com.suresh.accuciatest.models.ProductsModel;
import com.suresh.accuciatest.models.Ranking;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoriesrecycle,productrecycler;
    List<Category> categoryList=new ArrayList<>();
    List<Ranking>rankingList=new ArrayList<>();
    List<Product> productList=new ArrayList<>();
    CategoryAdapter categoryAdapter;
    Context context = MainActivity.this;
    private ProductAdapter productAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        categoriesrecycle=findViewById(R.id.categoriesrecycle);
        productrecycler=findViewById(R.id.productrecycler);

        getProductsList();
    }

    private void getProductsList() {
        Call<ProductsModel> call= RetrofitClient.getApiInterface().getProducts();
        call.enqueue(new Callback<ProductsModel>() {
            @Override
            public void onResponse(Call<ProductsModel> call, Response<ProductsModel> response) {
                categoryList=response.body().getCategories();


                categoryAdapter=new CategoryAdapter(context,categoryList);

                Log.d("MSG","List got"+categoryList.toString());
                LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);

                categoriesrecycle.setLayoutManager(layoutManager);
                categoriesrecycle.setAdapter(categoryAdapter);
                categoriesrecycle.setHasFixedSize(true);
                showItems(0);



            }

            @Override
            public void onFailure(Call<ProductsModel> call, Throwable t) {
                Log.d("MSG","List not got"+t.toString());


            }
        });
    }

    public void showItems(int position) {
            productList=categoryList.get(position).getProducts();
        productAdapter=new ProductAdapter(context,productList);
        Constants.products=categoryList.get(position).getProducts();

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);

        productrecycler.setLayoutManager(layoutManager);
        productrecycler.setAdapter(productAdapter);
        productrecycler.setHasFixedSize(true);
    }
}