/**
 * author: 牛虻.
 * time:2018/1/31
 * email:pettygadfly@gmail.com
 * doc:
 */
public class StringUtil {


    public static String firstCharToUpper(String str) {
        String firstChar = String.valueOf(str.charAt(0)).toUpperCase();
        str = str.replaceFirst("\\w", firstChar);
        return str;
    }

    public static String firstCharToLower(String str) {
        String firstChar = String.valueOf(str.charAt(0)).toLowerCase();
        str = str.replaceFirst("\\w", firstChar);
        return str;
    }
}
