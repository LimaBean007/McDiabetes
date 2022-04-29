package com.varsitycollege.mcdiabetes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProductDetails extends AppCompatActivity {
    // Write a message to the database

    String burgerName, burgerPrice;
    ImageView imageView_SelectedBurger;
    TextView txtBurgerName, txtBurgerPrice;
    Button btnPlaceOrder;
    FirebaseAuth Auth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ORDERS");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Auth = FirebaseAuth.getInstance();

        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        imageView_SelectedBurger = findViewById(R.id.imageView_SelectedBurger);
        txtBurgerName = findViewById(R.id.txtBurgerName);
        txtBurgerPrice = findViewById(R.id.txtBurgerPrice);

        burgerName = getIntent().getStringExtra("GetBurgerName");
        burgerPrice = getIntent().getStringExtra("GetBurgerPrice");
        int imageName = getIntent().getIntExtra("burgerImage", 0);

        Toast.makeText(this, burgerPrice + " " + burgerName, Toast.LENGTH_SHORT).show();
        
        txtBurgerPrice.setText(burgerPrice);
        txtBurgerName.setText(burgerName);
        imageView_SelectedBurger.setImageResource(imageName);

        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product newProduct = new Product(burgerName, burgerPrice);
                myRef.child(Auth.getUid()).push().setValue(newProduct).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(ProductDetails.this, "Order placed", Toast.LENGTH_SHORT).show();
                        Intent orderPlace = new Intent(ProductDetails.this, PlacedActivity.class);
                        startActivity(orderPlace);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ProductDetails.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
