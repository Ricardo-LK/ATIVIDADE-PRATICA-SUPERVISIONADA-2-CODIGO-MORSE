public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inicializar();
        System.out.println("Inserindo codigos\n");

        arvore.inserir(".", "E");
        arvore.inserir(".----", "1");
        arvore.inserir("....-", "4");
        arvore.inserir(".", "E");
        arvore.inserir("-", "T");
        arvore.inserir("..", "I");
        arvore.inserir(".-", "A");
        arvore.inserir("-.", "N");
        arvore.inserir("--", "M");
        arvore.inserir("...", "S");
        arvore.inserir("..-", "U");
        arvore.inserir(".-.", "R");
        arvore.inserir(".--", "W");
        arvore.inserir("-..", "D");
        arvore.inserir("-.-", "K");
        arvore.inserir("--.", "G");
        arvore.inserir("---", "O");

        System.out.println("Codigos inseridos\n");

        // Buscando codigos
        System.out.println("Buscando codigos:\n");

        String[] mensagem = {".", "-" , ".-.", "...", "---", "..."};
        for (String codigo : mensagem) {
            arvore.buscar(codigo);
        }

        // Removendo codigos
        arvore.remover("._.");
        arvore.remover("...");
        for (String codigo : mensagem) {
            arvore.buscar(codigo);
        }

        System.out.println("Buscando/removendo codigos nao inseridos:\n");
        arvore.buscar("....");
        arvore.buscar(".-x");
        arvore.remover("..");
        arvore.remover(".-z");
    }
}