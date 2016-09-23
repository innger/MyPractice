package com.ryl.learn.lecode;

import java.util.*;

/**
 * EasyImpl 实现
 * Created on 16/7/7 下午3:28.
 */
public class EasyImpl {
	
	public static void main(String[] args) {
		EasyImpl easy = new EasyImpl();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		System.out.println(easy.isSymmetric(root));
		System.out.println(easy.guessNumber(1792997410));
		
		//[1,2,3,4,5]
		//[1,2,null,3,null,4,null,5,null]
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(null);
		list.add(3);
		list.add(null);
		list.add(4);
		list.add(null);
		list.add(5);
		list.add(null);
		TreeNode head = easy.constructTree(list);
		System.out.println(easy.levelOrder(head));
		System.out.println(easy.generatePossibleNextMoves("++++-"));
		System.out.println(easy.canConstruct("a", "b"));
		System.out.println(easy.canConstruct("aa", "ab"));
		System.out.println(easy.canConstruct("aa", "aab"));
		System.out.println(easy.firstUniqChar("leetcode"));
		System.out.println(easy.firstUniqChar("loveleetcode"));
		System.out.println(easy.findTheDifference("abcd", "abcde"));
		
		System.out.println(easy.canPermutePalindrome("code"));
		System.out.println(easy.canPermutePalindrome("aab"));
		System.out.println(easy.canPermutePalindrome("carerac"));
		
		List<String> words = new ArrayList<String>();
		words.add("practice");
		words.add("makes");
		words.add("perfect");
		words.add("coding");
		words.add("makes");
		System.out.println(easy.shortestDistance(words, "coding", "practice"));
		System.out.println(easy.shortestDistance(words, "makes", "coding"));
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(0, 30));
		intervals.add(new Interval(5, 10));
		intervals.add(new Interval(15, 20));
		System.out.println(easy.canAttendMeetings(intervals));
		
		System.out.println(easy.isStrobogrammatic("69"));
		System.out.println(easy.isStrobogrammatic("881"));
		System.out.println(easy.isStrobogrammatic("818"));
		
		List<String> strings = new ArrayList<String>();
		strings.add("abc");
		strings.add("bcd");
		strings.add("acef");
		strings.add("xyz");
		strings.add("az");
		strings.add("ba");
		strings.add("a");
		strings.add("z");
		easy.groupStrings(strings).forEach(System.out::println);
		System.out.println(easy.readBinaryWatch(1));
		System.out.println(easy.maxRotateFunction(new int[]{-2147483648, -2147483648}));
		
		System.out.println(easy.integerReplacement(8));
		System.out.println(easy.integerReplacement(7));
		
