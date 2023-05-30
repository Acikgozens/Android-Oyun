package com.example.oyunhafta06;

import android.content.Context;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Oyun {
    private OyunTipi oyunTipi;
    private String soru;
    private String cevap;

    public String getSoru() {
        return soru;
    }

    public String getCevap() {
        return cevap;
    }

    public Oyun(ArrayList<Button> butonlar, Context context) {
        oyunTipi = Util.oyunTipiUret();
        ArrayList<Integer> sayilar = new ArrayList<>();
        ArrayList<Integer> renkler = Util.rastgeleListeOlustur(1, 6);

        for (int i = 0; i < 6; i++) {
            int renk = Util.renkBul(renkler.get(i), context);
            butonlar.get(i).setBackgroundColor(renk);
        }

        if (oyunTipi == OyunTipi.RENK)
        {
                sayilar = Util.rastgeleListeOlustur(1,6);
            for (int i = 0; i < 6; i++) {
                String renkAdi = Util.renkIsminiBul(sayilar.get(i), context);
                butonlar.get(i).setText(renkAdi);
            }

            int rastgeleCevap = Util.sayıUret(0,5);
            cevap = butonlar.get(rastgeleCevap).getText().toString();
            soru = cevap + " Yazısını Bulunuz";
        }

        else
        {   sayilar = Util.rastgeleListeOlustur(5900,6700);
            for (int i = 0; i < 6; i++) {
                butonlar.get(i).setText(sayilar.get(i).toString());
            }
            if (oyunTipi == OyunTipi.MİN)
            {
                cevap = "" + Collections.min(sayilar);
                soru = "En küçük sayıyı bulunuz.";
            }
            else if (oyunTipi == OyunTipi.MAX)
            {
                cevap = "" + Collections.max(sayilar);
                soru = "En büyük sayıyı bulunuz.";
            }
        }
    }
}
