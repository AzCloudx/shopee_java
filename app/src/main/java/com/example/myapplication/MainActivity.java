package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


            Button calculatePriceBtn = (Button) findViewById(R.id.calculatePriceBtn);

            double mariPrice = 100.00;
            double kelPrice = 200.00;
            double heroPrice = 300.00;
            double aubreyPrice = 400.00;
            double basilPrice = 500.00;

            Spinner mariQty = (Spinner) findViewById(R.id.mariQty);
            Spinner kelQty = (Spinner) findViewById(R.id.kelQty);
            Spinner heroQty = (Spinner) findViewById(R.id.heroQty);
            Spinner aubreyQty = (Spinner) findViewById(R.id.aubreyQty);
            Spinner basilQty = (Spinner) findViewById(R.id.basilQty);

            calculatePriceBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    double mariQtyInt = Integer.parseInt(mariQty.getSelectedItem().toString());
                    double kelQtyInt = Integer.parseInt(kelQty.getSelectedItem().toString());
                    double heroQtyInt = Integer.parseInt(heroQty.getSelectedItem().toString());
                    double aubreyQtyInt = Integer.parseInt(aubreyQty.getSelectedItem().toString());
                    double basilQtyInt = Integer.parseInt(basilQty.getSelectedItem().toString());

                    double totalPriceValue = mariQtyInt * mariPrice +
                            kelQtyInt * kelPrice +
                            heroQtyInt * heroPrice +
                            aubreyQtyInt * aubreyPrice +
                            basilQtyInt * basilPrice;


                    TextView totalPriceTextView = (TextView) findViewById(R.id.totalPriceTextView);
                    totalPriceTextView.setText("Total Price: $" + totalPriceValue);

                    startActivity(new Intent(MainActivity.this, CheckOut.class));

                }
            });































        });
    }
}