package bot.botodelkin.mainBot.messages;

import bot.botodelkin.mainBot.managers.FileManager;
import org.springframework.beans.factory.annotation.Autowired;

public class TextMessages {



    @Autowired
    private FileManager fileManager;


    protected static final String HELLO_MESSAGE_TEXT = "Приветсвую ! Я бот ботоделкина!";

    protected static final String HELP_MESSAGE_TEXT = "Эта комманда /help";

    protected static final String INFO_MESSAGE_TEXT = "Это комманда /info";

    protected static final String COMMAND_NOT_FOUND_MESSAGE = "Эта комманда не найдена , попробуйте ввести /help для получения справки комманд";





}
