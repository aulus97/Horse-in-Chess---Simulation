package xadrez;

import java.util.Arrays;

public class Table{
	private int T[][];
	public int jog,num_casas;
	public int horse[];
	public void imprime(float elapsedT){
		Arrays.stream(T).forEach((row) -> {
            //System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" | " + el + "  "));
            System.out.println("|");
		});
	    System.out.println("Numero de casas percorridas:"+num_casas + "\nTempo total de simulacao: "+elapsedT+" segundos");
	}

	public void start_play(){
		//super();
		T = new int[9][9];
		horse = new int[3];
	}
	public void move(int x, int y){
		//super();
		T[x][y] = num_casas + 1;
		horse[1] = x;
		horse[2] = y;
		update();
	}
	private void update(){
		num_casas += 1;
	}
	public boolean check_pos(int x,int y){
		if(x<=8 && y<=8 && x >= 1 && y >= 1)
    		if(T[x][y]==0)
    			return true;
		return false;
	}
	public int evaluation(int p, int piece[]){
		switch (p){
			case 1:
				if(check_pos(piece[1]+2,piece[2]+1))
					move(piece[1]+2,piece[2]+1);
				else
					return 1;
				break;
			case 2:
				if(check_pos(piece[1]+2,piece[2]-1))
					move(piece[1]+2,piece[2]-1);
				else
					return 1;
				break;
			case 3:
				if(check_pos(piece[1]-2,piece[2]+1))
					move(piece[1]-2,piece[2]+1);
				else
					return 1;
				break;
			case 4:
				if(check_pos(piece[1]-2,piece[2]-1))
					move(piece[1]-2,piece[2]-1);
				else
					return 1;
				break;
			case 5:
				if(check_pos(piece[1]+1,piece[2]+2))
					move(piece[1]+1,piece[2]+2);
				else
					return 1;
				break;
			case 6:
				if(check_pos(piece[1]-1,piece[2]+2))
					move(piece[1]-1,piece[2]+2);
				else
					return 1;
				break;
			case 7:
				if(check_pos(piece[1]+1,piece[2]-2))
					move(piece[1]+1,piece[2]-2);
				else
					return 1;
				break;
			case 8:
				if(check_pos(piece[1]-1,piece[2]-2))
					move(piece[1]-1,piece[2]-2);
				else
					return 1;
				break;
			default: System.out.println("Erro no Switch");
		}
		return 2;
	}
}


