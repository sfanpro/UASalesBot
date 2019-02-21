import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Eva extends Page {
    // при вызове конструктора происодит соединение к нашей странице
    public Eva() {
        connect("https://eva.ua/promotion/catalog/");
    }

    /**
     * В этом методе мы парсим html страницу
     *
     * @return - список элементотов ввиде строки
     */
    public String getEva() {
        // имя страницы
        int name = 0;
        //создаем список в который будем помещать наши элементы
        List<EvaCatalog> evaCatalogList = new ArrayList<>();
        //указываем с какого места нашей html страницы будем вытягивать элементы
        Elements elements = getDocument().getElementsByClass("flipmagazine MINI").select("div > img");

        //в цикле будем доставать наши элементы, указывая с какого поля (select) и какими параметрами
        for (Element element : elements) {
            //указываем, что нам необходим элемент страници с атрибутом src - это и есть url каринки, усанавливаем ему имя img
            String img = element.attr("src");
            //имя сраницы считаем по порядку, увеличивая на единицу
            name++;
            //попарно помещаем в List наши элементы
            evaCatalogList.add(new EvaCatalog(img, name));
        }
        return String.valueOf(evaCatalogList);
    }
}
