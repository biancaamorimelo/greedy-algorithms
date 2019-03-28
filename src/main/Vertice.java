package main;
import java.util.ArrayList;

/**
 * @author Bianca Amorim
 *
 *
 */
public class Vertice {
	
	static int last_id = 0;

    public int id;
    public int valor;
    public Vertice pai;
    public ArrayList<Vertice> adj;

    public Vertice(int id, int valor, Vertice pai) {
        this.id = id;
        this.valor = valor;
        this.pai = pai;
        this.adj = new ArrayList<>();
    }

    public Vertice(int valor) {
        this(++last_id, valor, null);
    }

    public Vertice() {
        this(last_id++, Integer.MAX_VALUE, null);
    }
    
    public void add (Vertice v){
        this.adj.add(v);
    }

    public int getId() {
        return id;
    }
}
