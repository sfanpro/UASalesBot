package org.telegram.uasales.bot.store;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.uasales.bot.product.EpicentrProducts;
import org.telegram.uasales.bot.Page;

import java.util.ArrayList;
import java.util.List;

public class Epicentr extends Page {
    // при вызове конструктора происодит соединение к нашей странице
    public Epicentr() {
        connect("https://epicentrk.ua/offers");
    }

    /**
     * В этом методе мы парсим html страницу
     *
     * @return - список элементотов ввиде строки
     */
    public String getEpicentr() {
        //создаем лист в который будем помещфть наши элементы
        List<EpicentrProducts> epicentrProductsList = new ArrayList<>();
        //указываем с какого места нашей html страницы будем вытягивать элементы
        Elements elements = getDocument().getElementsByAttributeValue("class", "links-item col-md-4 col-sm-6");
        //в цикле будем доставать наши элементы, указывая с какого поля (select) и какими параметрами
        for (Element element : elements) {
            String url = element.select("a").attr("href");
            String name = element.text();
            String img = element.select("img").attr("abs:src");

            //помещаем в List полученные элементы
            epicentrProductsList.add(new EpicentrProducts(url, name, img));
        }
        return String.valueOf(epicentrProductsList);
    }
}