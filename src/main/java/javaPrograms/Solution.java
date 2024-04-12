package javaPrograms;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i= 0; i < s.length(); i++)
        {
            StringBuilder sB = new StringBuilder();
            for (int j=0;j<s.length(); j++)
            {
                if(sB.indexOf(String.valueOf(s.charAt(j))) !=-1)
                {
                    break;
                }
                sB.append(s.charAt(j));
                maxLength = Math.max(maxLength, sB.length());
            }
        }
        return  maxLength;
    }
}