		System.out.println(easy.findNthDigit(1000));
		System.out.println(easy.findNthDigit(3));
		System.out.println(easy.findNthDigit(10));
		System.out.println(easy.findNthDigit(11));
		System.out.println(easy.findNthDigit(12));
		System.out.println(easy.findNthDigit(13));
		System.out.println(easy.findNthDigit(14));
		System.out.println(easy.findNthDigit(15));
		System.out.println(easy.findNthDigit(16));
		System.out.println(easy.findNthDigit(17));
		
	}
	
	/**
	 * 397. Integer Replacement
	 * Given a positive integer n and you can do operations as follow:
	 * 1.If n is even, replace n with n/2.
	 * 2.If n is odd, you can replace n with either n + 1 or n - 1.
	 * What is the minimum number of replacements needed for n to become 1?
	 *
	 * @param n int
	 * @return int
	 */
	public int integerReplacement(int n) {
		int c = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				//偶数,除2 >>> unsigned shift 高位用0补上
				n >>>= 1;
			} else if (n == 3 || ((n >>> 1) & 1) == 0) {
				//判断 +1 -1 的条件
				//n低第二位为0
				--n;
			} else {
				++n;
			}
			++c;
		}
		return c;
	}
	
	/**
	 * 396. Rotate Function
	 * Given an array of integers A and let n to be its length.
	 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
	 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
	 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
	 * <p>
	 * n is guaranteed to be less than 10^5.
	 *
	 * @param A int[]
	 * @return int
	 */
	public int maxRotateFunction(int[] A) {
		if (A == null || A.length == 0) return 0;
		long max = Integer.MIN_VALUE;
		int len = A.length;
		for (int i = 0; i < len; i++) {
			long F = 0;
			int begin = i == 0 ? 0 : len - i;
			for (int j = 0; j < len; j++) {
				if (begin > len - 1) begin = 0;
				F += j * A[begin];
				begin++;
			}
			if (F > max) {
				max = F;
			}
		}
		return Long.valueOf(max).intValue();
	}
	
	/**
	 * 400. Nth Digit
	 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
	 * n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
	 * 3 - 3
	 * 11 - 1,2,3,4,5,6,7,8,9,1[0],11
	 * 1 - n 序列,找出第n个数字,10是两个数字
	 * 生成digit个数的数组,定位到区间段,在根据 除数/余数定位到数字
	 * [9, 180, 2700, 36000, 450000, 5400000, 63000000, 720000000, 8100000000]
	 *
	 * @param n int
	 * @return int
	 */
	public int findNthDigit(int n) {
		List<Long> list = new ArrayList<Long>();
		long b = 9;
		for (int i = 1; i < 10; i++) {
			list.add(i * b);
			b = b * 10;
		}
		long total = 0;
		int index = 0;
		long diff = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i);
			if (total > n) {
				index = i;
				if (i > 0) {
					diff = n - (total - list.get(i));
				} else {
					diff = n;
				}
				break;
			}
		}
		int begin = (int) Math.pow(10, index);
		index++;
		long cnt = diff / index;
		long mod = diff % index;
		long result = begin + cnt;
		String str;
		int digit;
		if (mod == 0) {
			str = String.valueOf(result - 1);
			digit = str.charAt(str.length() - 1) - '0';
		} else {
			str = String.valueOf(result);
			digit = str.charAt((int) (mod - 1)) - '0';
		}
		return digit;
	}
	
	/**
	 * 401. Binary Watch
	 * 二进制手表
	 * A binary watch has 4 LEDs on the top which represent the hours (0-11), [8, 4, 2, 1]
	 * and the 6 LEDs on the bottom represent the minutes (0-59). [32, 16, 8, 4, 2, 1]
	 * <p>
	 * Given a non-negative integer n which represents the number of LEDs that are currently on,
	 * return all possible times the watch could represent.
	 * <p>
	 * 枚举法,讲所有可能存入map,再做组合
	 *
	 * @param num int
	 * @return list string
	 */
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<String>();
		if (num > 8) return res;
		Map<Integer, List<String>> hourMap = new HashMap<Integer, List<String>>();
		Map<Integer, List<String>> minuteMap = new HashMap<Integer, List<String>>();
		fillMap(12, hourMap);
		fillMap(60, minuteMap);
		
		for (int i = 0; i <= num; i++) {
			List<String> hourList = hourMap.get(i);
			if (hourList == null) {
				continue;
			}
			List<String> minuteList = minuteMap.get(num - i);
			if (minuteList == null) {
				continue;
			}
			for (String h : hourList) {
				for (String m : minuteList) {
					res.add(h + ":" + m);
				}
			}
		}
		return res;
	}
	
	private int getBitNum(int n) {
		int cnt = 0;
		while (n > 0) {
			cnt++;
			n = (n - 1) & n;
		}
		return cnt;
	}
	
	private void fillMap(int n, Map<Integer, List<String>> map) {
		for (int i = 0; i < n; i++) {
			int bits = getBitNum(i);
			List<String> list = map.get(bits);
			if (list == null) {
				list = new ArrayList<String>();
				map.put(bits, list);
			}
			list.add((n == 60 && i < 10 ? "0" : "") + i);
		}
	}
	
	
	/**
	 * 157. Read N Characters Given Read4
	 * The API: int read4(char[] buf) reads 4 characters at a time from a file.
	 * The return value is the actual number of characters read.
	 * For example, it returns 3 if there is only 3 characters left in the file.
	 * By using the read4 API, implement the function int read(char[] buf, int n) that reads n characters from the file.
	 *
	 * @param buf char[]
	 * @param n   int
	 * @return int 实际读取字符数
	 */
	public int read(char[] buf, int n) {
		int read = 0;
		char[] temp = new char[4];
		while (read < n) {
			int r = read4(temp);
			for (int i = 0; read < n && i < r; i++) {
				buf[read++] = temp[i];
			}
			if (r < 4) break;
		}
		return read;
	}
	
	private int read4(char[] buf) {
		return 3;
	}
	
	/**
	 * 276. Paint Fence
	 * There is a fence with n posts, each post can be painted with one of the k colors.
	 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
	 * 最多有两个相邻柱子颜色相同
	 * 所以在染一个柱子的时候, 要考虑是否和上一个柱子颜色相同.
	 * 如果和上一个相同的话,那么上一个有多少种和上上次不同的染色方案, 那么当前柱子也有多少种染色方案.
	 * 如果和上一个不同的话,那么染色方案就为(k-1)*(之前总共多少染色方案).
	 * O(n) time O(1) space
	 * https://discuss.leetcode.com/topic/36580/complete-explanation-o-n-time-o-1-space
	 *
	 * @param n int n个柱子
	 * @param k int k种颜色 n k are non-negative integers.
	 * @return int
	 */
	public int numWays(int n, int k) {
		if (n == 0 || k == 0 || (k == 1 && n > 2)) return 0;
		int same = 0, diff = k, total = k;
		for (int i = 2; i <= n; i++) {
			same = diff;
			diff = (k - 1) * total;
			total = same + diff;
		}
		return total;
	}
	
	/**
	 * 249. Group Shifted Strings
	 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
	 * We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz"
	 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
	 * 将每个字符串都转换成减去字符串首字符之后的字符串，这样可以相互转换的字符串就转化成了一个key
	 *
	 * @param strings list
	 * @return list.list
	 */
	public List<List<String>> groupStrings(List<String> strings) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strings) {
			String key = "";
			for (int i = 0; i < str.length(); i++) {
				key += (str.charAt(i) - str.charAt(0) + 26) % 26 + 'a';
			}
			List<String> list = map.get(key);
			if (list == null) {
				list = new ArrayList<String>();
				list.add(str);
				map.put(key, list);
			} else {
				list.add(str);
			}
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for (List<String> value : map.values()) {
			Collections.sort(value);
			result.add(value);
		}
		return result;
	}
	
	/**
	 * 270. Closest Binary Search Tree Value
	 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
	 *
	 * @param root   TreeNode
	 * @param target double
	 * @return int
	 */
	public int closestValue(TreeNode root, double target) {
		long ans = root.val, val = Long.MAX_VALUE;
		if (target > ans && root.right != null)
			val = closestValue(root.right, target);
		else if (target <= ans && root.left != null)
			val = closestValue(root.left, target);
		if (Math.abs(val - target) < Math.abs(ans - target))
			ans = val;
		return (int) ans;
	}
	
	/**
	 * 246. Strobogrammatic Number
	 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
	 * the numbers "69", "88", and "818" are all strobogrammatic.
	 *
	 * @param num string
	 * @return boolean
	 */
	public boolean isStrobogrammatic(String num) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');
		map.put('1', '1');
		map.put('0', '0');
		int len = num.length();
		for (int i = 0; i <= (len + 1) / 2; i++) {
			char c1 = num.charAt(i);
			char c2 = num.charAt(len - i - 1);
			if (map.get(c1) != c2) return false;
		}
		return true;
	}
	
	/**
	 * 252. Meeting Rooms
	 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
	 * determine if a person could attend all meetings.
	 * [[0, 30],[5, 10],[15, 20]] return false
	 * 查区间是否有重合,先按照start排个序，然后查看是否每个会议的的开始时间都比前一个结束时间大
	 *
	 * @param intervals list
	 * @return boolean
	 */
	public boolean canAttendMeetings(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) return false;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start > intervals.get(i - 1).end) return false;
		}
		return true;
	}
	
	static class Interval {
		private int start;
		private int end;
		
		public Interval() {
			this.start = 0;
			this.end = 0;
		}
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}
	
	/**
	 * 243. Shortest Word Distance
	 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
	 * ["practice", "makes", "perfect", "coding", "makes"]
	 * "coding" "practice" return 3
	 * "makes" "coding" return 1
	 *
	 * @param words list
	 * @param word1 string
	 * @param word2 string
	 * @return int
	 */
	public int shortestDistance(List<String> words, String word1, String word2) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals(word1)) {
				list1.add(i);
			} else if (words.get(i).equals(word2)) {
				list2.add(i);
			}
		}
		int i = 0;
		int j = 0;
		int ans = Integer.MAX_VALUE;
		while (i < list1.size() && j < list2.size()) {
			ans = Math.min(ans, Math.abs(list1.get(i) - list2.get(j)));
			//一个小小的技巧将时间复杂度由O(m*n)降为O(m+n).
			if (list1.get(i) < list2.get(j))
				i++;
			else
				j++;
		}
		return ans;
	}
	
	/**
	 * 266. Palindrome Permutation
	 * Given a string, determine if a permutation of the string could form a palindrome.
	 * "code" -> False, "aab" -> True, "carerac" -> True.
	 * 判断一个字符串的组合是否能组成回文
	 * 出现的字符全部是偶数次,或者只有一个字符出现奇数次
	 *
	 * @param s string
	 * @return boolean
	 */
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0) return false;
		if (s.length() == 1) return true;
		int[] arr = new int[256];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			arr[ch]++;
		}
		int count = 0;
		for (int n : arr) {
			if ((n & 1) == 1) count++;
		}
		return count <= 1;
	}
	
	/**
	 * 389. Find the Difference
	 * Given two strings s and t which consist of only lowercase letters.
	 * String t is generated by random shuffling string s and then add one more letter at a random position.
	 * Find the letter that was added in t.
	 *
	 * @param s string
	 * @param t string
	 * @return char
	 */
	public char findTheDifference(String s, String t) {
		int sums = 0;
		for (int i = 0; i < s.length(); i++) {
			sums += s.charAt(i);
		}
		int sumt = 0;
		for (int i = 0; i < t.length(); i++) {
			sumt += t.charAt(i);
		}
		return (char) (sumt - sums);
	}
	
	/**
	 * 387. First Unique Character in a String
	 * 找出字符串中第一个不重复的字符
	 * <p>
	 * Given a string, find the first non-repeating character in it and return it's index.
	 * If it doesn't exist, return -1.
	 * s = "leetcode" return 0
	 * s = "loveleetcode" return 2
	 *
	 * @param s string
	 * @return index int
	 */
	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) return -1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			Integer cnt = map.get(ch);
			if (cnt == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, cnt + 1);
			}
		}
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (map.get(ch) == 1) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 383. Ransom Note 赎金
	 * return true if the ransomNote can be constructed from the magazines
	 * otherwise it will return false
	 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
	 * You may assume that both strings contain only lowercase letters.
	 * canConstruct("a", "b") -> false
	 * canConstruct("aa", "ab") -> false
	 * canConstruct("aa", "aab") -> true
	 * bug-free
	 *
	 * @param ransomNote String
	 * @param magazine   String
	 * @return true/false
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == null || ransomNote.length() == 0) return true;
		if (magazine == null || magazine.length() == 0) return false;
		for (int i = 0; i < magazine.length(); i++) {
			char ch = magazine.charAt(i);
			ransomNote = ransomNote.replaceFirst("" + ch, "");
		}
		return ransomNote.trim().length() == 0;
	}
	
	/**
	 * 1000个数范围[0,999],有2个相同的数，求这个
	 * 令牌桶算法
	 * 或者
	 * 设少的是a，多的是b。扫一遍，求和减（0到999），得到b-a，求平方和然后减去0到999的平方。
	 * 得到b^2-a^2，然后可以得到b+a，然后算出来b
	 *
	 * @param arr int[]
	 * @return int duplicate number
	 */
	public int findDuplicate(int[] arr) {
		int i = 0;
		int temp;
		while (i < arr.length) {
			if (arr[i] == i) {
				i++;
			} else {
				if (arr[i] == arr[arr[i]]) {
					return arr[i];
				} else {
					temp = arr[i];
					arr[i] = arr[temp];
					arr[temp] = temp;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 293. Flip Game
	 * take turns to flip two consecutive "++" into "--".
	 * s = "++++"
	 * output : "--++", "+--+", "++--"
	 * 判断连续的是不是"++",将其反转后加入结果中去.
	 *
	 * @param s string
	 * @return List string
	 */
	public List<String> generatePossibleNextMoves(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() < 2) return result;
		for (int i = 0; i < s.length() - 1; i++) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i + 1);
			if (c1 == '+' && c2 == '+') {
				result.add(s.substring(0, i) + "--" + s.substring(i + 2));
			}
		}
		return result;
	}
	
	/**
	 * 374. Guess Number Higher or Lower
	 * pick a number from 1 to n. You have to guess which number I picked.
	 * 数字猜大小 二分查找
	 *
	 * @param n int
	 * @return int
	 */
	public int guessNumber(int n) {
		int i = 1;
		int j = n;
		while (i < j) {
			int g = (j - i) / 2 + i; //(high - low) / 2 + low; // 直接使用(high + low) / 2 可能导致溢出
			int res = guess(g);
			if (res == 0) {
				return g;
			} else if (res == -1) {
				//my number is lower 猜大了
				j = g - 1;
			} else if (res == 1) {
				//my number is higher 猜小了
				i = g + 1;
			}
		}
		return i;
	}
	
	/* The guess API is defined in the parent class GuessGame.
		@param num, your guess
		@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
	  int guess(int num);
	  1792997410
	  1240808008
	 */
	private int guess(int num) {
		int mynumber = 1240808008;
		if (mynumber == num) {
			return 0;
		} else if (mynumber > num) {
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * 101. Symmetric Tree
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 * 判断二叉树是否对称
	 * recursively and iteratively
	 *
	 * @param root TreeNode
	 * @return true/false
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		// left.left right.right 和 right.left,left.right
		return left != null && right != null && left.val == right.val && isSymmetric(left.left, right.right) &&
				isSymmetric(right.left, left.right);
	}
	
	/**
	 * 遍历方式,队列实现
	 * 分层打印类似
	 *
	 * @param root TreeNode
	 * @return true/false
	 */
	public boolean isSymmetricIterative(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node1 = q.poll();
			TreeNode node2 = q.poll();
			if (node1 == null && node2 == null) continue;
			if (node1 == null || node2 == null) return false;
			if (node1.val != node2.val) return false;
			q.add(node1.left);
			q.add(node2.right);
			q.add(node1.right);
			q.add(node2.left);
		}
		return true;
	}
	
	/**
	 * 102. Binary Tree Level Order Traversal
	 * from left to right, level by level
	 * 从上到下按层打印二叉树节点值
	 * 剑指offer deque
	 *
	 * @param root TreeNode
	 * @return List the level order traversal of its nodes' values
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (true) {
			List<Integer> list = new ArrayList<Integer>();
			Queue<TreeNode> tmpQ = new LinkedList<TreeNode>();
			levelQueue(queue, tmpQ, list);
			if (list.size() > 0) {
				result.add(list);
			}
			if (tmpQ.isEmpty())
				break;
			queue = tmpQ;
		}
		return result;
	}
	
	private void levelQueue(Queue<TreeNode> queue, Queue<TreeNode> tmpQ, List<Integer> list) {
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			list.add(node.val);
			if (node.left != null) {
				tmpQ.add(node.left);
			}
			if (node.right != null) {
				tmpQ.add(node.right);
			}
		}
	}
	
	/**
	 * 107. Binary Tree Level Order Traversal II
	 * from left to right, level by level from leaf to root
	 *
	 * @param root TreeNode
	 * @return List 从下到上按层打印二叉树节点值
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (true) {
			List<Integer> list = new ArrayList<Integer>();
			Queue<TreeNode> tmpQ = new LinkedList<TreeNode>();
			levelQueue(queue, tmpQ, list);
			if (list.size() > 0) {
				stack.push(list);
			}
			if (tmpQ.isEmpty()) {
				break;
			}
			queue = tmpQ;
		}
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		System.out.println(result);
		return result;
	}
	
	
	/**
	 * 257. Binary Tree Paths
	 * Given a binary tree, return all root-to-leaf paths.
	 *
	 * @param root TreeNode
	 * @return List String
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		if (root != null) {
			findPath(root, String.valueOf(root.val), paths);
		}
		return paths;
	}
	
	private void findPath(TreeNode root, String val, List<String> paths) {
		if (root == null) return;
		if (root.left == null && root.right == null) paths.add(val);
		if (root.left != null) {
			findPath(root.left, val + "->" + root.left.val, paths);
		}
		if (root.right != null) {
			findPath(root.right, val + "->" + root.right.val, paths);
		}
	}
	
	
	/**
	 * 225. Implement Stack using Queues
	 * LinkedList 居然实现Deque extends Queue接口
	 */
	class MyStack {
		
		private Queue<Integer> queue1 = new LinkedList<Integer>();
		private Queue<Integer> queue2 = new LinkedList<Integer>();
		
		// Push element x onto stack.
		public void push(int x) {
			while (!queue1.isEmpty()) {
				Integer i = queue1.poll();
				queue2.add(i);
			}
			queue1.add(x);
			while (!queue2.isEmpty()) {
				Integer i = queue2.poll();
				queue1.add(i);
			}
		}
		
		// Removes the element on top of the stack.
		public void pop() {
			queue1.poll();
		}
		
		// Get the top element.
		public int top() {
			return queue1.peek();
		}
		
		// Return whether the stack is empty.
		public boolean empty() {
			return queue1.isEmpty();
		}
	}
	
	
	/**
	 * 232. Implement Queue using Stacks
	 * bug-free
	 */
	class MyQueue {
		
		private Stack<Integer> inStack = new Stack<Integer>();
		private Stack<Integer> outStack = new Stack<Integer>();
		
		// Push element x to the back of queue.
		public void push(int x) {
			while (!inStack.isEmpty()) {
				Integer i = inStack.pop();
				outStack.push(i);
			}
			inStack.push(x);
			while (!outStack.isEmpty()) {
				Integer i = outStack.pop();
				inStack.push(i);
			}
		}
		
		// Removes the element from in front of queue.
		public void pop() {
			inStack.pop();
		}
		
		// Get the front element.
		public int peek() {
			return inStack.peek();
		}
		
		// Return whether the queue is empty.
		public boolean empty() {
			return inStack.isEmpty();
		}
	}
	
	/**
	 * 235. Lowest Common Ancestor of a Binary [Search] Tree
	 * 二叉搜索树 有更方便的解法 bug-free
	 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
	 *
	 * @param root TreeNode
	 * @param p    TreeNode
	 * @param q    TreeNode
	 * @return TreeNode
	 */
	public TreeNode lowestCommonAncestorSearch(TreeNode root, TreeNode p, TreeNode q) {
		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);
		return lowestCommonAncestorValue(root, min, max);
	}
	
	public TreeNode lowestCommonAncestorValue(TreeNode root, int min, int max) {
		if (min <= root.val && max >= root.val) {
			return root;
		}
		if (max <= root.val) {
			return lowestCommonAncestorValue(root.left, min, max);
		} else {
			return lowestCommonAncestorValue(root.right, min, max);
		}
	}
	
	
	/**
	 * 236. Lowest Common Ancestor of a Binary Tree
	 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
	 * 找出二叉树两个节点的最低公共祖先
	 * 两个链表,找最后一个公共节点
	 * 针对任意二叉树的通用解法
	 *
	 * @param root TreeNode
	 * @param p    TreeNode
	 * @param q    TreeNode
	 * @return TreeNode
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		findPath(root, p, stack1);
		findPath(root, q, stack2);
		TreeNode[] arr1 = new TreeNode[stack1.size()];
		int i = stack1.size() - 1;
		while (!stack1.empty()) {
			arr1[i] = stack1.pop();
			i--;
		}
		
		i = stack2.size() - 1;
		TreeNode[] arr2 = new TreeNode[stack2.size()];
		while (!stack2.empty()) {
			arr2[i] = stack2.pop();
			i--;
		}
		TreeNode commom = null;
		i = 0;
		while (i < arr1.length && i < arr2.length) {
			if (arr1[i] == arr2[i]) {
				commom = arr1[i];
			} else {
				break;
			}
			i++;
		}
		return commom;
	}
	
	//使用deque
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		Deque<TreeNode> list1 = new LinkedList<TreeNode>();
		Deque<TreeNode> list2 = new LinkedList<TreeNode>();
		findPath(root, p, list1);
		findPath(root, q, list2);
		TreeNode common = root;
		while (!list1.isEmpty() && !list2.isEmpty()) {
			TreeNode node1 = list1.removeLast();
			TreeNode node2 = list2.removeLast();
			if (node1 == node2) {
				common = node1;
			} else {
				break;
			}
		}
		return common;
	}
	
	
	/**
	 * 剑指offer上最后一题
	 * 2016-07-11 早上来了还是翻书参考才写出来
	 * 二叉树递归遍历,用栈模拟 easy code
	 *
	 * @param root  TreeNode 根节点
	 * @param p     TreeNode 目标节点
	 * @param stack 栈
	 * @return true/false
	 */
	private boolean findPath(TreeNode root, TreeNode p, Stack<TreeNode> stack) {
		if (root == null)
			return false;
		if (root == p) {
			stack.push(root);
			return true;
		}
		boolean res = false;
		stack.push(root); //开始push
		if (root.left != null) {
			res = findPath(root.left, p, stack);
		}
		if (res) return true; //找到节点返回
		if (root.right != null) {
			res = findPath(root.right, p, stack);
		}
		if (!res) stack.pop(); //左右节点均没有找到,pop出来 最后pop 中间不对stack操作
		return res;
	}
	
	/**
	 * 使用双向队列deque遍历
	 *
	 * @param root  TreeNode
	 * @param p     TreeNode
	 * @param deque deque 双向队列
	 * @return true/false
	 */
	private boolean findPath(TreeNode root, TreeNode p, Deque<TreeNode> deque) {
		if (root == null) return false;
		if (root == p) {
			deque.push(root);
			return true;
		}
		boolean res = false;
		deque.push(root);
		if (root.left != null) {
			res = findPath(root.left, p, deque);
		}
		if (res) return true;
		if (root.right != null) {
			res = findPath(root.right, p, deque);
		}
		if (!res) {
			deque.pop();
		}
		return res;
	}
	
	/**
	 * 112. Path Sum
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
	 * adding up all the values along the path equals the given sum.
	 * <p>
	 * 居然bug-free,这都行
	 *
	 * @param root TreeNode
	 * @param sum  int
	 * @return true/false
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return root.val == sum;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	/**
	 * 111. Minimum Depth of Binary Tree
	 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	 * Depth-first Search
	 * Breadth-first Search
	 * 叶子节点到根节点的最短高度
	 * 二叉树递归解法,一般看上去都很对称美
	 *
	 * @param root TreeNode
	 * @return int depth
	 */
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		int left = 0;
		if (root.left != null) {
			left = 1 + minDepth(root.left);
		}
		int right = 0;
		if (root.right != null) {
			right = 1 + minDepth(root.right);
		}
		if (left == 0 || right == 0) {
			return Math.max(left, right);
		}
		return Math.min(left, right);
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	/**
	 * 根据输入的List构造二叉树,二叉堆
	 * [1,2,3,4,5]
	 * [1,2,null,3,null,4,null,5,null]
	 *
	 * @param list List<Integer>
	 * @return head TreeNode
	 */
	public TreeNode constructTree(List<Integer> list) {
		if (list == null || list.isEmpty()) return null;
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		TreeNode head = new TreeNode(list.get(0));
		treeNodes.add(head);
		int len = list.size();
		for (int i = 1; i < len; i++) {
			Integer val = list.get(i);
			if (val == null) {
				treeNodes.add(null);
			} else {
				treeNodes.add(new TreeNode(val));
			}
		}
		for (int i = 1; i < len; i++) {
			TreeNode parent = treeNodes.get((i - 1) / 2);
			if (parent != null) {
				if ((i & 1) != 0) {
					//奇数
					parent.left = treeNodes.get(i);
				} else {
					//偶数
					parent.right = treeNodes.get(i);
				}
			}
		}
		return head;
	}
}
