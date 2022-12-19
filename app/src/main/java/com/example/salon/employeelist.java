package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class employeelist extends AppCompatActivity {


    EditText e1,e2,e3;
    Button B,B2;
    database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeelist);



        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);

        B = findViewById(R.id.B);

        // creating a new dbhandler class
        // and passing our context to it.
        DB = new database(employeelist.this);

        // below line is to add on click listener for our add course button.
       B.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               // below line is to get data from all edit text fields.
               String nom = e1.getText().toString();
               String prenom = e2.getText().toString();
               double Salaire = Double.parseDouble(e3.getText().toString());


               // validating if the text fields are empty or not.
               if (nom.isEmpty() && prenom.isEmpty() && Salaire == 0 ) {
                   Toast.makeText(employeelist.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                   return;
               }

               // on below line we are calling a method to add new
               // course to sqlite data and pass all our values to it.
               DB.addemployee(nom, prenom, Salaire);

               // after adding the data we are displaying a toast message.
               Toast.makeText(employeelist.this, "Employee has been added.", Toast.LENGTH_SHORT).show();
               e1.setText("");
               e2.setText("");
               e3.setText("");

           }
       });

       B2 = findViewById(R.id.B22);
       B2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(),listemployee.class);
               startActivity(intent);
           }
       });

}
}