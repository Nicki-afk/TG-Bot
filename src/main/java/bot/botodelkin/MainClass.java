package bot.botodelkin;

import bot.botodelkin.mainBot.MainBotClass;
import bot.botodelkin.mainBot.messages.MessageManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(MainSpringBootClass.class);
        MainBotClass mainBotClass = context.getBean(MainBotClass.class , "mainBotClass");



    }





}
