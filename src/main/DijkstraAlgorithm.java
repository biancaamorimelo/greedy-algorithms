package main;
import static main.Matrizes.buildMinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bianca Amorim
 *
 *
 */
public class DijkstraAlgorithm {
	
	List<Vertice> vertices;
	
	// Construtor com parametros sendo o grafo representado em forma de lista de adjacência e em matriz
    public DijkstraAlgorithm(List<Vertice> adjacencia, int[][] representacaoMatriz) {
        this.vertices = adjacencia;
        this.iniciaVertices();
        this.melhoresCaminhos(this.vertices.toArray(new Vertice[0]), representacaoMatriz, 0, (this.vertices.size() - 1));
    }

    // Inicializa todos os vértices com valor infinito
    public void iniciaVertices() {
        for (Vertice v : this.vertices) {
            v.valor = Integer.MAX_VALUE;
        }
    }
    
    private void melhoresCaminhos(Vertice[] vertices, int[][] representacaoMatriz, int inicio, int fim) {
        //Atribui zero ao primeiro vértice
    	vertices[inicio].valor = 0;
    	
        //Constroi a primeira arvore heap
        ArrayList<Vertice> minHeap = buildMinHeap(vertices.clone());

        Vertice verticeAuxiliar = null;

        Vertice[] res = new Vertice[vertices.length];

        while (minHeap.size() != 0) { 
            verticeAuxiliar = minHeap.remove(0); // Armazenar o menor elemento

            // Percorre os demais 
            for (Vertice v : verticeAuxiliar.adj) {
                // Relaxamento 
                if (minHeap.contains(v)
                        && v.valor > verticeAuxiliar.valor + representacaoMatriz[verticeAuxiliar.getId()][v.getId()]) {
                    v.valor = (verticeAuxiliar.valor + representacaoMatriz[verticeAuxiliar.getId()][v.getId()]);
                    v.pai = verticeAuxiliar;
                }
            }

            minHeap = buildMinHeap(minHeap.toArray(new Vertice[minHeap.size()]));
            res[representacaoMatriz.length - (minHeap.size() + 1)] = verticeAuxiliar;
        }

        System.out.println("Menor caminho do " + inicio + " para " + fim + ": ");
        String resposta = "";
        int caminhoTotal = 0;

        for (Vertice v : res) {
            if (v.getId() == fim) {
                verticeAuxiliar = v;
                break;
            }
        }
        resposta = verticeAuxiliar.getId() + "";
        while (verticeAuxiliar.pai != null) {
            resposta = verticeAuxiliar.pai.getId() + " - " + resposta;  
            caminhoTotal+=representacaoMatriz[verticeAuxiliar.pai.id][verticeAuxiliar.id];  // Realiza a soma dos caminhos percorridos
            verticeAuxiliar = verticeAuxiliar.pai;
        }
        
        System.out.println(resposta + "\n Soma dos caminhos = " + caminhoTotal);        
    }
}
