package bot.botodelkin.mainBot;

import bot.botodelkin.mainBot.messages.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;

@Component
public class MainBotClass extends TelegramLongPollingBot {

    @Value("${tg.name}")
    private String botUserName;

    @Value("${tg.token}")
    private String botToken;

    @Autowired
    private MessageManager messageManager;

    @PostConstruct
    public void init(){
        try {
            System.out.println("BOT START ...");
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(this);
            System.out.println("BOT STARTED SUCCESSFUL");
        }catch (Exception e){
            System.err.println("BOT NOT STARTED!");
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return botUserName;
    }

    public String getBotToken() {
        return botToken;
    }

    public void onUpdateReceived(Update update) {

        try{

            execute(
                     this.messageManager.processTheMessage(update.getMessage())

                );
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
