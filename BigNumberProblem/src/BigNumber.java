import java.util.ArrayList;

public class BigNumber{
    public static void main(String[] args) {
        String x = "100";
        String y = "66";
        System.out.println(bigMultiply(x, y));
    }

    public static String bigSum(String x, String  y){
        String ans = "";
        // x should be bigger or equal with y; If not swap x and y
        if(x.length() < y.length()){
            String tem = x;
            x = y;
            y = tem;
        }
        int length_x = x.length();
        int length_y = y.length();
        int mod = 0, hand = 0, single_digit_x, single_digit_y, single_digit_muliply;
        // itreate over y that have small length
        for (int i = length_y - 1; i != -1; i--){
            length_x --;
            single_digit_x = x.charAt(length_x) - '0';
            single_digit_y = y.charAt(i) - '0';
            single_digit_muliply = single_digit_x + single_digit_y + hand;
            mod = single_digit_muliply % 10;
            ans = mod + ans;
            hand = single_digit_muliply / 10;
        }
        // itreate over x that is still need to add
        for (int i = length_x-1; i != -1; i--){
            single_digit_x = x.charAt(i) - '0';
            single_digit_muliply = single_digit_x + hand;
            mod = single_digit_muliply % 10;
            ans = mod + ans;
            hand = single_digit_muliply / 10;
        }
        
        if (hand != 0) ans = hand + ans;

        return ans;
    }

    public static String bigMultiply(String x, String y){
        int length_x = x.length(), length_y = y.length(), single_digit_x, single_digit_y, single_digit_multiply;
        ArrayList<String> toSumArray = new ArrayList<String>();
        String addZero = "";
        
        for (int i = length_x - 1; i != -1; i--){
            single_digit_x = x.charAt(i) - '0';
            String toSum = "";
            int mod = 0, hand = 0;
            for (int j = length_y - 1; j != -1; j--){
                single_digit_y = y.charAt(j) - '0';
                single_digit_multiply = single_digit_x * single_digit_y + hand;
                mod = single_digit_multiply % 10;
                toSum = mod + toSum;
                hand = single_digit_multiply / 10;
            }
            if (hand != 0) toSum = hand + toSum;
            toSum += addZero;
            addZero += '0';
            toSumArray.add(toSum);
        }
        
        String ans = "0";
        for (String element : toSumArray) {
            ans = bigSum(ans, element);
        }
        return ans;
    }
}
