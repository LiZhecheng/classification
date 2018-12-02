package random;

import java.util.Iterator;
import java.util.Set;

public class TestSetRandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomNumber rn = new RandomNumber();
		Set random = rn.unrepeatRandomNumberSet(6, 0, 50);
		
		Iterator objs = random.iterator();
		while(objs.hasNext()) {
			System.out.println(objs.next());
		}
	}

}
