package bot.botodelkin.mainBot.managers;


import bot.botodelkin.MainSpringBootClass;
import bot.botodelkin.mainBot.managers.enums.TypeFile;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileManagerTest {




    private static FileManager manager;


    @BeforeClass
    public static void beforeAll(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainSpringBootClass.class);
        manager = annotationConfigApplicationContext.getBean("fileManager" , FileManager.class);

    }




    @Test
    public void readFiles() {
    }

    @Test
    public void readMediaFiles() {
    }

    @Test
    public void readFeedbackFiles() {
    }

    @Test
    public void saveTheFile() {
        assertTrue(manager.saveTheFile("feedback.txt" , "Cool!" , TypeFile.FEEDBACK));



    }


    @Test
    public void saveTheMediaFileTrue(){
        assertTrue(manager.saveTheMediaFile(new File("Marsh.jpg")));
    }

    @Test
    public void saveTheMediaFileFalse(){
        assertFalse(manager.saveTheMediaFile(new File("Marsh.jpg")));

    }


    @Test
    public void saveTheMediaFileFalseByNull(){
        assertFalse(manager.saveTheMediaFile(null));

    }

    @Test
    public void destroy() {
    }
}