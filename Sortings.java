package xadrez;

import java.util.Random;

public class Sortings {
	private int vec[] = new int[9];
	public void sort_first_coord(Table aux){
		Random gen = new Random();
		Random gen1 = new Random();
		/*rand de 1 a 8 para x*/
		int x = gen.nextInt(8) + 1;
		/*rand de 1 a 8 para y*/
		int y = gen1.nextInt(8) + 1;
		aux.move(x,y);
	}
	public boolean sort_next_coord(Table aux,int piece[]){
		for(int i = 0; i<=8;i++)
			vec[i] = i;
		//rand de 1 a 8
		int n = 8;
		int p = sort_in_vec(n);
		n--;
		for(int i = 7; i>=1; i--){
			if(aux.evaluation(p,piece) == 2)
				return true;
			p = sort_in_vec(n);
			n--;
		}
        return false;
	}
	public int sort_in_vec(int n){
		//rand de 1 a n
		Random gen = new Random();
		int  rand = gen.nextInt(n) + 1;
		vec[rand]=0;
		for(int a = 1, i = 1; a <= 8; i++, a++)
			if(vec[i]==0 && i <=7){
				for(int j = i; j<=7 && vec[j]==0;j++)
					a = j;
				vec[i]=vec[a+1];
				vec[a+1]=0;
			}
		return rand;
	}
}
