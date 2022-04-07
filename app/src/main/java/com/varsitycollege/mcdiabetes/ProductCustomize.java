package com.varsitycollege.mcdiabetes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductCustomize  extends AppCompatActivity {
    ImageView imageView_Burger_Customize;
    TextView txtBurgerName, txtBurgerPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_customize);

        imageView_Burger_Customize = findViewById(R.id.imageView_Burger_Customize);
   

        String burgerName = getIntent().getStringExtra("GetBurgerName");
        String burgerPrice = getIntent().getStringExtra("GetBurgerPrice");
        int imageName=getIntent().getIntExtra("burgerImage",0);
        Toast.makeText(this, burgerPrice+" "+burgerName, Toast.LENGTH_SHORT).show();

        txtBurgerPrice.setText(burgerPrice);
        txtBurgerName.setText(burgerName);
        //imageView_SelectedBurger.setImageResource(imageName);
    }
}
