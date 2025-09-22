class Solution {
    public int myAtoi(String s) {
         s = s.trim();
        if (s.length() == 0) return 0;

        int i = 0;
        int sign = 1;
        long result = 0;  // use long to detect overflow

        // Step 2: Handle sign
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Process digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // Step 4: Clamp values if overflow
            if (sign * result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign * result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

            i++;
        }

        return (int)(sign * result);
    }
}