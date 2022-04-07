package com.varsitycollege.mcdiabetes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MenuListActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView image_hamburger, image_bigmac, image_mcdouble, image_bbqbeef, image_fondue, image_chickenmcfirst ;
    Product newProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        
        image_bigmac = findViewById(R.id.image_bigmac);
        image_hamburger = findViewById(R.id.image_hamburger);
        image_mcdouble = findViewById(R.id.image_mcdouble);
        image_bbqbeef = findViewById(R.id.image_bbqBeef);
        image_chickenmcfirst = findViewById(R.id.image_fondue);
        image_fondue = findViewById(R.id.image_fondue);

        image_mcdouble.setOnClickListener(this);
        image_hamburger.setOnClickListener(this);
        image_bigmac.setOnClickListener(this);
        image_fondue.setOnClickListener(this);
        image_bbqbeef.setOnClickListener(this);
        image_chickenmcfirst.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        newProduct = new Product();
        switch (view.getId())
        {
            case R.id.image_bbqBeef:
                newProduct.setProductName("BBQ Beef - 2 Meats");
            newProduct.setProductPrice("R 75.58");
            Intent passBBQ = new Intent(MenuListActivity.this, ProductDetails.class);
            passBBQ.putExtra("GetBurgerName", newProduct.getProductName());
            passBBQ.putExtra("GetBurgerPrice",newProduct.getProductPrice());
            passBBQ.putExtra("burgerImage",R.drawable.bbqbeef);
            startActivity(passBBQ);
                break;
            case R.id.image_bigmac:
                newProduct.setProductName("The Big Mac™");
                newProduct.setProductPrice("R 45.00");
                Intent passBigMac = new Intent(MenuListActivity.this, ProductDetails.class);
                passBigMac.putExtra("GetBurgerName", newProduct.getProductName());
                passBigMac.putExtra("GetBurgerPrice",newProduct.getProductPrice());
                passBigMac.putExtra("burgerImage",R.drawable.bigmac);
                startActivity(passBigMac);
                break;
            case R.id.image_fondue:
                newProduct.setProductName("The Little Fondue");
                newProduct.setProductPrice("R 25.00");
                Intent passFondue = new Intent(MenuListActivity.this, ProductDetails.class);
                passFondue.putExtra("GetBurgerName", newProduct.getProductName());
                passFondue.putExtra("GetBurgerPrice",newProduct.getProductPrice());
                passFondue.putExtra("burgerImage",R.drawable.fondue);
                startActivity(passFondue);
                break;
            case R.id.image_hamburger:
                newProduct.setProductName("The hamburger");
                newProduct.setProductPrice("R 25.00");
                Intent passHamburger = new Intent(MenuListActivity.this, ProductDetails.class);
                passHamburger.putExtra("GetBurgerName", newProduct.getProductName());
                passHamburger.putExtra("GetBurgerPrice",newProduct.getProductPrice());
                passHamburger.putExtra("burgerImage",R.drawable.hamburger);
                startActivity(passHamburger);
                break;
            case R.id.image_mcdouble:
                newProduct.setProductName("McDouble");
                newProduct.setProductPrice("R 40.00");
                Intent passMcDouble = new Intent(MenuListActivity.this, ProductDetails.class);
                passMcDouble.putExtra("GetBurgerName", newProduct.getProductName());
                passMcDouble.putExtra("GetBurgerPrice",newProduct.getProductPrice());
                passMcDouble.putExtra("burgerImage",R.drawable.mcdouble);
                startActivity(passMcDouble);
                break;
            case R.id.image_chickenmcfirst:
                newProduct.setProductName("Chicken McFirst™");
                newProduct.setProductPrice("R 100.00");
                Intent passChieckenMcfirst = new Intent(MenuListActivity.this, ProductDetails.class);
                passChieckenMcfirst.putExtra("GetBurgerName", newProduct.getProductName());
                passChieckenMcfirst.putExtra("GetBurgerPrice",newProduct.getProductPrice());
                passChieckenMcfirst.putExtra("burgerImage",R.drawable.chickenmcfirst);
                startActivity(passChieckenMcfirst);
                break;
        }
    }
}
