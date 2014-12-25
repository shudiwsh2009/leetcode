package com.ise.shudi.leetcode.freq016.word.ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(start, end, dict));
	}
	
	public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int length = 1;

        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i<count; i++){
                String current = queue.poll();
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j=0; j < current.length(); j++) {
                        if (c == current.charAt(j)) {
                            continue;
                        }
                        String tmp = replace(current, j, c);
                        if (tmp.equals(end)) {
                            return length + 1;
                        }
                        if (dict.contains(tmp)){
                            queue.offer(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

}
