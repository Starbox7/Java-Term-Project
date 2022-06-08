package p;

public class p {

	public static void main(String[] args) {
		int randomNums[] = new int[10];
		
		for (int i = 0; i < 10; i++) {
			randomNums[i] = (int) (Math.random() * 50);
		}
		
		System.out.print("[");
		for (int i = 0; i < 10; i++) {
			System.out.print(randomNums[i]+"/");
		}
		System.out.print("]");
		
		//while (true) {
			int count = 0;
			for (int i = 10; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (randomNums[i] == randomNums[j]) {
						randomNums[i] = (int) (Math.random() * 50);
					} else {
						count ++;
					}
				}
			}
			if (count == 100) {
				for (int i = 0; i < 10; i++) {
					System.out.print(randomNums[i] + "/");
				}
				//break;
			}
			System.out.print("retry");
		//}
	}
}