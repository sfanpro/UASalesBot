package org.telegram.uasales.bot.test;

import org.junit.Assert;
import org.junit.Test;
import org.telegram.uasales.bot.product.EpicentrProducts;
import org.telegram.uasales.bot.product.KlassProducts;

import java.util.ArrayList;
import java.util.List;


public class StoreTest {
    @Test
    public void getKlass() {
        KlassProducts one = new KlassProducts("nameOne", "imgOne", "oldOne", "priceOne");
        String expected = "[" + '\n' + "[nameOne](imgOne)" + '\n' +
                "OLD price: `oldOne` грн.\n" +
                "NEW PRICE: *priceOne* грн.\n" + "]";
        List<KlassProducts> actualList = new ArrayList<>();
        actualList.add(one);

        String actual = String.valueOf(actualList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEpicentr() {
        EpicentrProducts prodOne = new EpicentrProducts("http://urlOne", "nameOne", "http://imgOne");
        EpicentrProducts prodTwo = new EpicentrProducts("http://urlTwo", "nameTwo", "http://imgTwo");
        EpicentrProducts prodThree = new EpicentrProducts("http://urlThree", "nameThree", "http://imgThree");

        String expected = "[\n" + "[nameOne](http://urlOne)[.](http://imgOne)\n" +
                ", \n" + "[nameTwo](http://urlTwo)[.](http://imgTwo)\n" +
                ", \n" + "[nameThree](http://urlThree)[.](http://imgThree)\n" + "]";
        List<EpicentrProducts> actualList = new ArrayList<>();
        actualList.add(prodOne);
        actualList.add(prodTwo);
        actualList.add(prodThree);
        String actual = String.valueOf(actualList);

        Assert.assertEquals(expected, actual);
    }
}