package xadrez;
import java.util.Random;
import java.util.Arrays;
public class chess {
    public static class tabuleiro{
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
    
    public static class sortings{
    	private int vec[] = new int[9];
    	public void sort_first_coord(tabuleiro aux){
    		Random gen = new Random();
    		Random gen1 = new Random();
    		/*rand de 1 a 8 para x*/
    		int x = gen.nextInt(8) + 1;
    		/*rand de 1 a 8 para y*/
    		int y = gen1.nextInt(8) + 1;
    		aux.move(x,y);
    	}
    	public boolean sort_next_coord(tabuleiro aux,int piece[]){
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
    
    public static void main(String[] args) {
    	long start_time = System.currentTimeMillis();
    	tabuleiro tabuleiro1 = new tabuleiro();
    	sortings sort = new sortings();
    	boolean play = true;
    	tabuleiro1.start_play();
    	sort.sort_first_coord(tabuleiro1);
    	do{
    	    play = sort.sort_next_coord(tabuleiro1,tabuleiro1.horse);
    	}while(play);
    	long elapsed_time_ms = System.currentTimeMillis()-start_time;
    	float elapsed_time = elapsed_time_ms/1000F;
    	tabuleiro1.imprime(elapsed_time);
    }
}

