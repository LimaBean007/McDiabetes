package com.varsitycollege.mcdiabetes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PlacedActivity extends AppCompatActivity {
    RecyclerView rcvPlacedOrders;
    ArrayList<Product> ordersList = new ArrayList<>();
    FirebaseAuth Auth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placed);
        Auth = FirebaseAuth.getInstance();
        //specific user
        DatabaseReference myRef = database.getReference("ORDERS").child(Auth.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
           //rcvPlacedOrders
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot orders: snapshot.getChildren())
                {
                    Product newProduct = orders.getValue(Product.class);
                    ordersList.add(newProduct);
                    Toast.makeText(PlacedActivity.this, newProduct.getProductName() +" "+ newProduct.getProductPrice(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(PlacedActivity.this, "No data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}