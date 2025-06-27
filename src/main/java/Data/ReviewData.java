package Data;

public class ReviewData {

    private static String Name = "alex";
    private static String Email = "alexpato@gmail.com";
    private static String addReview = " Great Tshirt With High Quality Materials";


    public ReviewData(){
    }

    public static String getEmailReview(){
        return Email;
    }
    public static String addReviewMsg(){
        return addReview;
    }
    public static String getNameReview(){
        return Name;
    }



}
