public class tabuleiro{
	private int T[][];
	public int jog,num_casas;//pegar tempo (Tomas)
	public int horse[];
	void imprime(){
		//print upstream
		//System.out.println("Primeiro Trimestre");
	}
	public start_table(){
		this();
		T = new int[8][8];
		horse = new int[2];
	}
	public move(int x, int y){
		this();
		T[x][y] = play;
		horse[0] = x;
		horse[1] = y;
		update();
	}
	private update(){
		this();
		num_casas += 1;//testar: num_casas = ++jog
		jog += 1;
	}
	public boolean check_pos(int x,int y){
		if(T[x][y]==0)
			return True;
	}
	public evaluation(int p, int piece[]){
		switch (p){
			case 1:
				if(check_pos(piece[1]+2,piece[2]+1))
					move(piece[1]+2,piece[2]+1)
				else
					return 1;
				break;
			case 2:
				if(check_pos(piece[1]+2,piece[2]-1))
					move(piece[1]+2,piece[2]-1)
				else
					return 1;
				break;
			case 3:
				if(check_pos(piece[1]-2,piece[2]+1))
					move(piece[1]-2,piece[2]+1)
				else
					return 1;
				break;
			case 4:
				if(check_pos(piece[1]-2,piece[2]-1))
					move(piece[1]-2,piece[2]-1)
				else
					return 1;
				break;
			case 5:
				if(check_pos(piece[1]+1,piece[2]+2))
					move(piece[1]+1,piece[2]+2)
				else
					return 1;
				break;
			case 6:
				if(check_pos(piece[1]-1,piece[2]+2))
					move(piece[1]-1,piece[2]+2)
				else
					return 1;
				break;
			case 7:
				if(check_pos(piece[1]+1,piece[2]-2))
					move(piece[1]+1,piece[2]-2)
				else
					return 1;
				break;
			case 8:
				if(check_pos(piece[1]-1,piece[2]-2))
					move(piece[1]-1,piece[2]-2)
				else
					return 1;
				break;
			default: System.out.println("Erro no Switch");
		}
		System.out.println("Opa saiu do switch mas ainda tá na funcao");
		return 0;
	}
}

public class sorteios{
	public sort_first_coord(){
		/*rand de 1 a 8 para x*/
		/*rand de 1 a 8 para y*/
		//tabuleiro.jog++;
		move(x,y,jog);
	}
	public sort_next_coord(int piece[]){
		int vec[] = new int[9];
		//inicializo o vetor de rand
		for(int i = 0; i<=8;i++)
			vec[i] = i;
		//rand de 1 a 8
		int n = 8;
		sort_in_vec(vec,n);
		n--;
		for(int i = 8; i<=0; i--){
			if(evaluation(p,piece) == 0)
				return False;
			sort_in_vec(vec,n);
			n--;
		}

	}
	public sort_in_vec(int vec[],int n){
		//rand de 1 a n
		vec[rand]=0;
		for(int a = 1,int i = 1;a<=8;i++,a++)
			if(vec[i]==0)//pensar nisso aqui!!!
				vec[i]=vec[a+1];
	}
	faço o sort entre 8
		boto 0 no num escolhido
		passo os valores !0 pra outro vet
	repeat!!
}

aprender o print
aprender passar vec por referencia
aprendder a dar "include"
