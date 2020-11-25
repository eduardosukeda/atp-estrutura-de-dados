import java.util.List;

public class ListaSE {

    private int tamanho;
    private Node primeiro = null;
    private Node ultimo = null;

    public int getTamanho() {
        return tamanho;
    }

    public Node getPrimeiro() {
        return primeiro;
    }

    public Node getUltimo() {
        return ultimo;
    }

    public void inserePrimeiro(String o, int frequencia) {
        Node n = new Node(o, frequencia);
        if (primeiro == null) {
            primeiro = n;
            ultimo = n;
        } else {
            n.setProximo(primeiro);
            primeiro = n;
        }
        tamanho++;
    }

    public boolean vazia() {
        return (this.primeiro == null);
    }

    public Node insereDepois(Node n, String o, int frequencia) {
        Node novo = new Node(o, frequencia);
        novo.setProximo(n.getProximo());
        n.setProximo(novo);
        return novo;
    }

    public void insereUltimo(String o, int frequencia) {
        if (primeiro == null) {
            inserePrimeiro(o, frequencia);
        } else {
            ultimo = insereDepois(ultimo, o, frequencia);
        }
        tamanho++;
    }

    public void imprime() {
        Node n = primeiro;
        while (n != null) {
            System.out.println(n.getInfo());
            n = n.getProximo();
        }
    }

    public void imprimeComFrequencia() {
        Node n = primeiro;
        while (n != null) {
            System.out.println("Arquivo:" + n.getInfo() + " || " +  "Frequência: " + n.getFrequencia());
            n = n.getProximo();
        }
    }

    public void imprimeQuantidadeFrequenciaPorTermo(String elemento) {
        Node n = primeiro;
        boolean achou = false;
        int x = 0;

        for (int i = 0; i <= tamanho; i++) {
            if (n.getInfo().equals(elemento)) {
                System.out.println("-- IMPRIME QUANTIDADE DE FREQUÊNCIA POR TERMO --");
                System.out.println("Elemento: " + elemento);
                System.out.println("Frequência: " + n.getFrequencia());
                achou = true;
            }
            n = n.getProximo();
        }

        if (!achou) {
            System.out.println(elemento + "-" + 0);
        }
    }

    public void inverte() {
        Node p = primeiro, q, r = null;

        while (p != null) {
            q = p.getProximo();
            p.setProximo(r);
            r = p;
            p = q;
        }
        if (primeiro != null) {
            p = ultimo;
            ultimo = primeiro;
            primeiro = p;
        }
    }

    public void insereOrdenado(String elemento, int frequencia) {
        if (vazia())
            inserePrimeiro(elemento, frequencia);
        else if (frequencia <= primeiro.getFrequencia())
            inserePrimeiro(elemento, frequencia);
        else if (frequencia >= ultimo.getFrequencia())
            insereUltimo(elemento, frequencia);
        else {
            Node p = primeiro;
            Node q = null;
            while (p.getFrequencia() < frequencia) {
                q = p;
                p = p.getProximo();
            }
            insereDepois(q, elemento, frequencia);
        }
    }
}