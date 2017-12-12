package com.example.jonas.kom_ihag_lista;


public class ConvertActionClass {

    String finalString;

    public void m (Double convertThisCurrencyFirst, Double dfirstCurrency, Double convertThisCurrencySecond){
        Double calc = convertThisCurrencyFirst * dfirstCurrency / 8.3328;
        String makeString = Double.toString(calc);
        Float makeFloat = Float.parseFloat(makeString);
        finalString = Float.toString(makeFloat);

        System.out.println("this is finalstringgg" + finalString);
    }

    public String finalString() {
        System.out.println("from finalstring function" + finalString);
        return finalString;
    }


}
