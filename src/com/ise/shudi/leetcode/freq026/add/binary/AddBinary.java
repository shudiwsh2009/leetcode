package com.ise.shudi.leetcode.freq026.add.binary;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "11";
		String b = "1";
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary(a, b));
	}
	
	public String addBinary(String a, String b) {
		char[] acs = a.toCharArray();
		char[] bcs = b.toCharArray();
		int i = acs.length - 1, j = bcs.length - 1;
		char[] ccs = new char[Math.max(acs.length, bcs.length) + 1];
		int k = ccs.length - 1;
		int flag = 0;
		while(i >= 0 && j >= 0) {
			int val = (acs[i--] - '0') + (bcs[j--] - '0') + flag;
			ccs[k--] = (char) (val % 2 + '0');
			flag = val / 2;
		}
		while(i >= 0) {
			int val = (acs[i--] - '0') + flag;
			ccs[k--] = (char) (val % 2 + '0');
			flag = val / 2;
		}
		while(j >= 0) {
			int val = (bcs[j--] - '0') + flag;
			ccs[k--] = (char) (val % 2 + '0');
			flag = val / 2;
		}
		if(flag == 1) {
			ccs[k--] = '1';
		}
		String result = new String(ccs);
		return result.substring(k + 1);
    }

}
