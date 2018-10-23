package utility;

public class Validations {

    public static boolean isEmpty(String value) {
        if (value != null) {
            return value.trim().isEmpty();
        }
        return false;
    }
    
    public static boolean isNumeric(String value)
    {
        try{
            if(value!=null)
            {
                Integer.parseInt(value.trim());
                return true;
            }
        }catch(Exception ex){}
         return false;
    }
     public static boolean isFloat(String value)
    {
        try{
            if(value!=null)
            {
                Float.parseFloat(value.trim());
                return true;
            }
        }catch(Exception ex){}
         return false;
    }
    public static boolean ispassword(String value) {
        if (value != null) {
            return value.trim().matches("(.*[0-9].*)") ;
        }
        return false;
    }
     public static boolean ispasswordlen(String value) {
        if (value.length() < 10 && value.length() > 5 ) {
            return true ;
        }
        return false;
    }
   
}
