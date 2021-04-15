package mc322.lab04;

public class AppRestaUm {

    /*
    Recebe uma String contendo o caminho do arquivo .csv contendo os comandos
    a serem executados no jogo Resta Um. Retorna um vetor de String em que cada
    posição corresponde ao estado de tabuleiro após i-ésimo - 1 comando.
    Obs.: A posição 0 do vetor corresponde ao tabuleiro recém criado.
     */
    static String[] executaJogo(String caminho){

        CSVReader csv = new CSVReader();
        csv.setDataSource(caminho);
        String commands[] = csv.requestCommands();

        String[] estados = new String[commands.length + 1];
        Tabuleiro tabuleiro = new Tabuleiro();

        System.out.println("Tabuleiro inicial:");
        tabuleiro.mostrarTabuleiro();
        estados[0] = tabuleiro.tabuleiroParaString();

        for (int i = 1; i <= commands.length; i++){
            tabuleiro.executaComando(commands[i - 1]);
            System.out.println("Source: " + commands[i-1].substring(0, 2));
            System.out.println("Target: " + commands[i-1].substring(3, 5));
            tabuleiro.mostrarTabuleiro();
            estados[i] = tabuleiro.tabuleiroParaString();
        }
        return estados;
    }

    public static void main(String[] args){
        String[] vetorTabuleiros = executaJogo("C:/Users/Cícero/Downloads/arq001.csv");
    }
}