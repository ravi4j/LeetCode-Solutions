/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

/*
Lets break down the solution step wise.
1) Integer.highestOneBit(num) will give you the value of MSB i.e if given number is 5, 101, we will get 100 which is 4.
2) So subracting 1 from the value obtained from Integer.highestOneBit(num) will give us all one's. Eg 4 will give us 3, i.e 11.
3) (Integer.highestOneBit(num)-1)<< is simply multiplying the number by 2. Eq..  we will get 110 ( i.e 6)
4) Adding one to above number will set the LSB to 1.  Example 110 + 001 = 111
5) Now XOR the num and res to get the answer.  Example  : 101 ^ 111 = 010
*/

public class Number_Complement {
	public static void main(String[] args) {
		Number_Complement solution = new Number_Complement();
		int result = solution.findComplement(5);
		System.out.println(result);
		result = solution.findComplement(1);
		System.out.println(result);
	}

	public int findComplement(int num) {
		int result = ((Integer.highestOneBit(num) - 1) << 1) + 1 ;
		return num ^ result;
	}

}
