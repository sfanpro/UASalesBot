import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;


public class Bot extends TelegramLongPollingBot {
    // id чата
    private long chat_id;

    public void onUpdateReceived( Update update ) {
        // обновляем id юзера
        update.getUpdateId();

        /*создаем экземпляр класса отправки сообшения, устанавливая id чата = id чата при полученном
         сообщении от того же человека*/
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());

        // устанавливаем id чата -id чата полученного сообщения
        chat_id = update.getMessage().getChatId();
        //обрабатываем полученное сообщение
        try {
            sendMessage.setText(input(update.getMessage().getText()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //отвечаем на полученное сообщение, сообщения будем осылать в стиле Markdown, для корректного
        //отображения ссылок и применения различных стилей оформления шрифта
        try {
            execute(sendMessage.setParseMode("Markdown"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод ввод данных отвечает на входящее сообщение
     *
     * @param msg - входной праметр, входящее сообщение
     * @return - возвращает общее шаблонное сообщение c вариантами ввода
     * @throws IOException
     */
    public String input( String msg ) throws IOException {
        if (msg.contains("Hi") || msg.contains("Hello") || msg.contains("Привет") || msg.contains("start")) {
            //при получении "Hi", "Hello", "Привет", "start" возвращает строку с вариантами ответа
            return "Привіт ДРУЖЕ! Надішли: класс, эпицентр або ева; чи 1, 2, 3";
        }
        if (msg.contains("класс") || msg.contains("1")) {
            // инициализируем объект класса Klass и возвращаем значения полученные в методе getKlass()
            return new Klass().getKlass();
        }
        if (msg.contains("эпицентр") || msg.contains("2")) {
            // инициализируем объект класса Epicentr и возвращаем значения полученные в методе getEpicentr()
            return new Epicentr().getEpicentr();
        }
        if (msg.contains("ева") || msg.contains("3")) {
            // инициализируем объект класса Eva ивозвращаем значения полученные в методе getEva()
            return new Eva().getEva();
        }
        return "Щось не те! \nкласс, эпицентр або ева; чи 1, 2, 3";
    }

    /**
     * Получаем имя нашего бота
     *
     * @return - указываем имя нашего бота
     */
    public String getBotUsername() {
        return "@UAsalesBot";
    }

    /**
     * Получаем токен нашего бота
     *
     * @return - указываем токен полученный от BotFather при регистрации нашего бота в Telegram
     */
    public String getBotToken() {
        return "";
    }
}
