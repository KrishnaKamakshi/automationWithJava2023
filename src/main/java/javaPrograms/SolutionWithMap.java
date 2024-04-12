package javaPrograms;

import java.util.HashMap;
import java.util.Map;

public class SolutionWithMap {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int r= 0, l=0; r < s.length(); r++)
        {
            int lastObject = s.indexOf(s.charAt(r), l);
            if (lastObject != r)
            {
                l = lastObject+1;
            }
            maxLength = Math.max(maxLength, r-l+1);
        }
        return  maxLength;
    }
}

