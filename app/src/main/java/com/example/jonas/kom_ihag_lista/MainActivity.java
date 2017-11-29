package com.example.jonas.kom_ihag_lista;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;
//import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFirstCurrency;
    private Spinner spinnerSecondCurrency;
    private TextView convertTxt;
    private EditText firstCurrency;
    private TextView toTxt;
    private TextView secondCurrency;
    private Button convertButton;
    private Double convertThisCurrencyFirst;
    private Double convertThisCurrencySecond;
    private String[] currencyArray = { "SEK", "USD", "EUR", "CHF", "AUD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertTxt = (TextView) findViewById(R.id.convertTxt);
        firstCurrency = (EditText) findViewById(R.id.firstCurrency);
        toTxt = (TextView) findViewById(R.id.toTxt);
        secondCurrency = (TextView) findViewById(R.id.resultCurrency);
        convertButton = (Button) findViewById(R.id.convertBtn);

        firstCurrency.setGravity(Gravity.CENTER); // center input text

        // See if anything has been entered into the edit text field. Change button enabled accordingly
        if (firstCurrency.getText().toString().trim().equals("")){
            convertButton.setEnabled(false);
        }else{
            convertButton.setEnabled(true);
        }



        //Chose currency to change from
        spinnerFirstCurrency = (Spinner) findViewById(R.id.currencySpin);
        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, currencyArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFirstCurrency.setAdapter(adapter);

        //Chose currency to change to
        spinnerSecondCurrency = (Spinner) findViewById(R.id.currencySpin2);
        ArrayAdapter<String> adapter2;
       /*
        List<String> list2;

        list2 = new ArrayList<String>();
        list2.add("SEK"); //0
        list2.add("USD"); //1
        list2.add("EUR"); //2
        list2.add("CHF"); //3
        list2.add("AUD"); //4
        */

        adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, currencyArray);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSecondCurrency.setAdapter(adapter2);


        //Button action
        convertButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final String sfirstCurrency = firstCurrency.getText().toString();
                final Double dfirstCurrency = Double.parseDouble(sfirstCurrency);

                System.out.println(dfirstCurrency);

                //First currency spin switch
                switch(spinnerFirstCurrency.getSelectedItemPosition()) {
                    case 0: //sek
                        System.out.println("sek chosen");
                        convertThisCurrencyFirst = 1.0000;
                        break;
                    case 1: //usd
                        System.out.println("Usd chosen");
                        convertThisCurrencyFirst = 8.3328;
                        break;
                    case 2: //eur
                        System.out.println("eur chosen");
                        convertThisCurrencyFirst = 9.9060;
                        break;
                    case 3: //chf
                        System.out.println("chf chosen");
                        convertThisCurrencyFirst = 8.4812;
                        break;
                    case 4: //aud
                        System.out.println("aud chosen");
                        convertThisCurrencyFirst = 6.3423;
                        break;
                    default:
                        System.out.println("none chosen");
                        break;
                }

                //Second currency spin switch
                switch(spinnerSecondCurrency.getSelectedItemPosition()) {
                    case 0: //sek
                        System.out.println("sek chosen");
                        convertThisCurrencySecond = 1.0000;
                        break;
                    case 1: //usd
                        System.out.println("Usd chosen");
                        convertThisCurrencySecond = 8.3328;
                        break;
                    case 2: //eur
                        System.out.println("eur chosen");
                        convertThisCurrencySecond = 9.9060;
                        break;
                    case 3: //chf
                        System.out.println("chf chosen");
                        convertThisCurrencySecond = 8.4812;
                        break;
                    case 4: //aud
                        System.out.println("aud chosen");
                        convertThisCurrencySecond = 6.3423;
                        break;
                    default:
                        System.out.println("none chosen");
                        break;
                }

                Double calc = convertThisCurrencyFirst * dfirstCurrency / convertThisCurrencySecond;
                final String makeString = Double.toString(calc);
                final Float makeFloat = Float.parseFloat(makeString);
                final String finalString = Float.toString(makeFloat);

                secondCurrency.setText(finalString);
            }
        });

        firstCurrency.addTextChangedListener(new TextWatcher() { // change button enable state when edit text has been changed
            @Override
            public void afterTextChanged(Editable arg0) {
                enableSubmitIfReady();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    } // end oncreate

    public void enableSubmitIfReady(){ //check if any text has been added to the edit text
        boolean isReady =firstCurrency.getText().toString().length()>0;
        convertButton.setEnabled(isReady);
    }

}
