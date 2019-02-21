/**
 * Этот класс будет шаблоном по которому будем добавлять полученные элементы в evaCatalogList
 */
public class EvaCatalog {
    //Создаем элементы нашего класса: в img будем помещать url картики, в имя name - порядковый номер
    public String img;  // url страницы каталога
    public int name;    // имя страницы

    //конструктор понадобиться для помещенияя наших элементов в список
    public EvaCatalog( String img, int name ) {
        this.img = img;
        this.name = name;
    }

    //метод с помощью которого будем представлять наши элемменты в стиле Markdown
    @Override
    public String toString() {
        return "\n[каталог Ева стр: " + name + "](" + img + ")\n";
    }
}
