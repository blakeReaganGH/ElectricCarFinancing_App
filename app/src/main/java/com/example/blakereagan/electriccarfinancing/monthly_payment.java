package com.example.blakereagan.electriccarfinancing;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class monthly_payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_payment);

        TextView monthlyPayment = (TextView)findViewById(R.id.textView4);
        ImageView yimage = (ImageView)findViewById(R.id.imgYears);
        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);

        int intYears = sharedPref.getInt("key1", 0);
        int intLoan = sharedPref.getInt("key2", 0);
        float decInterest = sharedPref.getFloat("key3", 0);
        float decMonthlyPayment;

        decMonthlyPayment = (intLoan * (1+ (decInterest * intYears)))/
                (12 * intYears);
        DecimalFormat currency = new DecimalFormat("$000,000.00");
        monthlyPayment.setText("Monthly Payment "+currency.format(decMonthlyPayment));

        if (intYears == 3 ){
            yimage.setImageResource(R.drawable.three);
        }
        else if (intYears == 4 ) {
            yimage.setImageResource(R.drawable.four);
        }
        else if (intYears == 5 ) {
            yimage.setImageResource(R.drawable.five);
        }
        else{
            monthlyPayment.setText("Enter 3, 4, or 5 Years");
        }
    }
}
