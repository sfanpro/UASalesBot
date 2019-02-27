package org.telegram.uasales.bot.product;

/**
 * Этот класс будет шаблоном по которому будем добавлять полученные элементы в epicentrProductsList
 */
public class EpicentrProducts {
    //элементы с такими именами и параметрами будем получать при парсинге сраницы
    private String url;
    private String name;
    private String img;

    // для добавления в articleList понадобиться конструктор
    public EpicentrProducts( String url, String name, String img ) {
        this.url = url;
        this.name = name;
        this.img = img;
    }

    //метод с помощью которого будем представлять наши элемменты в стиле Markdown
    @Override
    public String toString() {
        return '\n'+"["+name +"]("+ url +")"+ "[.]("+img+")"+'\n';
    }
}
