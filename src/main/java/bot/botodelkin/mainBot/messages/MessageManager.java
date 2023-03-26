package bot.botodelkin.mainBot.messages;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class MessageManager extends TextMessages {
    //   private TextMessages textMessages;


    public MessageManager(){}



    public SendMessage processTheMessage(Message message){
        String textMessage = message.getText();
        Long chatID = message.getChatId();


        switch (textMessage){
            case "/start" : return getTheHelloMessage(chatID);
            case "/help" : return getTheHelpMessage(chatID);
            case "/newbotinfo" :  return getTheInfoMessage(chatID);
            case "/getthereviews" : return getTheViewReviewsBeforeMessage();
            case "/newbot" : return getOrderTextMessageBefore(chatID);
            default: return getCommandNotFoundMessage(chatID);
        }

    }


    public Object processTheCallback(CallbackQuery callbackQuery){

        return null;
    }



//    public MessageManager(TextMessages textMessages){
//        this.textMessages = textMessages;
//    }
//

    public SendMessage getOrderTextMessageBefore(Long chatID){
        return null;

    }




    // TODO : Попробывать ральзовать один уникальный метод который будет принемать
    //        на вход несколько параметров которые описывают сообщение , и на осно
    //        ваний этих параметров возвращать определенный SendMessage
//    public SendMessage getTheMessage(? , ? , ?){
//        return null;
//    }


    public SendMessage getTheViewReviewsBeforeMessage(){
        return null;
    }


    public SendMessage getTheViewReviewsAfterMessage(){
        return null;
    }

    public SendMessage getTheBeforeOrderMessage(){
        return null;
    }

    public SendMessage getTheBeforeFeedbackMessage(Long chatID){
        return null;
    }

    public SendMessage getTheHelloMessage(Long chatId){

        return SendMessage
                .builder()
                .text(HELLO_MESSAGE_TEXT)
                .chatId(chatId)
                .replyMarkup(
                        InlineKeyboardMarkup
                                .builder()
                                .keyboardRow(
                                        new ArrayList<>(
                                                Arrays.asList(
                                                        InlineKeyboardButton
                                                                .builder()
                                                                .text("RU")
                                                                .callbackData("LANG_CODE_RU")
                                                                .build() ,

                                                        InlineKeyboardButton
                                                                .builder()
                                                                .text("RO")
                                                                .callbackData("LANG_CODE_RO")
                                                                .build() ,

                                                        InlineKeyboardButton
                                                                .builder()
                                                                .text("EN")
                                                                .callbackData("LANG_CODE_EN")
                                                                .build()
                                                ) // asList
                                        ) // arrayList
                                ).build() // keyboardRow

                )  // replayMarkup
                .build();
    }

    public SendMessage getTheHelpMessage(Long chatID){

        return SendMessage
                .builder()
                .text(HELP_MESSAGE_TEXT)
                .chatId(chatID)
                .build();
    }





    public SendMessage getTheInfoMessage(Long chatID){

        return SendMessage
                .builder()
                .text(INFO_MESSAGE_TEXT)
                .chatId(chatID)
                .build();
    }


    public SendMessage getCommandNotFoundMessage(Long chatID){

        return SendMessage
                .builder()
                .text(COMMAND_NOT_FOUND_MESSAGE)
                .chatId(chatID)
                .build();
    }


}
