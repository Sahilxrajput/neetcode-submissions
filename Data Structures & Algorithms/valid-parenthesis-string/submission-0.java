class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0; 
        int leftMax = 0; 

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftMin++;
                leftMax++;
            } else if (ch == ')') {
                leftMin--;
                leftMax--;
            } else { 
                leftMin--; // Assume '*' is ')'
                leftMax++; // Assume '*' is '('
            }
            
            // If max possible open parentheses drops below 0, it's invalid (e.g., "())")
            if (leftMax < 0) return false;
            
            // Min open parentheses can't be negative (a '*' can just be empty string "")
            if (leftMin < 0) leftMin = 0;
        }
        
        return leftMin == 0;
    }
}