package leetcodeQuestions;

public class LargestGoodInteger {
    public String largestGoodInteger(String num) {
        String maxGoodInteger = "";

        for(int i = 0; i < num.length() - 2; i++) {
           String subString = num.substring(i, i + 3);
           if (subString.charAt(0) == subString.charAt(1) && subString.charAt(1) == subString.charAt(2)) {
               if (subString.compareTo(maxGoodInteger) > 0) {
                   maxGoodInteger = subString;
               }
           }
        }
        return maxGoodInteger;
    }
}
