import java.util.ArrayList;

public class HelloWorld {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(11);
		list2.add(21);
		list2.add(31);
		list2.add(41);
		list2.add(51);
		list2.add(61);
		list2.add(71);
		list2.add(81);
		list2.add(91);

		if (list1.size() > list2.size()) {
			int j = 0;
			for (int i = 0; i < list2.size(); i++) {
				System.out.println(list2.get(i));
				System.out.println(list1.get(j++));
				System.out.println(list1.get(j++));
				System.out.println();
			}
		}

		if (list2.size() > list1.size()) {
			int j = 0;
			for (int i = 0; i < list1.size(); i++) {
				System.out.println(list1.get(i));
				System.out.println(list2.get(j++));
				System.out.println(list2.get(j++));
				System.out.println();
			}
		}
	}

}
