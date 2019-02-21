/**
 * Этот класс будет шаблоном по которому будем добавлять полученные элементы в klassProductsList
 */
public class KlassProducts {
    //элементы с такими именами и параметрами будем получать при парсинге сраницы
    private String name;        // имя продукта
    private String img;         // url картинки продукта
    private String oldPrice;    // старая цена
    private String price;       // актуальная цена

    // для добавления в List понадобиться конструктор
    public KlassProducts( String name, String img, String oldPrice, String price ) {
        this.name = name;
        this.img = img;
        this.oldPrice = oldPrice;
        this.price = price;
    }

    //метод с помощью которого будем представлять наши элемменты в стиле Markdown
    @Override
    public String toString() {
        return '\n' + "[" + name + "](" + img + ")" + '\n' +
                "OLD price: `" + oldPrice + "` грн.\n" +
                "NEW PRICE: *" + price + "* грн.\n";
    }
}
