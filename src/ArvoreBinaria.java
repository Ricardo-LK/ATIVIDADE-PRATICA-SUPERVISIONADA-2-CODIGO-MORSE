public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {
    }

    public void inicializar() {
        raiz = new Node();
    }

    public String representacaoASCII() {
        if (raiz == null) {
            return "Árvore vazia\n";
        }

        int h = getAltura();
        if (h < 0) return "Árvore vazia\n";

        int y = (2 * h) + 1;  // altura total em linhas
        int x = potencia(2, h + 1) - 1;  // largura total em colunas

        // Criar uma matriz para armazenar os caracteres
        char[][] grid = new char[y][x];

        // Inicializar a matriz com espaços
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                grid[i][j] = ' ';
            }
        }

        // Preencher a matriz recursivamente
        preencherGrid(raiz, grid, 0, x / 2, h);

        // Converter a matriz para string
        String ascii = "";
        for (int linha = 0; linha < y; linha++) {
            for (int coluna = 0; coluna < x; coluna++) {
                ascii += grid[linha][coluna];
            }
            ascii += "\n";
        }

        return ascii;
    }

    private void preencherGrid(Node node, char[][] grid, int nivel, int posicao, int alturaMax) {
        if (node == null) return;

        int linha = 2 * nivel;  // Linha para o nó
        int linhaLigacao = 2 * nivel + 1;  // Linha para as ligações

        // Colocar o caractere do nó (se existir)
        char caractere = (node.getCaractere() != null && !node.getCaractere().isEmpty()) ? node.getCaractere().charAt(0) : '∅';
        grid[linha][posicao] = caractere;

        // Calcular o deslocamento para os filhos baseado na altura
        int deslocamento = potencia(2, alturaMax - nivel - 1);

        // Desenhar ligações para os filhos
        if (node.getEsquerda() != null) {
            int posEsquerda = posicao - deslocamento;
            grid[linhaLigacao][posicao - 1] = '/';

            // Desenhar linha horizontal se necessário
            for (int i = posEsquerda + 1; i < posicao - 1; i++) {
                if (i < grid[0].length) {
                    grid[linhaLigacao][i] = '_';
                }
            }

            preencherGrid(node.getEsquerda(), grid, nivel + 1, posEsquerda, alturaMax);
        }

        if (node.getDireita() != null) {
            int posDireita = posicao + deslocamento;
            grid[linhaLigacao][posicao + 1] = '\\';

            // Desenhar linha horizontal se necessário
            for (int i = posicao + 2; i < posDireita; i++) {
                if (i < grid[0].length) {
                    grid[linhaLigacao][i] = '_';
                }
            }

            preencherGrid(node.getDireita(), grid, nivel + 1, posDireita, alturaMax);
        }
    }

    public int getAltura() {
        return getAlturaRec(raiz);
    }

    private int getAlturaRec(Node node) {
        if (node == null) return -1;

        int alturaDireita = getAlturaRec(node.getDireita());
        int alturaEsquerda = getAlturaRec(node.getEsquerda());

        int max = alturaDireita;
        if (alturaEsquerda > alturaDireita) max = alturaEsquerda;

        return max + 1;
    }

    public void inserir(String codigoString, String info) {
        if (this.raiz == null) {
            System.err.println("Árvore não foi inicializada.");
            return;
        }

        int endereco = 0;
        int tamanhoCodigo = codigoString.length();
        char codigoAtual;
        String codigoSoma = "";
        Node atual = raiz;

        while (endereco < tamanhoCodigo) {
            codigoAtual = codigoString.charAt(endereco);
            codigoSoma += codigoAtual;

            if (codigoAtual == '.') {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new Node(codigoSoma, null));
                }
                atual = atual.getEsquerda();
            } else if (codigoAtual == '-') {
                if (atual.getDireita() == null) {
                    atual.setDireita(new Node(codigoSoma, null));
                }
                atual = atual.getDireita();
            } else {
                System.out.println("Codigo: " + codigoAtual + " invalido.");
                return;
            }

            if (atual == null) {
                atual = new Node(codigoSoma, null);
            }

            endereco++;
        }

        atual.setCaractere(info);

    }

    public String buscar(String codigoString) {
        if (raiz == null) return null;

        int tamanhoString = codigoString.length();
        if (tamanhoString == 0) return null;

        char[] caracteres = codigoString.toCharArray();
        int indice = 0;

        Node atual = raiz;

        while (atual != null && indice < tamanhoString) {
            if (caracteres[indice] == '.') {
                atual = atual.getEsquerda();
                indice++;
            } else if (caracteres[indice] == '-') {
                atual = atual.getDireita();
                indice++;
            } else {
                return null; // Caractere inválido
            }
        }

        if (atual != null) {
            return atual.getCaractere();
        }

        return null;
    }

    public String remover(String codigoString) {
        if (raiz == null) return null;

        int tamanhoString = codigoString.length();
        if (tamanhoString == 0) return null;

        char[] caracteres = codigoString.toCharArray();
        int indice = 0;

        Node atual = raiz;

        while (atual != null && indice < tamanhoString) {
            if (caracteres[indice] == '.') {
                atual = atual.getEsquerda();
                indice++;
            } else if (caracteres[indice] == '-') {
                atual = atual.getDireita();
                indice++;
            } else {
                return null; // Caractere inválido
            }
        }

        // Apenas remove o dado, sem remover o código, para não perder a estrutura da árvore
        if (atual != null) {
            String caractere = atual.getCaractere();
            atual.setCaractere(null);
            return caractere;
        }

        return null;
    }

    private int potencia(int base, int expoente) {
        int resultado = 1;

        while (expoente > 0) {
            resultado *= base;
            expoente--;
        }

        return resultado;
    }
}

