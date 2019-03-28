package main;

/**
 * @author Bianca Amorim
 *
 *
 */
public class Grafo {
	
	public class No{
        int conteudo;
        public No(int conteudo) {
            this.conteudo = conteudo;
        }  
    }
      
    public class Aresta implements Comparable<Aresta>{
        No no1;
        No no2;
        int peso;

        public Aresta(No no1, No no2, int peso) {
            this.no1 = no1;
            this.no2 = no2;
            this.peso = peso;
        }
        
        @Override
        public int compareTo(Aresta t) {
            if (this.peso > t.peso){
                return 1;
            } else {
                return -1;
            }  
        }        
    }
}
