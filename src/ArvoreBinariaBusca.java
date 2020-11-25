import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaBusca {

    private NoArvore raiz;
    private boolean primeiraVez = false;

    public ArvoreBinariaBusca() {
        raiz = null;
    }

    public void inserir(String v, ListaSE listaSE) {
        NoArvore novo = new NoArvore(); // cria um novo Nó
        novo.listaSE = listaSE;
        novo.dado = v; // atribui o valor recebido ao item de dados do Nó
        novo.dir = null;
        novo.esq = null;

        if (raiz == null) raiz = novo;
        else { // se nao for a raiz
            NoArvore atual = raiz;
            NoArvore anterior;
            while (true) {
                anterior = atual;
                if (v.compareToIgnoreCase(atual.dado) != 0 && primeiraVez) { // ir para esquerda
                    primeiraVez = true;
                    atual = atual.esq;
                    if (atual == null) {
                        anterior.esq = novo;
                        return;
                    }
                }  // fim da condição ir a esquerda
                else { // ir para direita
                    atual = atual.dir;
                    if (atual == null) {
                        anterior.dir = novo;
                        return;
                    }
                } // fim da condição ir a direita
            } // fim do laço while
        } // fim do else não raiz

    }

    public NoArvore buscar(String chave) {
        if (raiz == null) return null; // se arvore vazia
        NoArvore atual = raiz;  // começa a procurar desde raiz
        if (atual.dado.equals(chave))
            return atual;
        while (atual.dado.compareToIgnoreCase(chave) != 0) { // enquanto nao encontrou
            if (chave.compareToIgnoreCase(atual.dado) == 0) atual = atual.esq; // caminha para esquerda
            else atual = atual.dir; // caminha para direita
            if (atual == null) return null; // encontrou uma folha -> sai
        } // fim laço while
        return atual; // terminou o laço while e chegou aqui é pq encontrou item
    }

    public void caminhar() {
        System.out.print(" Exibindo em ordem: ");
        inOrder(raiz);
        System.out.print("\n Exibindo em pos-ordem: ");
        posOrder(raiz);
        System.out.print("\n Exibindo em pre-ordem: ");
        preOrder(raiz);
        System.out.print("\n Altura da arvore: " + altura(raiz));
        System.out.print("\n Quantidade de folhas: " + folhas(raiz));
        System.out.println("\n Quantidade de Nós: " + contarNos(raiz));
    }

    public void inOrder(NoArvore atual) {
        if (atual != null) {
            inOrder(atual.esq);
            System.out.print(atual.dado + " ");
            inOrder(atual.dir);
        }
    }

    public void preOrder(NoArvore atual) {
        if (atual != null) {
            System.out.print(atual.dado + " ");
            preOrder(atual.esq);
            preOrder(atual.dir);
        }
    }

    public void posOrder(NoArvore atual) {
        if (atual != null) {
            posOrder(atual.esq);
            posOrder(atual.dir);
            System.out.print(atual.dado + " ");
        }
    }

    public int altura(NoArvore atual) {
        if (atual == null || (atual.esq == null && atual.dir == null))
            return 0;
        else {
            if (altura(atual.esq) > altura(atual.dir))
                return (1 + altura(atual.esq));
            else
                return (1 + altura(atual.dir));
        }
    }

    public int folhas(NoArvore atual) {
        if (atual == null) return 0;
        if (atual.esq == null && atual.dir == null) return 1;
        return folhas(atual.esq) + folhas(atual.dir);
    }

    public int contarNos(NoArvore atual) {
        if (atual == null) return 0;
        else return (1 + contarNos(atual.esq) + contarNos(atual.dir));
    }

    public NoArvore min() {
        NoArvore atual = raiz;
        NoArvore anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.esq;
        }
        return anterior;
    }

    public NoArvore max() {
        NoArvore atual = raiz;
        NoArvore anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.dir;
        }
        return anterior;
    }

    public List<NoArvore> buscaTermos(String[] termos) {

        List<NoArvore> noArvores = new ArrayList<>();

        for (int i = 0; i < termos.length; i++) {
            NoArvore noArvore = buscar(termos[i]);
            noArvores.add(noArvore); // terminou o laço while e chegou aqui é pq encontrou item
        }

        return noArvores;
    }
}
