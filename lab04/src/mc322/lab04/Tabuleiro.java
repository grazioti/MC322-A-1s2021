package mc322.lab04;

public class Tabuleiro {

    //As posições do tabuleiro serão descritas utilizando as colunas de 'a' até 'g' e as linhas de 1 até 7
    Peca[][] tabuleiro;

    Tabuleiro() {
        tabuleiro = new Peca[7][7];

        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if ( (i < 2 || i > 4 ) && (j < 2 || j > 4 ) ){
                    tabuleiro[i][j] = new Peca(' ');
                }
                else if ( (i == 3 && j == 3) ){
                    tabuleiro[i][j] = new Peca('-');
                }
                else {
                    tabuleiro[i][j] = new Peca('P');
                }
            }
        }
    }

    void executaComando(String comando) {
        int pos_ini_i = comando.charAt(1) - '1';
        int pos_ini_j = comando.charAt(0) - 'a';
        int pos_fim_i = comando.charAt(4) - '1';
        int pos_fim_j = comando.charAt(3) - 'a';

        int media_i = (pos_ini_i + pos_fim_i) / 2;
        int media_j = (pos_ini_j + pos_fim_j) / 2;

        if (pos_ini_i > 6 || pos_ini_i < 0 || pos_ini_j > 6 || pos_ini_j < 0) {
            System.out.println("A posição inicial informada não pertence ao tabuleiro!");
        }
        else if (pos_fim_i > 6 || pos_fim_i < 0 || pos_fim_j > 6 || pos_fim_j < 0){
            System.out.println("A posição final informada não pertence ao tabuleiro!");
        }
        else if ((tabuleiro[pos_ini_i][pos_ini_j].peca == '-') || (tabuleiro[pos_ini_i][pos_ini_j].peca == ' ') ) {
            System.out.println("A peça que você deseja mover é inválida!");
        }
        else if (tabuleiro[pos_fim_i][pos_fim_j].peca != '-') {
            System.out.println("A posição que você deseja mover não é válida!");
        }
        else if ((pos_ini_i != pos_fim_i) && (pos_ini_j != pos_fim_j)) {
            System.out.println("Não é possível mover peças na diagonal!");
        }
        else if (tabuleiro[media_i][media_j].peca != 'P') {
            System.out.println("Não há peças para comer nesse espaço!");
        }
        else if ((Math.abs(pos_ini_i - pos_fim_i)) + (Math.abs(pos_ini_j - pos_fim_j)) != 2) {
            System.out.println("Não é possível mover peças a uma distância maior que 2!");
        }
        else {
            tabuleiro[pos_ini_i][pos_ini_j].peca = '-';
            tabuleiro[pos_fim_i][pos_fim_j].peca = 'P';

            tabuleiro[media_i][media_j].peca = '-';
        }
    }

    void mostrarTabuleiro() {
        for (int i = 0; i < 7; i++){
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 7; j++){
                System.out.print(tabuleiro[i][j].peca + " ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g ");
        System.out.println();
    }

    String tabuleiroParaString() {
        String retorno = "";

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                retorno += tabuleiro[i][j].peca;
            }
            retorno += '\n';
        }
        return retorno;
    }
}