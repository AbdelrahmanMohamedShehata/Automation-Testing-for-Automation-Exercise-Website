package Data;

public class ContactUsData {
    private static String Email = "alexpato@gmail.com";
    private static String name = "Alex Pato";
    private static String subject = "alexanderpato@gmail.com";
    private static String message = "Alex Pato";
    private static String filePath = System.getProperty("user.dir") +"\\src\\main\\resources\\file1.txt";


    public ContactUsData(){
    }

    public static String getEmail(){
        return Email;
    }
    public static String getSubject(){
        return subject;
    }
    public static String getName(){
        return name;
    }
    public static String getMessage(){
        return message;
    }
    public static String getFilePath(){
        return filePath;
    }



}
