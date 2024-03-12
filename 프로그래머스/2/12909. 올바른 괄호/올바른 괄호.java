import java.util.*;

class Solution {
    boolean solution(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(')
                res++;
            else if(s.charAt(i)==')'){
                if(res==0)
                    return false;
                res--;
            }
        }
        
        return res==0;
    }
}