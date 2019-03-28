package main;
import static main.Matrizes.construirRepMatriz;
import static main.Matrizes.construirRepAdjacencias;

import java.util.List;

/**
 * @author Bianca Amorim
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        // Entrada
        //String entrada = "instancias/dij10.txt";
        String entrada = "instancias/dij20.txt";
        //String entrada = "instancias/dij40.txt";
        //String entrada = "instancias/dij50.txt";

        // Le a entrada e retorna a representacao do grafo em matriz
        int[][] matriz = construirRepMatriz(entrada);

        // Representa em lista de adjacencia
        List<Vertice> adjacencia = construirRepAdjacencias(matriz);
        
        // PrimAlgorithm
        System.out.println("---- Prim ---- \n");
        PrimAlgorithm prim = new PrimAlgorithm(adjacencia, matriz);
       
        // DijkstraAlgorithm
        System.out.println("\n---- Dijkstra ---- \n");
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(adjacencia, matriz);     
    }
}
