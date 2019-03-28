package main;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bianca Amorim
 *
 *
 */
public class Matrizes {
	
	public static List<Vertice> construirRepAdjacencias(int[][] representacaoMatriz) {

        List<Vertice> vertices = new ArrayList<>();
        for (int i = 0; i < representacaoMatriz.length; i++) { // linha
            vertices.add(new Vertice());
        }

        for (int i = 0; i < vertices.size(); i++) { // linha
            for (int j = 0; j < representacaoMatriz[i].length; j++) { // coluna
                if (representacaoMatriz[i][j] != 0 && representacaoMatriz[i][j] != Integer.MAX_VALUE) {
                    vertices.get(i).add(vertices.get(j));
                }
            }
        }

        return vertices;

    }

    public static int[][] construirRepMatriz(String entrada) {
        String arquivo = main.LeituraArquivo.lerArquivo(entrada);

        String[] linhas = arquivo.split("\n");

        int n = Integer.parseInt(linhas[0]);
        int matriz[][] = new int[n][n];

        for (int i = 1; i < linhas.length; i++) {
            String[] pesos_ij = linhas[i].split(" ");
            for (int j = pesos_ij.length - 1; j >= 0; j--) {
                int peso;
                try {
                    peso = Integer.parseInt(pesos_ij[j]);
                } catch (NumberFormatException e) {
                    peso = Integer.MAX_VALUE;
                }
                matriz[i - 1][j + i] = peso;
            }
        }

        return matriz;
    }
    
    public static ArrayList<Vertice> buildMinHeap(Vertice[] vet) {

        for (int i = (vet.length / 2) - 1; i >= 0; i--) {
            minHeapfy(vet, vet.length, i);
        }

        ArrayList<Vertice> ret = new ArrayList<Vertice>();

        for (int i = 0; i < vet.length; i++) {
            ret.add(vet[i]);
        }

        return ret;
    }

    public static Vertice[] minHeapfy(Vertice[] vet, int tam, int index) {
        int menor = index, left = 2 * index, right = 2 * index + 1;

        if ((left <= tam - 1) && (vet[left].valor < vet[menor].valor)) {
            menor = left;
        }

        if ((right <= tam - 1) && (vet[right].valor < vet[menor].valor)) {
            menor = right;
        }

        if (menor != index) {
            Vertice aux = vet[index];
            vet[index] = vet[menor];
            vet[menor] = aux;

            return minHeapfy(vet, tam, menor);
        }

        return vet;
    }
}
