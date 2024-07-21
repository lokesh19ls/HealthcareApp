package com.example.healthcare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText edname,edaddress,edcontact,edpincode;
    Button btnBooking;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_medicine_book);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edname = findViewById(R.id.editTextBMBFullName);
        edaddress = findViewById(R.id.editTextBMBAddress);
        edcontact = findViewById(R.id.editTextBMBContact);
        btnBooking = findViewById(R.id.buttonBMBBooking);
        edpincode = findViewById(R.id.editTextBMBpincode);

        Intent intent=getIntent();
        String[] price= intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String  date= intent.getStringExtra("date");
        //String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(),edpincode.toString(),date.toString(),"",Float.parseFloat(price[1].toString()),"medicine");
                db.removeCart(username,
                        "medicine");
                Toast.makeText(getApplicationContext(), "Your Booking is done successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicineBookActivity.this,HomeActivity.class));
            }
        });
    }
}