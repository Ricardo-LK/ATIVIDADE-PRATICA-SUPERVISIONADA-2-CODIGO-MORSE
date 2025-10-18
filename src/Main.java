import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inicializar();

        // Inserir todos os caracteres da tabela Morse
        System.out.println("Inserindo códigos da tabela Morse...");

        // Letras
        arvore.inserir(".-", "A");
        arvore.inserir("-...", "B");
        arvore.inserir("-.-.", "C");
        arvore.inserir("-..", "D");
        arvore.inserir(".", "E");
        arvore.inserir("..-.", "F");
        arvore.inserir("--.", "G");
        arvore.inserir("....", "H");
        arvore.inserir("..", "I");
        arvore.inserir(".---", "J");
        arvore.inserir("-.-", "K");
        arvore.inserir(".-..", "L");
        arvore.inserir("--", "M");
        arvore.inserir("-.", "N");
        arvore.inserir("---", "O");
        arvore.inserir(".--.", "P");
        arvore.inserir("--.-", "Q");
        arvore.inserir(".-.", "R");
        arvore.inserir("...", "S");
        arvore.inserir("-", "T");
        arvore.inserir("..-", "U");
        arvore.inserir("...-", "V");
        arvore.inserir(".--", "W");
        arvore.inserir("-..-", "X");
        arvore.inserir("-.--", "Y");
        arvore.inserir("--..", "Z");

        // Números
        arvore.inserir(".----", "1");
        arvore.inserir("..---", "2");
        arvore.inserir("...--", "3");
        arvore.inserir("....-", "4");
        arvore.inserir(".....", "5");
        arvore.inserir("-....", "6");
        arvore.inserir("--...", "7");
        arvore.inserir("---..", "8");
        arvore.inserir("----.", "9");
        arvore.inserir("-----", "0");

        System.out.println("Pronto!");

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Imprimir árvore");
            System.out.println("2 - Buscar caractere por código Morse");
            System.out.println("3 - Traduzir mensagem em Morse");
            System.out.println("4 - Remover caractere");
            System.out.println("5 - Sair");

            String entrada;
            do {
                System.out.print("Escolha uma opção: ");
                entrada = sc.nextLine();

                if (!ehInteiro(entrada)) {
                    System.out.println("Digite um número inteiro!");
                }
            } while (!ehInteiro(entrada));

            opcao = Integer.parseInt(entrada);

            if (opcao == 1) {
                System.out.println(arvore.representacaoASCII());
            } else if (opcao == 2) {
                System.out.print("Digite o código Morse: ");
                String codigo = sc.nextLine();
                String c = arvore.buscar(codigo);

                if (c == null) {
                    System.out.println("Código inválido ou não encontrado: " + codigo);
                } else {
                    System.out.println("Código \"" + codigo + "\" -> " + c);
                }

            } else if (opcao == 3) {
                System.out.print("Digite a mensagem em Morse (separe os caracteres por espaço): ");
                String linha = sc.nextLine();

                // Separar manualmente os códigos em vetor
                int tamanho = linha.length();
                String[] vetor = new String[100];
                int indice = 0;
                String temp = "";

                for (int i = 0; i < tamanho; i++) {
                    char c = linha.charAt(i);
                    if (c != ' ') {
                        temp = temp + c;
                    } else {
                        if (temp.length() > 0) {
                            vetor[indice] = temp;
                            indice++;
                            temp = "";
                        }
                    }
                }
                if (temp.length() > 0) {
                    vetor[indice] = temp;
                    indice++;
                }

                System.out.print("Mensagem traduzida: ");
                for (int i = 0; i < indice; i++) {
                    String c = arvore.buscar(vetor[i]);

                    if (c != null) {
                        System.out.print(c);
                    } else {
                        System.out.print("[inválido]");
                    }
                }
                System.out.println();

            } else if (opcao == 4) {
                System.out.print("Digite o código Morse a remover: ");
                String codigo = sc.nextLine();
                String caracter = arvore.remover(codigo);

                if (caracter == null) System.out.println("Código inválido ou não presente na árvore: " + codigo);
                else System.out.println("Caractere " + caracter + " com código \"" + codigo + "\" removido da árvore.");

            } else if (opcao == 5) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    public static boolean ehInteiro(String numero) {
        for (char c : numero.toCharArray()) {
            if ((int) c < 48 || c > 57) return false;
        }

        return true;
    }
}
