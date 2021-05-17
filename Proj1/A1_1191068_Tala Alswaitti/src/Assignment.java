import java.util.Scanner;

public class Assignment {
	public static void main(String[] arg) {
		Scanner input = new Scanner(System.in);
		/*
		 * 7-13 Asking the user to enter the left and right bounds and a digit to
		 * exclude it
		 */
		System.out.println("Enter Left bound:");
		int left = input.nextInt(); // left bound
		System.out.println("Enter Right bound:");
		int right = input.nextInt(); // right bound
		System.out.println("Enter digit to exclude it:");
		int digit = input.nextInt(); // digit m
		niceNumbers(left, right, digit); // calling the nice numbers function
	}

	/* this function is used to determines the nice numbers and print them */
	public static void niceNumbers(int left, int right, int digit) {
		int remainder; // remainder of the mod (%10) operation
		int zeroRemainder; // remainder of the mod (%10) operation
		int temp; // temporary place holder of integer for the number
		int sum; // sum of digits
		System.out.println("Nice Numbers in Range Left = " + left + ", Right= " + right + " with exclude digit m= "
				+ digit + "  are:");
		/* this for loop is used to scan all numbers from left to the right bounds */
		for (int i = left; i <= right; i++) {
			if (i == 0 && digit != 0) // if the number is equal to zero print it directly
				System.out.print(i + " ");
			else {
				temp = i; // store the value of i in temp
				zeroRemainder = (temp / 10) % 10; // store the second digit of the number
				sum = 0; // put a initial value in sum
				/*
				 * this while loop is used to check if the number is nice or not by diving it's
				 * digits
				 */
				while (temp != 0) {
					remainder = temp % 10; // store the number's digits one by one from the right
					if (sum > remainder || remainder == digit) // if the sum of the previous digits is greater than the
																// current digit or the digit is equal to the exclude
																// digit it will break the while loop
						break;
					else if (sum == remainder && remainder != 0) // else if the sum of the previous digits is equal to
																	// the current digit and the digit does not equal to
																	// zero it will break the while loop
						break;
					else if (temp >= 1 && temp <= 9) // else it will check if there's only one digit left in the number
														// and print it if it's
						System.out.print(i + " "); // print the number if it's nice
					sum += remainder; // to store the summation of the digits
					if (zeroRemainder == 0 && sum == 0) // this if statement is to check if the number has more than one
														// zero so it's impossible to be a nice number
						break;
					temp /= 10; // to get rid of the current digit and move to the next one
				}
			}
		}

	}
}
