package database;

public class tttt {
	public static void main(String[] args) {
		int[] arr = new int[] {4, 5, 3, 1, 6, 7, 8, 9, 2 };
		boolean check = findMissingNumber(arr);
		System.out.println("Miss --> " + check);
	}

	public static boolean findMissingNumber(int[] arr) {
		int sum = 0;
		int missSum = 0;
		int j = arr[0];
		for (int i = 0; i < arr.length; i++) {
			missSum = missSum + arr[i];
			sum = sum + j;
			j++;
		}
		
		sum = sum + j;
		System.out.println(sum);
		System.out.println(missSum);
		return sum == missSum;
	}
}
