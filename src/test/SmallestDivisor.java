package test;

public class SmallestDivisor {

	public static int findSmallestDivisor(String s, String t) {

		int resultWhenNoDivisionPossible = -1;
		int lengthS = s.length();
		int lengthT = t.length();

		if (lengthS % lengthT == 0) {
			int factor = lengthS / lengthT;
			String concatenatedString = "";
			for (int i = 0; i < factor; i++) {
				concatenatedString += t;
			}

			if (concatenatedString.equalsIgnoreCase(s)) {
				return lowestSplitPossible(t);
			} else {
				return resultWhenNoDivisionPossible;
			}

		} else {
			return resultWhenNoDivisionPossible;
		}
	}

	public static int lowestSplitPossible(String str) {
		int strLen = str.length();
		int smallestLength = 0;
		boolean splitPossible = false;

		for (int i = 1; i <= strLen/2; i++) {
			String subStr = str.substring(0, i);
			String concatenatedString = "";
			for (int j = 0; j < strLen / subStr.length(); j++) {
				concatenatedString += subStr;
			}
			if (concatenatedString.equalsIgnoreCase(str)) {
				splitPossible = true;
				smallestLength = subStr.length();
				break;
			}
		}

		if (splitPossible) {
			return smallestLength;
		} else {
			return strLen;
		}
	}

	public static void main(String[] args) {

//		String s = "ttyttyttytty";
//		String t = "ttytty";
		
		String s = "aaaa";
		String t = "aa";


		int res = findSmallestDivisor(s, t);
		System.out.println(res);

	}

}
