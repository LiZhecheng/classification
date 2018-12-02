package random;

import java.util.HashSet;
import java.util.Set;

public class RandomNumber {

	private int[] number;
	private int begin;
	private int excludeEnd;

	public RandomNumber() {

	}

	public RandomNumber(int excludeEnd) {
		this.excludeEnd = excludeEnd;
		number = new int[excludeEnd];
		for (int i = 0; i < excludeEnd; i++) {
			number[i] = i;
		}

	}

	public RandomNumber(int begin, int excludeEnd) {
		this.begin = begin;
		this.excludeEnd = excludeEnd;
		number = new int[begin - excludeEnd];
		for (int i = begin; i < excludeEnd; i++) {
			number[i - begin] = i;
		}
	}

	// 取的亂數會重複
	// times 要幾個亂數, begin 和 excludeEnd 亂數的範圍
	// ex : 要2~30的亂數(頭尾都包含)4個, 就用 repeatRandomNumber(4, 2, 31)
	public int[] repeatRandomNumber(int times, int begin, int excludeEnd) {

		int[] randomNumber = new int[times];
		int range = excludeEnd - begin; // 不包含尾端就不+1了
		for (int i = 0; i < times; i++) {
			randomNumber[i] = begin + (int) (Math.random() * range);
		}

		return randomNumber;
	}
/*	
	public int repeatRandomNumber( int begin, int excludeEnd) {

		int range = ; // 不包含尾端就不+1了
		randomNumber[i] = begin + (int) (Math.random() * (excludeEnd - begin));
		return randomNumber;
	}
*/
	public int[] repeatRandomNumber(int times, int excludeEnd) {

		int[] randomNumber = new int[times];
		for (int i = 0; i < times; i++) {
			randomNumber[i] = begin + (int) (Math.random() * excludeEnd);
		}

		return randomNumber;
	}

	public int[] unrepeatRandomNumber(int times) {
		int[] randomNumber = new int[times];
		int range = excludeEnd - begin;
		int tempIndex;
		int tempNumber;
		for (int i = 0; i < times; i++) {
			tempIndex = (int) (Math.random() * (range - i));
			randomNumber[i] = number[tempIndex];
			tempNumber = number[tempIndex];
			number[tempIndex] = number[range - i - 1];
			number[range - i - 1] = tempNumber;
		}
		return randomNumber;
	}
	
	public int[] unrepeatRandomNumber(int times , int excludeEnd) {
		int[] randomNumber = new int[times];
		int count = 0;
	    same:
	    while(count < times) {
	    	randomNumber[count] = (int) (Math.random() * excludeEnd);
	    	for(int i = 0; i < count; i++) {
	    		if(randomNumber[count] == randomNumber[i]) {
	    			continue same;
	    		}
	    	}
	    	count++;
	    }
		return randomNumber;
	}
	
/*	public int[] unrepeatRandomNumber(int times ,int begin, int excludeEnd) {
		int[] randomNumber = new int[times];
		int count = 0;
		int range = excludeEnd - begin;
	    same:
	    while(count < times) {
	    	randomNumber[count] = begin + (int) (Math.random() * range);
	    	for(int i = 0; i < count; i++) {
	    		if(randomNumber[count] == randomNumber[i]) {
	    			continue same;
	    		}
	    	}
	    	count++;
	    }
		return randomNumber;
	}*/
	
	public int[] unrepeatRandomNumber(int times, int begin, int excludeEnd) {
		int[] randomNumber = new int[times];
		int range = excludeEnd - begin;
		for(int i = 0; i < times; i++) {
			randomNumber[i] = begin + (int) (Math.random() * range);
			//j<i這樣就不會因為比到同索引, 而要重亂數
			for(int j = 0; j < i; j++) {
				if(randomNumber[i] == randomNumber[j]) {
					i--;//亂數有重複這次大迴圈不算
						//在進入下一次迴圈前i會再加1
						//這樣這次索引i的又會重新再亂數一次
				}
			}
		}
		return randomNumber;
	}
	
	public Set<Integer> unrepeatRandomNumberSet(int times, int begin, int excludeEnd) {
		Set<Integer> set = new HashSet<Integer>();
		int range = excludeEnd - begin;
		while(set.size() < times) { 
			//用size來看有沒有取到重複的數, 如果有遇到重複的數size就不會增加
			//因為會add失敗
			//當size的大小與要取幾個亂數相同時, 迴圈就會終止
			set.add( begin + (int) (Math.random() * range));			
		}
		return set;
	}
}
