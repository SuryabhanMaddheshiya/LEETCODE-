class Solution {
    public int myAtoi(String s) {
        long result=0;
        boolean neg=false;
        int i=0;
        while(i<s.length() && s.charAt(i)==' ')
            i++;
        if(i<s.length() && s.charAt(i)=='-')
        {
            neg=true;
            i++;
        }
        else if(i<s.length() && s.charAt(i)=='+')
        {
            i++;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i)))
        {
            int ascii=s.charAt(i)-'0';
            result=result*10 + ascii;
            if(neg)
            {
                if(result*(-1)<Integer.MIN_VALUE)
                     return Integer.MIN_VALUE;
            }
            else
            {
                if(result>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
            i++;
        }
        if(result==0)
            return 0;
        else
            return neg? (int)result*(-1) : (int)result;
    }
}