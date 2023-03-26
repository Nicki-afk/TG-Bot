package bot.botodelkin.mainBot.managers;

import bot.botodelkin.mainBot.managers.enums.TypeFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class FileManager {

    @Value("${base.text.path.directory}")
    private String baseFilePath;

    @Value("${base.media.path.directory}")
    private String baseMediaFilesPath;


    @Value("${base.feedback.path.directory}")
    private String baseFeedbackPathDirectory;


    private Map<String , File>mediaAndSimplesFiles;



    public FileManager(){

    }



    @PostConstruct
    public void init(){
        try{

            this.mediaAndSimplesFiles = new LinkedHashMap<>();


            System.out.println("CHECK BASE FILES DIRECTORY ... ");
            if(!new File(baseFilePath).exists()){
                System.out.println("DIRECTORY '" + baseFilePath + "' DON'T EXIST , CREATING NEW DIRECTORY ....");
                    if(!new File(baseFilePath).mkdir()){
                        System.err.println("DIRECTORY DON'T CREATE SUCCESSFUL IN '" + baseFilePath + "'");
                    }
                System.out.println("DIRECTORY CREATE SUCCESSFUL '" + baseFilePath + "'");
            }

            System.out.println("CHECK MEDIA FILES DIRECTORY ... ");
            if(!new File(baseMediaFilesPath).exists()){
                System.out.println("DIRECTORY '" + baseMediaFilesPath + "' DON'T EXIST , CREATING NEW FILE ....");
                if(!new File(baseMediaFilesPath).mkdir()){
                    System.err.println("DIRECTORY DON'T CREATE SUCCESSFUL IN '" + baseMediaFilesPath + "'");
                }

                System.out.println("DIRECTORY CREATE SUCCESSFUL '" + baseMediaFilesPath + "'");
            }

                System.out.println("CHECK FEEDBACK FILES DIRECTORY ...");
                if(!new File(baseFeedbackPathDirectory).exists()){
                    System.out.println("DIRECTORY '" + baseFeedbackPathDirectory + "' DON'T EXIST , CREATING NEW FILE ....");
                    if(!new File(baseFeedbackPathDirectory).mkdir()){
                        System.err.println("DIRECTORY DON'T CREATE SUCCESSFUL IN '" + baseFeedbackPathDirectory + "'");
                    }

                    System.out.println("DIRECTORY CREATE SUCCESSFUL '" + baseFeedbackPathDirectory + "'");
                }




            if(!readFiles() || !readMediaFiles() || !readFeedbackFiles()){
                System.err.println("EXCEPTION BY READING FILES");
            }

            System.out.println("FILES ADDED AND INIT SUCCESSFUL");

        }catch (Exception e){
            e.printStackTrace();
        }
    }




    // Read the text messages files
    public boolean readFiles(){

        System.out.println("READ SIMPLES FILES START ... ");


        try{


            System.out.println("READ FILES IN DIRECTORY ...  : "  + baseFilePath);

            String[]nameFiles = new File(baseFilePath).list();

            for(int i = 0; i < nameFiles.length; i++ ){

                this.mediaAndSimplesFiles.put(nameFiles[i], new File(baseFilePath.concat(nameFiles[i])));
                System.out.println("DEFINED FILE SUCCESSFUL : " + baseFilePath.concat(nameFiles[i]));
            }

            System.out.println("SIMPLE FILES READ SUCCESSFUL");


            return true;


        }catch (Exception e){

            e.printStackTrace();

        }


        return false;
    }


    // Read the images and gif
    public boolean readMediaFiles(){

        System.out.println("READ MEDIA FILES START ... ");

        try{



            System.out.println("READ FILES IN DIRECTORY ...  : "  + baseMediaFilesPath);

            String[]nameFiles = new File(baseMediaFilesPath).list();

            for(int i = 0; i < nameFiles.length; i++ ){

                this.mediaAndSimplesFiles.put(nameFiles[i], new File(baseMediaFilesPath.concat(nameFiles[i])));
                System.out.println("DEFINED FILE SUCCESSFUL : " + baseMediaFilesPath.concat(nameFiles[i]));
            }

            System.out.println("MEDIA FILES READING SUCCESSFUL");


            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
     // read feedback texts files
    public boolean readFeedbackFiles(){


        System.out.println("READ FEEDBACK FILES START ... ");

        try {
            System.out.println("READ FILES IN DIRECTORY ...  : " + baseFeedbackPathDirectory);

            String[] nameFiles = new File(baseFeedbackPathDirectory).list();

            for (int i = 0; i < nameFiles.length; i++) {

                this.mediaAndSimplesFiles.put(nameFiles[i], new File(baseFeedbackPathDirectory.concat(nameFiles[i])));
                System.out.println("DEFINED FILE SUCCESSFUL : " + baseFeedbackPathDirectory.concat(nameFiles[i]));
            }

            System.out.println("FEEDBACK FILES READ SUCCESSFUL");

            return true;


        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }


    public boolean saveTheFile(String nameFile , String text ,  TypeFile typeFile){

        try {
            if (typeFile == TypeFile.FEEDBACK) {

                File file = new File((baseFeedbackPathDirectory.concat(nameFile)));

                if(!file.createNewFile()){
                    System.out.println("ERROR/EXCEPTION BY CREATE FILE");
                    return false;
                }

                try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                     writer.write(text);
                     writer.flush();
                }

                return true;

            }else if (typeFile == TypeFile.MEDIA_FILE){

                // thinked ...
                if(!new File((baseMediaFilesPath.concat(nameFile))).createNewFile()){
                    System.out.println("ERROR/EXCEPTION BY SAVE FILE");
                    return false;
                }
                System.out.println("FILE SAVE SUCCESSFUL");

            }else if(typeFile == TypeFile.SYSTEM_FILE){

                if(!new File((baseFilePath.concat(nameFile))).createNewFile()){
                    System.out.println("ERROR/EXCEPTION BY SAVE FILE");
                    return false;
                }
                System.out.println("FILE SAVE SUCCESSFUL");

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }



    public boolean saveTheMediaFile(File file){


        System.out.println("\nSTART SAVE MEDIA_FILE OPERATION ... ");

        if(file == null){

            System.err.println("IMPOSSIBLE SAVE FILE , FILE IS NULL ");


            return false;

        }

        try {

            String fullPathSavingFile = this.baseMediaFilesPath.concat(file.getName());



            if (!new File(fullPathSavingFile).exists()) {

                if (!new File(fullPathSavingFile).createNewFile()) {
                    System.err.println("FILE DON'T SAVE SUCCESSFUL : " + fullPathSavingFile);
                }


                System.out.println("FILE CREATE SUCCESSFUL ! : " + fullPathSavingFile);
                return true;
            }

            // OTHER LOGIC ...

            System.err.println("ERROR , FILE ALREADY EXIST  : " + fullPathSavingFile);


        }catch (Exception e){
            e.printStackTrace();
        }

        return false;


    }


    // add to signature logo company. Think ...
    public boolean saveTheFeedbackFile(File file , String nameTheCompany){


        System.out.println("\nSTART SAVE FEEDBACK_FILE OPERATION ... ");

        if(file == null){

            System.err.println("FILE IS NULL ERROR BY SAVING : " + nameTheCompany);
            return false;
        }


        try{
            String fullPathSavingFile = this.baseMediaFilesPath.concat(file.getName());




            if(!new File(fullPathSavingFile).exists()){

                if(!new File(fullPathSavingFile).createNewFile()){
                    System.out.println("ERROR BY CREATING FILE : " + fullPathSavingFile);
                }

                System.out.println("FILE IS CREATE/SAVE SUCCESSFUL : " + fullPathSavingFile);

                return true;
            }

            System.out.println("ERROR SAVING FILE , FILE ALREADY EXIST :  " + fullPathSavingFile);

        }catch (Exception e){
            e.printStackTrace();
        }


        return false;

    }



    // Тип файла указывается для того что бы скорктировать путь , добавить files/ + nameFile
    public boolean destroy(String nameFile , TypeFile typeFile){

         String fullFilePath = "";

         if(typeFile == TypeFile.FEEDBACK){
             fullFilePath = fullFilePath.concat(baseFeedbackPathDirectory.concat(nameFile));

         }else if(typeFile == TypeFile.MEDIA_FILE){
             fullFilePath = fullFilePath.concat(baseMediaFilesPath.concat(nameFile));

         }else if(typeFile == TypeFile.SYSTEM_FILE){
             fullFilePath = fullFilePath.concat(baseFilePath.concat(nameFile));

         }else {

             System.err.println("ERROR TypeFile is Null. Impossible delete file");
             return false;
         }

         File file = new File(fullFilePath);

         if(!file.exists()){
             System.out.println("FILE DON'T EXIST");
             return false;
         }

         if(!file.delete()){
             System.out.println("ERROR BY DELETE FILE : " + file);
              return false;
         }

        System.out.println("FILE DELETE SUCCESSFUL");
        return true;
    }

}
