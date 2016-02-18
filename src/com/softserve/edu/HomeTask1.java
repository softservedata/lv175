package SoftS;

import java.util.ArrayList;
import java.util.List;

public class HomeTasks {
/** <b>Задача(323):</b> <br/>Дано натуральное число n. Получить все натуральные числа, меньшие n и взаимно простые с ним.
 *  @return Контейнер List<Integer> с результатом вычислений
 *  @param n - int. Натуральное число, на основе которого выполняются вычисления 
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
	
/** <b>Задача(322):</b> <br/> Найти натуральное число от 1 до 10 000 с максимальной суммой делителей.
 *  @param n - int число, от которого в сторону уменьшения производится поиск.
 *  @return int[] - Массив, состоящий из числа с максимальной суммой делителей, и сама сумма делителей.
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

/** <b>Задача(86, б):</b> <br/> Дано натуральное число n. Чему равна сумма его цифр?
 *  @param n - int. Задаваемое натуральное число.
 *  @return int - сумма цифр заданного числа.
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

