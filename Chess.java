package xadrez_tp;

public class Chess {
	public static void main(String[] args) {
		//long start_time = System.currentTimeMillis();
    	Table tabuleiro1 = new Table();
    	Sortings sort = new Sortings();
    	//boolean play = true;
    	tabuleiro1.start_play();
    	sort.sort_first_coord(tabuleiro1);
    	sort.next_pos(tabuleiro1,tabuleiro1.horse);
    	/*do{
    	    play = sort.sort_next_coord(tabuleiro1,tabuleiro1.horse);
    	}while(play);*/
    	//long elapsed_time_ms = System.currentTimeMillis()-start_time;
    	//float elapsed_time = elapsed_time_ms/1000F;
    	tabuleiro1.imprime(/*elapsed_time*/);
	}

}
