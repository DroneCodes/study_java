package leetcodeQuestions;

public class BackspaceStringCompare {

public static boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        int skipS = 0;
        int skipT = 0;

        while(i>=0 || j>=0){
            while(i>=0){
                if(S.charAt(i)=='#'){
                    skipS++;
                    i--;
                }
                else if(skipS>0){
                    skipS--;
                    i--;
                }
                else{
                    break;
                }
            }
            while(j>=0){
                if(T.charAt(j)=='#'){
                    skipT++;
                    j--;
                }
                else if(skipT>0){
                    skipT--;
                    j--;
                }
                else{
                    break;
                }
            }
            if(i>=0 && j>=0 && S.charAt(i)!=T.charAt(j)){
                return false;
            }
            if((i>=0) != (j>=0)){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        System.out.println(backspaceCompare(S,T));
    }

    public boolean backspaceStringCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private String buildString(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}

