public class Node {
    private Node esquerda;
    private Node direita;
    private String codigo;
    private String info;

    public Node(String codigo, String info) {
        this.esquerda = null;
        this.direita = null;
        this.codigo = codigo;
        this.info = info;
    }

    public Node() {}

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
