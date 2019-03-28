package main;
import static main.Matrizes.buildMinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bianca Amorim
 *
 *
 */
public class PrimAlgorithm {
	
	List<Vertice> vertices;

    public PrimAlgorithm(List<Vertice> adjacencia, int[][] representacaoMatriz) {
        this.vertices = adjacencia;
        
        this.inicializaVertices();
        
        this.spanningTree(this.vertices.toArray(new Vertice[0]), representacaoMatriz, 0);
    }

    private void inicializaVertices() {
        for (Vertice v : this.vertices) {
            v.valor = Integer.MAX_VALUE;
        }
    }

    private void spanningTree(Vertice[] listaVertices, int[][] formatoMatriz, int inicial) {
        int numeroVertices = this.vertices.size();
        
        Vertice[] resultado = new Vertice[numeroVertices];
              
        Vertice v = null;
        
        int minHeapTamanho = 0;
      
        listaVertices[inicial].valor = 0;
      
        ArrayList<Vertice> minHeap = buildMinHeap(listaVertices.clone());		
     
        while ((minHeapTamanho = minHeap.size()) != 0) {
            v = minHeap.remove(0);		

            for (int i = 0; i < v.adj.size(); i++) {
                if ((formatoMatriz[v.id][v.adj.get(i).id] < (v.adj.get(i).valor))) {
                    v.adj.get(i).pai = v; //Atribui o vertice retirado como o novo pai
                    v.adj.get(i).valor = formatoMatriz[v.id][v.adj.get(i).id]; //Modifica o valor do vertice pelo peso da aresta correspondente
                }
            }

            minHeap = buildMinHeap(minHeap.toArray(new Vertice[minHeap.size()]));
            resultado[numeroVertices - minHeapTamanho] = v; //Guarda os vertices ja acessados
        }

        int total = 0;

        for (int i = 0; i < resultado.length; i++) {
            if (resultado[i].pai != null) {
                System.out.println("ID: " + resultado[i].id + " Pai: " + resultado[i].pai.id + " Valor: " + resultado[i].valor);
            } else {
                System.out.println("ID: " + resultado[i].id + " Pai: " + resultado[i].pai + " Valor: " + resultado[i].valor);
            }

            total += resultado[i].valor;
        }

        System.out.println("\nValor total: " + total);

    }


}
