class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1; //once place ke lia 
        int j = num2.length() - 1;  //tense place ke lia 
        int carry = 0; // carry larega 
        StringBuilder ans = new StringBuilder();

        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;
            if(i >= 0)
            sum += num1.charAt(i--) - '0';

            if(j >= 0)
            sum += num2.charAt(j--) - '0';

            ans.append(sum % 10);
            carry = sum / 10;
        }
        return ans.reverse().toString();
    }
}