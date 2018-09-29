public class tabuleiro{
	private int T[][];
	public int jog,num_casas;//pegar tempo (Tomas)
	public int horse[];
	public void imprime(){
		//print upstream
		//System.out.println("Primeiro Trimestre");
		System.out.println("Numero de casas percorridas:"+num_casas + "\nTempo total de simulacao:");//pegar o tempo!!
	}
	public void start_table(){
		this();
		T = new int[8][8];
		horse = new int[2];
	}
	public void move(int x, int y){
		this();
		T[x][y] = play;
		horse[0] = x;
		horse[1] = y;
		update();
	}
	private void update(){
		this();
		num_casas += 1;//testar: num_casas = ++jog //tente fazer com print ;)
		jog += 1;
	}
	public boolean check_pos(int x,int y){
		if(T[x][y]==0)
			return True;
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
		System.out.println("Opa saiu do switch mas ainda ta na funcao");
		return 2;//se der errado, troque ops breaks por return 0 ou 2??
	}
}

public class sortings{
	private int vec[] = new int[9];
	public void sort_first_coord(){
		/*rand de 1 a 8 para x*/
		/*rand de 1 a 8 para y*/
		//tabuleiro.jog++;
		move(x,y,jog);
	}
	public boolean sort_next_coord(int piece[]){
		//int vec[] = new int[9];
		this();
		//inicializo o vetor de rand
		for(int i = 0; i<=8;i++)
			vec[i] = i;
		//rand de 1 a 8
		int n = 8;
		int p = sort_in_vec(n);
		n--;
		for(int i = 7; i>=1; i--){
			if(evaluation(p,piece) == 2)
				return True;
			sort_in_vec(n);
			n--;
			//print n para verificar se chega em 0!
		}
        return False;
	}
	public int sort_in_vec(int n){
		this();
		//rand de 1 a n
		vec[rand]=0;
		for(int a = 1,int i = 1;a<=8;i++,a++)
			if(vec[i]==0){//pensar nisso aqui!!!
				for(int j = i; j<=7&&vec[j]==0;j++)
					a = j;
				vec[i]=vec[a+1];
				vec[a+1]=0;
			}
		return rand;
	}
	/*faço o sort entre 8
		boto 0 no num escolhido
		passo os valores !0 pra outro vet
	repeat!!*/
}
/*
aprender o print
aprender passar vec por referencia
aprendder a dar "include"*/

public static void main(String[] args) {
	tabuleiro tabuleiro1;
	boolean play = True;
	tabuleiro1.start_table();
	sort_first_coord();
	do{
	    play = sort_next_coord(tabuleiro.horse);
	}while(play);
	imprime();
}
/*
public class MyClass {
    public static void main(String args[]) {
        int x=10;
        int y=25;
        int z=x+y;

        System.out.println("Sum of x+y = " + z);
    }
}*/