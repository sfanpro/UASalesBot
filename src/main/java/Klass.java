import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Klass extends Page {

    // при вызове конструктора происодит соединение к нашей странице
    protected Klass() {
        connect("https://klassmarket.ua/aktsii/katalog-aktsionnykh-tovarov");
    }

    /**
     * В этом методе мы парсим html страницу, при вызове нашего метода происходит присоединение к странице
     *
     * @return - список элементотов ввиде строки
     */
    public String getKlass() {
        //создаем лист в который будем помещать наши элементы
        List<KlassProducts> klassProductsList = new ArrayList<>();
        //указываем с какого места нашей html страницы будем вытягивать элементы
        Elements elements = getDocument().getElementsByClass("product-sale");
        //в цикле будем доставать наши элементы, указывая с какого поля (select) и какими параметрами
        for (Element element : elements) {
            String name = element.select("div.product-ten__name").text();
            String img = element.select("img[width=270]").attr("abs:src");
            String oldPrice = element.select("div.product-price-old__top").text();
            String price = element.select("div.product-price-old__current").text();
            //помещаем в List полученные элементы
            klassProductsList.add(new KlassProducts(name, img, oldPrice, price));
        }
        return String.valueOf(klassProductsList);
    }
}
