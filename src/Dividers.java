
public class Dividers {
	
	public static void getDividers(Integer n){
		int i = 1;
		while (i<=n/2){// ����� �� 2 ������� ��������� ������ ��� ������ ����� � ���� ��������
			if (n%i==0){
				System.out.println(i);
			}
			i++;
		}
		System.out.println(n);
	}

}
