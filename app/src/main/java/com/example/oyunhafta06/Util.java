package com.example.oyunhafta06;

import android.content.Context;

import java.util.ArrayList;

public class Util {

    public static int sayıUret(int ilk, int son) {

        return ilk + (int) (Math.random() * ((son - ilk) + 1));
    }

    public static OyunTipi oyunTipiUret() {
        int uretilen = sayıUret(1, 3);
        switch (uretilen) {
            case 1:
                return OyunTipi.MAX;

            case 2:
                return OyunTipi.MİN;

            default:
                return OyunTipi.RENK;
        }
    }

    public static ArrayList<Integer> rastgeleListeOlustur(int ilk, int son) {
        ArrayList<Integer> sayilar = new ArrayList<>();

        while (sayilar.size() < 6) {
            int uretilen = sayıUret(ilk, son);
            if (!sayilar.contains(uretilen)) {
                sayilar.add(uretilen);
            } else {
                continue;
            }
        }
        return sayilar;
    }

    public static String renkIsminiBul(int index, Context context) {
        switch (index) {
            case 1:
                return context.getResources().getString(R.string.kirmizi);

            case 2:
                return context.getResources().getString(R.string.mavi);

            case 3:
                return context.getResources().getString(R.string.sari);

            case 4:
                return context.getResources().getString(R.string.yesil);

            case 5:
                return context.getResources().getString(R.string.turuncu);

            default:
                return context.getResources().getString(R.string.mor);

        }
    }

    public static int renkBul(int index, Context context) {
        switch (index) {
            case 1:
                return context.getResources().getColor(R.color.kirmizi);

            case 2:
                return context.getResources().getColor(R.color.mavi);

            case 3:
                return context.getResources().getColor(R.color.sari);

            case 4:
                return context.getResources().getColor(R.color.yesil);

            case 5:
                return context.getResources().getColor(R.color.turuncu);

            default:
                return context.getResources().getColor(R.color.mor);

        }
    }
}
