package com.example.jonas.kom_ihag_lista;

/**
 * Created by jonas on 2017-12-08.
 */

public class CurrencyConverterClass {

    MainActivity m = new MainActivity();
    ConvertActionClass c = new ConvertActionClass();
    Double convertThisCurrency1;

    public void convert(int position1, int position2, Double dfirstCurrency) {
        switch(position1) {
            case 0: //sek
                System.out.println("sek chosen");
                convertThisCurrency1 = 1.0000;
                c.m(convertThisCurrency1, dfirstCurrency,8.3328);
                break;
            case 1: //usd
                System.out.println("Usd chosen");
                convertThisCurrency1 = 8.3328;
                break;
            case 2: //eur
                System.out.println("eur chosen");
                convertThisCurrency1 = 9.9060;
                break;
            case 3: //chf
                System.out.println("chf chosen");
                convertThisCurrency1 = 8.4812;
                break;
            case 4: //aud
                System.out.println("aud chosen");
                convertThisCurrency1 = 6.3423;

                break;
            default:
                System.out.println("none chosen");
                break;
        }

    }
}
