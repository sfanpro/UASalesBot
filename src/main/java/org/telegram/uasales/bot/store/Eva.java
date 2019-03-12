package org.telegram.uasales.bot.store;

import org.jsoup.select.Elements;
import org.telegram.uasales.bot.Page;

public class Eva extends Page {
    // при вызове конструктора происодит соединение к нашей странице
    public Eva() {
        super.connect("https://eva.ua/promotion/catalog/");
    }

    /**
     * В этом методе мы парсим html страницу
     *
     * @return - список элементотов ввиде строки
     */
    public String getEva() {
        // нам понадобиться строка которую будем возврящать
        String info = "";
        //указываем с какого места нашей html страницы будем вытягивать элемент
        Elements elements = getDocument().getElementsByClass("flipmagazine MINI").select("div > img");
        //в цикле будем доставать нашb элементы
        for (int i = 0; i < elements.size(); i++) {
            //указываем, что нам необходим элемент страници с атрибутом src - это и есть url каринки, усанавливаем ему имя img
            String img = elements.attr("src");
            // добавляем в строку наши элементы, именем будет i из цикла начиная с 1
            // и представляем наши элемменты в стиле Markdown
            info += "\n[каталог Ева стр: " + (i + 1) + "](" + img + ")\n";
        }
        return info;
    }
}
