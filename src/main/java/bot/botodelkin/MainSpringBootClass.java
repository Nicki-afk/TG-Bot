package bot.botodelkin;


import bot.botodelkin.mainBot.messages.MessageManager;
import bot.botodelkin.mainBot.messages.TextMessages;
import org.springframework.context.annotation.*;

import javax.xml.soap.Text;

@Configuration
//@EnableAspectJAutoProxy
@ComponentScan
@PropertySource("classpath:simplesText.properties")
public class MainSpringBootClass {


    @Bean
    public MessageManager messageManager(){
        return new MessageManager();
    }


}
