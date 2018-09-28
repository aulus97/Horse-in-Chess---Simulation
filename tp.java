public class tabuleiro{
	private int T[][];
	public int jog,num_casas;//pegar tempo (Tomas)
	public int piece[2];
	void imprime(){
		//print upstream
		//System.out.println("Primeiro Trimestre");
	}
	public move(int x, int y,int play){
		this();
		T[x][y] = play;
		piece[0] = x;
		piece[1] = y;
		update(play);
	}
	private update(int play){
		this();
		num_casas += 1;
		jog = play;
	}
	public boolean check_pos(int x,int y){
		if(T[x][y]==0)
			return True;
	}
	public evaluation(int p, int piece[]){
		switch (p){
			case 1:
				if(check_pos(piece[1]+2,piece[2]+1))
					move(piece[1]+2,piece[2]+1,)
		}
	}
}

public class sorteios{
	public sort_first_coord(){
		/*rand de 1 a 8 para x*/
		/*rand de 1 a 8 para y*/
		tabuleiro.jog++;
		move(x,y,jog);
	}
	public sort_next_coord(int piece[],play){
		/*rand de 1 a 8 para o switch*/
		evaluation(p,piece);
	}
}
