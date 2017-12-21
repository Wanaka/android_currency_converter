package com.example.jonas.kom_ihag_lista;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Collections;

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
    private String[] currencyArray = { "SEK", "USD", "EUR", "CHF", "AUD", "GBP", "INR", "DKK", "NOK", "NZD", "CAD", "PKR", "JPY", "CNY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CurrencyConverterClass currencyConverter = new CurrencyConverterClass();
        final ConvertActionClass c = new ConvertActionClass();

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
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(getApplicationContext(),
               R.layout.list_row, currencyArray);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.list_row); //support_simple_spinner_dropdown_item
        spinnerFirstCurrency.setAdapter(adapter);

        //Chose currency to change to
        spinnerSecondCurrency = (Spinner) findViewById(R.id.currencySpin2);
       final  ArrayAdapter<String> adapter2;
        adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.list_row, currencyArray);
       // adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.list_row);
        spinnerSecondCurrency.setAdapter(adapter2);

        //Button action
        convertButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final String sfirstCurrency = firstCurrency.getText().toString();
                final Double dfirstCurrency = Double.parseDouble(sfirstCurrency);

                int position1 = spinnerFirstCurrency.getSelectedItemPosition();
                int position2 = spinnerSecondCurrency.getSelectedItemPosition();

                CurrencyConverterClass currencyConverter = new CurrencyConverterClass();
                //First currency spin switch
                currencyConverter.convert(position1, position2, dfirstCurrency);

                switch(position1) { //"GBP", "INR", "DKK", "NOK", "NZD", "CAD", "PKR", "JPY", "CNY"
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
                    case 5: //GBP
                        System.out.println("GBP chosen");
                        convertThisCurrencyFirst = 11.3496;
                        break;
                    case 6: //INR
                        System.out.println("INR chosen");
                        convertThisCurrencyFirst = 0.130716;
                        break;
                    case 7: //DKK
                        System.out.println("DKK chosen");
                        convertThisCurrencyFirst = 1.33398;
                        break;
                    case 8: //NOK
                        System.out.println("NOK chosen");
                        convertThisCurrencyFirst = 1.01181;
                        break;
                    case 9: //NZD
                        System.out.println("NZD chosen");
                        convertThisCurrencyFirst = 5.85376;
                        break;
                    case 10: //CAD
                        System.out.println("CAD chosen");
                        convertThisCurrencyFirst = 6.57846;
                        break;
                    case 11: //PKR
                        System.out.println("PKR chosen");
                        convertThisCurrencyFirst = 0.0770511;
                        break;
                    case 12: //JPY
                        System.out.println("JPY chosen");
                        convertThisCurrencyFirst = 0.0743131;
                        break;
                    case 13: //CNY
                        System.out.println("CNY chosen");
                        convertThisCurrencyFirst = 1.27441;
                        break;
                    default:
                        System.out.println("none chosen");
                        break;
                }//"GBP", "INR", "DKK", "NOK", "NZD", "CAD", "PKR", "JPY", "CNY"


                //Second currency spin switch
                switch(position2) { //"GBP", "INR", "DKK", "NOK", "NZD", "CAD", "PKR", "JPY", "CNY"
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
                    case 5: //GBP
                        System.out.println("GBP chosen");
                        convertThisCurrencySecond = 11.3496;
                        break;
                    case 6: //INR
                        System.out.println("INR chosen");
                        convertThisCurrencySecond = 0.130716;
                        break;
                    case 7: //DKK
                        System.out.println("DKK chosen");
                        convertThisCurrencySecond = 1.33398;
                        break;
                    case 8: //NOK
                        System.out.println("NOK chosen");
                        convertThisCurrencySecond = 1.01181;
                        break;
                    case 9: //NZD
                        System.out.println("NZD chosen");
                        convertThisCurrencySecond = 5.85376;
                        break;
                    case 10: //CAD
                        System.out.println("CAD chosen");
                        convertThisCurrencySecond = 6.57846;
                        break;
                    case 11: //PKR
                        System.out.println("PKR chosen");
                        convertThisCurrencySecond = 0.0770511;
                        break;
                    case 12: //JPY
                        System.out.println("JPY chosen");
                        convertThisCurrencySecond = 0.0743131;
                        break;
                    case 13: //CNY
                        System.out.println("CNY chosen");
                        convertThisCurrencySecond = 1.27441;
                        break;
                    default:
                        System.out.println("none chosen");
                        break;
                }//"GBP", "INR", "DKK", "NOK", "NZD", "CAD", "PKR", "JPY", "CNY"


                Double calc = convertThisCurrencyFirst * dfirstCurrency / convertThisCurrencySecond;
                secondCurrency.setText(String.format( "%.2f", calc )); // set the currency that has been converted

            }
        });

        firstCurrency.addTextChangedListener(new TextWatcher() { // change button enable state when edit text has been changed
            @Override
            public void afterTextChanged(Editable arg0) {
                enableSubmitIfReady();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    } // end oncreate

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void enableSubmitIfReady(){ //check if any text has been added to the edit text
        boolean isReady = firstCurrency.getText().toString().length()>0;
        convertButton.setEnabled(isReady);
    }
}
