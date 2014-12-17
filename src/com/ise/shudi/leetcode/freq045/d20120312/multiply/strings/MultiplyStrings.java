package com.ise.shudi.leetcode.freq045.d20120312.multiply.strings;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "12415861384129871982412";
		String num2 = "412958156187412391";
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply(num1, num2));
	}
	
	public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        if(l1 == 0 || l2 == 0) {
        	return "0";
        }
        int[] mul = new int[l1 + l2];
        for(int i = 0; i < l1; ++i) {
        	int carry = 0;
        	int n1 = num1.charAt(l1 - i - 1) - '0';
        	for(int j = 0; j < l2; ++j) {
        		int n2 = num2.charAt(l2 - j - 1) - '0';
        		int sum = n1 * n2 + carry + mul[l1 + l2 - i - j - 1];
        		carry = sum / 10;
        		mul[l1 + l2 - i - j - 1] = sum % 10;
        	}
        	if(carry > 0) {
        		mul[l1 - i - 1] = carry;
        	}
        }
        int start = 0;
        while(start < mul.length && mul[start] == 0) {
        	++start;
        }
        if(start == mul.length) {
        	return "0";
        }
        String result = "";
        for(int i = start; i < mul.length; ++i) {
        	result += mul[i];
        }
        return result;
    }

}
