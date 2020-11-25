import com.sun.org.apache.bcel.internal.ExceptionConst;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("*-- INICIO - ETAPA 1 --*");
        ListaSE l = new ListaSE();

        l.insereOrdenado("Celine 10.txt", 3);
        l.insereOrdenado("Celine 5.txt", 5);
        l.insereOrdenado("Celine 4.txt", 4);
        l.insereOrdenado("Celine 7.txt", 7);

        l.imprime();
        l.imprimeQuantidadeFrequenciaPorTermo("Celine 5.txt");
        System.out.println("*-- FIM - ETAPA 1 --*");

        System.out.println("\n*-- INICIO - ETAPA 2 --*");
        ListaSE l2 = new ListaSE();
        l2.insereOrdenado("Celine 7.txt", 7);
        l2.insereOrdenado("Celine 9.txt", 8);
        l2.insereOrdenado("Celine 18.txt", 78);
        l2.insereOrdenado("Celine 4.txt", 7);

        ArvoreBinariaBusca arvoreBinariaBusca = new ArvoreBinariaBusca();
        arvoreBinariaBusca.inserir("bola", l);
        arvoreBinariaBusca.inserir("casa", l2);
        arvoreBinariaBusca.caminhar();


        System.out.println("*-- FIM - ETAPA 2 --*");

        System.out.println("\n*-- INICIO - ETAPA 3 --*");

        try {
            NoArvore noArvore = arvoreBinariaBusca.buscar("casa");
            System.out.println(" Termo Procurado: " + "casa");
            System.out.println(" Termo Encontrado: " + noArvore.dado);
        } catch (Exception e) {
            System.out.println("Não foi possível realizar a busca na arvore binária");
        }


        System.out.println("*-- FIM - ETAPA 3 --*");

        System.out.println("\n*-- INICIO - ETAPA 4 --*");

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Entre com os termos a ser pesquisados (separados por espaço):");
            String[] termos = sc.nextLine().split(" ");
            List<NoArvore> noArvores = arvoreBinariaBusca.buscaTermos(termos);
            if (noArvores != null) {
                for (int i = 0; i < noArvores.size(); i++) {
                    System.out.println("Termo Procurado: " + termos[i]);
                    System.out.println("Resultado: ");
                    noArvores.get(i).listaSE.imprimeComFrequencia();
                    System.out.println("Termo Encontrado: " + noArvores.get(i).dado);
                }
            } else {
                System.out.println(" Termo Procurado: " + null);
                System.out.println(" Termo Encontrado: " + null);
            }
        } catch (Exception e) {
            System.out.println("Não foi possível realizar a busca na arvore binária");
        }
        System.out.println("\n*-- FIM - ETAPA 4 --*");
    }
}
