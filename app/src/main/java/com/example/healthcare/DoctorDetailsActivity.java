package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

        private String[][] doctor_details1 =
                {
                        {"Doctor Name : Srinivasan", "Hospital Address : Kanyakumari", "Exp : 10yrs", "Mobile No:9865926293", "700"},
                        {"Doctor Name : Kishore", "Hospital Address : Theni", "Exp : 5yrs", "Mobile No:9836803693", "500"},
                        {"Doctor Name : Jersho vins", "Hospital Address : Trivandrum", "Exp : 8yrs", "Mobile No:7589996575", "800"},
                        {"Doctor Name : Prakash", "Hospital Address : Madurai", "Exp : 3yrs", "Mobile No:9463924693", "600"},
                        {"Doctor Name : Rakesh", "Hospital Address : Chennai", "Exp : 10yrs", "Mobile No:8367289257", "1000"}
                };
        private String[][] doctor_details2 =
                {
                        {"Doctor Name : prashad", "Hospital Address : Kanyakumari", "Exp : 4yrs", "Mobile No:9865926293", "700"},
                        {"Doctor Name : kavin", "Hospital Address : Theni", "Exp : 5yrs", "Mobile No:9836803693", "500"},
                        {"Doctor Name : Vishnu Raj", "Hospital Address : Trivandrum", "Exp : 9yrs", "Mobile No:7589996575", "800"},
                        {"Doctor Name : Rujul", "Hospital Address : Madurai", "Exp : 6yrs", "Mobile No:9463924693", "600"},
                        {"Doctor Name : Karthi", "Hospital Address : Chennai", "Exp : 2yrs", "Mobile No:8367289257", "1000"}
                };
        private String[][] doctor_details3 =
                {
                        {"Doctor Name : Yaswanth", "Hospital Address : proddatur", "Exp : 10yrs", "Mobile No:9865926293", "700"},
                        {"Doctor Name : Mathews jude", "Hospital Address : kidari", "Exp : 5yrs", "Mobile No:9836803693", "500"},
                        {"Doctor Name : Surendra", "Hospital Address : Gundur", "Exp : 8yrs", "Mobile No:7589996575", "800"},
                        {"Doctor Name : Raja Simman", "Hospital Address : Ramanathapuram", "Exp : 3yrs", "Mobile No:9463924693", "600"},
                        {"Doctor Name : Mekala Arun", "Hospital Address : Anantapur", "Exp : 10yrs", "Mobile No:8367289257", "1000"}
                };
        private String[][] doctor_details4 =
                {
                        {"Doctor Name : Gowtham", "Hospital Address : Tirupati", "Exp : 10yrs", "Mobile No:9865926293", "700"},
                        {"Doctor Name : Srinath", "Hospital Address : kadapa", "Exp : 5yrs", "Mobile No:9836803693", "500"},
                        {"Doctor Name : Sai kiran", "Hospital Address : kadapa", "Exp : 8yrs", "Mobile No:7589996575", "800"},
                        {"Doctor Name : Pavan", "Hospital Address : kurnool", "Exp : 3yrs", "Mobile No:9463924693", "600"},
                        {"Doctor Name : Innareddy", "Hospital Address : Guntur", "Exp : 10yrs", "Mobile No:8367289257", "1000"}
                };
        private String[][] doctor_details5 =
                {
                        {"Doctor Name : Hima sagar", "Hospital Address : Kanyakumari", "Exp : 10yrs", "Mobile No:9865926293", "700"},
                        {"Doctor Name : Manjunath", "Hospital Address : Theni", "Exp : 5yrs", "Mobile No:9836803693", "500"},
                        {"Doctor Name : Lakshmi Teja", "Hospital Address : Trivandrum", "Exp : 8yrs", "Mobile No:7589996575", "800"},
                        {"Doctor Name : Chandramouli", "Hospital Address : Madurai", "Exp : 3yrs", "Mobile No:9463924693", "600"},
                        {"Doctor Name : Vinay", "Hospital Address : Chennai", "Exp : 10yrs", "Mobile No:8367289257", "1000"}
                };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv = findViewById(R.id.textView_logo6);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);

            }
        });




    }

}