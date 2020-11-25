public class Node {

    private String info;
    private int frequencia;
    private Node proximo;

    public Node(String info, int frequencia) {
        this.info = info;
        this.frequencia = frequencia;
        this.proximo = null;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}