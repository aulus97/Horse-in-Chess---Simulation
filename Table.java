package xadrez_tp;

import java.util.Arrays;

public class Table{
	private static int T[][];
	private static int M[][];
	public int jog;
	public static int num_casas;
	public static int MaxNum;
	public static int horse[];
	public static int horse_mem[];
	public void imprime(float elapsedT){
		Arrays.stream(M).forEach((row) -> {
            //System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" | " + el + "  "));
            System.out.println("|");
		});
	    System.out.println("Numero de casas percorridas: "+ MaxNum + "\nTempo total de simulacao: "+ elapsedT +" segundos");
	}

	public void start_play(){
		//super();
		T = new int[9][9];
		M = new int[9][9];
		horse = new int[3];
		horse_mem = new int[3];
	}
	public static void move(int x, int y){
		//super();
		T[x][y] = num_casas + 1;
		for(int i = 1; i<=2; i++)
			horse_mem[i] = horse[i];
		horse[1] = x;
		horse[2] = y;
		update();
	}
	public static void move_back(/*int x, int y*/){
		T[horse[1]][horse[2]] = 0;
		for(int i = 1; i<=2; i++)
			horse[i] = horse_mem[i];
		restore();
	}
	private static void update(){
		num_casas += 1;
	}
	private static void restore(){
		num_casas -= 1;
	}
	public static boolean check_pos(int x,int y){
		if(x<=8 && y<=8 && x >= 1 && y >= 1)
    		if(T[x][y]==0)
    			return true;
		return false;
	}
	public static boolean evaluation(int p, int[] piece){
		switch (p){
			case 1:
				if(check_pos(piece[1]+2,piece[2]+1)){
					move(piece[1]+2,piece[2]+1);
					//piece[1] += 2;
					//piece[2] += 1;
					Sortings.next_pos(horse);
				}
				else
					return false;
				break;
			case 2:
				if(check_pos(piece[1]+2,piece[2]-1)){
					move(piece[1]+2,piece[2]-1);
					//piece[1] += 2;
					//piece[2] -= 1;
					Sortings.next_pos(horse);
				}
				else
					return false;
				break;
			case 3:
				if(check_pos(piece[1]-2,piece[2]+1)){
					move(piece[1]-2,piece[2]+1);
					//piece[1] -= 2;
					//piece[2] += 1;
					Sortings.next_pos(horse);
				}
				else
					return false;
				break;
			case 4:
				if(check_pos(piece[1]-2,piece[2]-1)){
					move(piece[1]-2,piece[2]-1);
					//piece[1] -= 2;
					//piece[2] -= 1;
					Sortings.next_pos(horse);
				}
				else
					return false;
				break;
			case 5:
				if(check_pos(piece[1]+1,piece[2]+2)){
					move(piece[1]+1,piece[2]+2);
					//piece[1] += 1;
					//piece[2] += 2;
					Sortings.next_pos(horse);
				}
				else
					return false;
				break;
			case 6:
				if(check_pos(piece[1]-1,piece[2]+2)){
					move(piece[1]-1,piece[2]+2);
					//piece[1] -= 1;
					//piece[2] += 2;
					Sortings.next_pos(horse);
				}
				else
					return false;
				break;
			case 7:
				if(check_pos(piece[1]+1,piece[2]-2)){
					move(piece[1]+1,piece[2]-2);
					//piece[1] += 1;
					//piece[2] -= 2;
					Sortings.next_pos(horse);
				}
				else
					return false;
				break;
			case 8:
				if(check_pos(piece[1]-1,piece[2]-2)){
					move(piece[1]-1,piece[2]-2);
					//piece[1] -= 1;
					//piece[2] -= 2;
					Sortings.next_pos(horse);
				}
				else
					return false;
				break;
			default: System.out.println("Erro no Switch");
		}
		return true;
		//faça o retorno do piece para ser usado no move_bck da funcao next_pos
	}
	public static void end_game(){
		if(num_casas > MaxNum){
			for(int i = 1;i<=8;i++)
				for(int j = 1; j<=8;j++)
					M[i][j] = T[i][j];
			MaxNum = num_casas;
		}
	}

}


