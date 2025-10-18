# Árvore Binária para Código Morse

## Descrição do Projeto

Este projeto implementa uma árvore binária que representa o código Morse, onde cada nó corresponde a um símbolo do alfabeto internacional Morse. O código Morse é um método de codificação de texto que utiliza pontos (.) e traços (-) para representar caracteres alfanuméricos.

A implementação permite armazenar todas as letras do alfabeto (A-Z) e números (0-9) em uma estrutura de árvore binária, onde cada caminho da raiz até um nó folha descreve a sequência de pontos e traços correspondente ao caractere.

## Estrutura da Implementação

### 1. Classe `Node`

A classe `Node` representa cada nó da árvore binária e contém os seguintes atributos:

- `esquerda`: Referência para o nó filho esquerdo (corresponde a ponto ".")
- `direita`: Referência para o nó filho direito (corresponde a traço "-")
- `codigo`: String que armazena a sequência de pontos e traços que levam a este nó
- `caractere`: String que armazena o caractere alfanumérico correspondente ao código Morse

**Construtores:**
- `Node()`: Cria um nó vazio
- `Node(String codigo, String caractere)`: Cria um nó com código e caractere específicos

**Métodos:**
- Getters e setters para todos os atributos

### 2. Classe `ArvoreBinaria`

Classe principal que implementa a árvore binária do código Morse.

#### Atributos:
- `raiz`: Nó raiz da árvore

#### Métodos Principais:

##### `inicializar()`
Inicializa a árvore criando um nó raiz vazio. Este método deve ser chamado antes de qualquer operação na árvore.

##### `inserir(String codigoString, String info)`
Insere um caractere na árvore de acordo com seu código Morse.

**Funcionamento:**
1. Percorre a árvore caractere por caractere do código Morse
2. Para cada ponto ("."), move para a subárvore esquerda
3. Para cada traço ("-"), move para a subárvore direita
4. Cria nós intermediários se necessário
5. Armazena o caractere no nó final

**Exemplo:** Para inserir 'S' (código "..."), o método percorre: esquerda → esquerda → esquerda

##### `buscar(String codigoString)`
Busca um caractere na árvore com base no código Morse.

**Funcionamento:**
1. Percorre a árvore seguindo o código Morse
2. Retorna o caractere armazenado no nó final
3. Retorna `null` se o código não for encontrado ou for inválido

##### `remover(String codigoString)`
Remove um caractere da árvore sem eliminar a estrutura do código.

**Funcionamento:**
1. Encontra o nó correspondente ao código Morse
2. Remove apenas o caractere (define como `null`)
3. Preserva a estrutura da árvore para manter os códigos existentes

##### `representacaoASCII()`
Gera uma representação visual da árvore em arte ASCII.

**Características:**
- Exibe a estrutura hierárquica da árvore
- Usa caracteres especiais para mostrar as conexões entre nós
- Nós vazios são representados por '∅'
- Ligações são representadas por '/', '\\', e '_'

##### `getAltura()`
Calcula a altura máxima da árvore (número de níveis).

##### Métodos Auxiliares:
- `getAlturaRec(Node node)`: Calcula altura recursivamente
- `preencherGrid()`: Preenche matriz para representação ASCII
- `potencia()`: Calcula potência para posicionamento na grade

### 3. Classe `Main`

Classe principal com interface de usuário para interagir com o sistema.

#### Funcionalidades do Menu:

1. **Imprimir árvore**: Exibe a representação visual da árvore
2. **Buscar caractere por código Morse**: Traduz código único para caractere
3. **Traduzir mensagem em Morse**: Converte sequência de códigos separados por espaço em texto
4. **Remover caractere**: Remove um caractere específico da árvore
5. **Sair**: Encerra o programa

#### Método `ehInteiro(String numero)`
Valida se uma string contém apenas dígitos numéricos.

## Especificações Técnicas

### Estrutura da Árvore
- **Raiz**: Nó vazio no nível superior
- **Subárvore esquerda**: Corresponde a pontos (".")
- **Subárvore direita**: Corresponde a traços ("-")

### Codificação Morse Implementada

**Letras:**
- A: .-      B: -...    C: -.-.    D: -..     E: .
- F: ..-.    G: --.     H: ....    I: ..      J: .---
- K: -.-     L: .-..    M: --      N: -.      O: ---
- P: .--.    Q: --.-    R: .-.     S: ...     T: -
- U: ..-     V: ...-    W: .--     X: -..-    Y: -.--
- Z: --..

**Números:**
- 1: .----   2: ..---   3: ...--   4: ....-   5: .....
- 6: -....   7: --...   8: ---..   9: ----.   0: -----

## Restrições de Implementação

Conforme especificado no projeto, foram utilizadas apenas as seguintes estruturas:
- `String`
- `length()`
- `int`

**Estruturas proibidas que NÃO foram utilizadas:**
- `StringBuilder`
- `Vector`
- `Integer`
- `throws`
- `exceptions`
- Qualquer estrutura especial de tratamento

## Exemplos de Uso

### Inserção Manual:
```java
arvore.inserir("...", "S");
arvore.inserir("---", "O");
```

### Busca:
```java
String resultado = arvore.buscar("..."); // Retorna "S"
```

### Tradução de Mensagem:
```java
String morse = "... --- ...";
// Separa em: "..." "---" "..."
// Traduz para: "SOS"
```

### Remoção:
```java
String removido = arvore.remover("..."); // Remove 'S', retorna "S"
```

## Considerações de Design

### Preservação da Estrutura
A remoção de caracteres não elimina nós da árvore, apenas remove o caractere armazenado. Isso garante que a estrutura do código Morse seja preservada e outros caracteres que compartilham prefixos não sejam afetados.

### Validação de Entrada
O sistema valida entradas do usuário para:
- Opções numéricas do menu
- Códigos Morse contendo apenas '.' e '-'
- Separação adequada de códigos por espaços

### Eficiência
- Busca: O(n) onde n é o comprimento do código Morse
- Inserção: O(n) onde n é o comprimento do código Morse
- A árvore é inicializada com todos os caracteres previamente inseridos

## Autores

- Renan da Silva Oliveira Andrade (renan.silva3@pucpr.edu.br)
- Ricardo Lucas Kucek (ricardo.kucek@pucpr.edu.br)

## Estrutura de Arquivos

```
ProjetoMorse/
├── ArvoreBinaria.java    # Implementação da árvore binária
├── Node.java             # Implementação do nó
├── Main.java             # Interface do usuário e menu
└── README.md             # Esta documentação
```

Esta implementação atende a todas as especificações do projeto, fornecendo uma árvore binária completa para código Morse com funcionalidades de inserção, busca, remoção e exibição hierárquica.