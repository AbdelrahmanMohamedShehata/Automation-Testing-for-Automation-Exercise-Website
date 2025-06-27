package Data;

public class PaymentData {
    private static final String nameOnCard = "Alex Patto";
    private static final String cardNumber = "013242345333";
    private static final String CVC = "344";
    private static final String ExpirationMonth = "11";
    private static final String ExpirationYear = "2027";

    public String getNameOnCard(){
        return nameOnCard;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public String getCVC(){
        return CVC;
    }

    public String getExpirationMonth(){
        return ExpirationMonth;
    }

    public String getExpirationYear(){
        return ExpirationYear;
    }


}
