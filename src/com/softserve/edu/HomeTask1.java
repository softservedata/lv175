package SoftS;

import java.util.ArrayList;
import java.util.List;

public class HomeTasks {
/** <b>������(323):</b> <br/>���� ����������� ����� n. �������� ��� ����������� �����, ������� n � ������� ������� � ���.
 *  @return ��������� List<Integer> � ����������� ����������
 *  @param n - int. ����������� �����, �� ������ �������� ����������� ���������� 
 */
	public static List<Integer> getRelativePrimeNumbers(int n){
		List<Integer> givenNumDividers = new ArrayList<Integer>();
		List<Integer> middleResults = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i = 2; i< n; i++){
			if(n % i == 0){
				givenNumDividers.add(i);
			}
		}
		
		for(int i = (--n); i>1; i-- ){
			for(int y = 2; y<i; y++){
				if(i % y == 0){
					middleResults.add(y);
				}
			}
			middleResults.retainAll(givenNumDividers);
			if(middleResults.size() == 0){
					result.add(i);
			}
			middleResults.clear();
		}
		
		return result;
	}
	
/** <b>������(322):</b> <br/> ����� ����������� ����� �� 1 �� 10 000 � ������������ ������ ���������.
 *  @param n - int �����, �� �������� � ������� ���������� ������������ �����.
 *  @return int[] - ������, ��������� �� ����� � ������������ ������ ���������, � ���� ����� ���������.
 */
	public static int[] getNumberWithMaxDividerSumm(int n){
		if(n<1 || n>10000){
			System.err.println("The given number must be between 1 and 10 000");
			return null;
		}
		
		List<Integer> dividers = new ArrayList<Integer>();
		int resultNumber = 0;
		int oldTempResult = 0, newTempResult = 0;
		
		for(int i = n; i>1; i--){
			for(int y = 1; y<i; y++){
				if(i % y == 0){
					dividers.add(y);
				}
			}
			
			for(int num: dividers){
				newTempResult += num;
			}
			
			if(Math.max(oldTempResult, newTempResult) == newTempResult){
				oldTempResult = newTempResult;
				resultNumber = i;
			}
			newTempResult = 0;
			dividers.clear();
		}
		
		return new int[]{resultNumber, oldTempResult};
	}

/** <b>������(86, �):</b> <br/> ���� ����������� ����� n. ���� ����� ����� ��� ����?
 *  @param n - int. ���������� ����������� �����.
 *  @return int - ����� ���� ��������� �����.
 */
	public static int getSummOfNumbersDigits(int n){
		int result = 0;
		while(n > 0){
			result += n%10;
			n = n /10;
		}
		return result;
	}
	
	public static void main(String[] args){
		//List<Integer> res = getRelativePrimeNumbers(25);
		//System.out.println("Answer: "+res);
		
		//int[] res = getNumberWithMaxDividerSumm(10000);
		//System.out.println(Arrays.toString(res));
		
		//System.out.println(getSummOfNumbersDigits(5165));
	
 	}
}

