public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {}

    public void inicializar() { raiz = new Node(); }

    public void inserir(String codigoString, String info) {
        int endereco = 0;
        int tamanhoCodigo = codigoString.length();
        char codigoAtual;
        String codigoSoma = "";
        Node atual = raiz;

        while (endereco < tamanhoCodigo) {
            codigoAtual = codigoString.charAt(endereco);
            codigoSoma +=  codigoAtual;

             if (codigoAtual == '.') {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new Node(codigoSoma, null));
                }
                atual = atual.getEsquerda();
            }
            else if (codigoAtual == '-') {
                if (atual.getDireita() == null) {
                    atual.setDireita(new Node(codigoSoma, null));
                }
                atual = atual.getDireita();
            }
            else {
                System.out.println("Codigo: " + codigoAtual + " invalido.");
                return;
            }

            if (atual == null) {
                atual = new Node(codigoSoma, null);
            }

            endereco++;
        }

        atual.setInfo(info);

    }

    public void buscar(String codigoString) {
        int endereco = 0;
        char codigoAtual;
        int tamanhoCodigo = codigoString.length();
        Node atual = raiz;

        while (endereco < tamanhoCodigo) {
            codigoAtual = codigoString.charAt(endereco);

            if (codigoAtual == '.') {
                atual = atual.getEsquerda();
            }
            else if (codigoAtual == '-') {
                atual = atual.getDireita();
            }
            else {
                System.out.println("Codigo invalido: " + codigoAtual);
                return;
            }

            if (atual == null || atual.getInfo() == null) {
                System.out.println("Caractere nao encontrado para codigo: " + codigoString + "\n");
                return;
            }

            endereco++;
        }

        System.out.println("Codigo: " + codigoString);
        System.out.println("    Info: " + atual.getInfo() + "\n");
    }

    public void remover(String codigoString) {
        int endereco = 0;
        char codigoAtual;
        int tamanhoCodigo = codigoString.length();
        Node atual = raiz;
        Node pai = null;
        boolean ehPonto = false;

        while (endereco < tamanhoCodigo) {
            codigoAtual = codigoString.charAt(endereco);

            if (codigoAtual == '.') {
                pai = atual;
                atual = atual.getEsquerda();
                ehPonto = true;
            }
            else if (codigoAtual == '-') {
                pai = atual;
                atual = atual.getDireita();
                ehPonto = false;
            }
            else {
                System.out.println("Codigo invalido: " + codigoAtual);
                return;
            }

            if (atual == null) {
                System.out.println("Caractere nao encontrado para codigo: " + codigoString);
                return;
            }

            endereco++;
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) { // No folha
            if (pai == null)
                raiz = null;

            else if (ehPonto)
                pai.setEsquerda(null);

            else
                pai.setDireita(null);

        }
        else if (atual.getDireita() == null) { // No com filho esquerdo

            if (pai == null)
                raiz = atual.getEsquerda();

            else if (ehPonto)
                pai.setEsquerda(atual.getEsquerda());

            else
                pai.setDireita(atual.getEsquerda());

        }
        else if (atual.getEsquerda() == null) { // No com filho direito
            if (pai == null)
                raiz = atual.getDireita();

            else if (ehPonto)
                pai.setEsquerda(atual.getDireita());

            else
                pai.setDireita(atual.getDireita());

        }
        else { // No com dois filhos

            Node paiMaiorEsquerda = atual;
            Node maiorEsquerda = atual.getEsquerda();

            while (maiorEsquerda.getDireita() != null) {
                paiMaiorEsquerda = maiorEsquerda;
                maiorEsquerda = maiorEsquerda.getDireita();
            }

            atual.setCodigo(maiorEsquerda.getCodigo());
            atual.setInfo(maiorEsquerda.getInfo());

            if (paiMaiorEsquerda == atual) {
                paiMaiorEsquerda.setEsquerda(maiorEsquerda.getEsquerda());
            } else {
                paiMaiorEsquerda.setDireita(maiorEsquerda.getEsquerda());
            }
        }
    }

}

