public class BigNumber{
    public static void main(String[] args) {
        String x = "1239745998987528752752758569356965824902759290970779700986";
        String y = "879085204820146283765283467865827245263482742884018471";
        System.out.println(bigSum(x, y));
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
}
