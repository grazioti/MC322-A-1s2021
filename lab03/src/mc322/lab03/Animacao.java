package mc322.lab03;

public class Animacao {
    char acoes[];      //vetor com cada uma das acoes a ser executada
    AquarioLombriga umAquario;
    
    Animacao(String sequencia) {

        //convertendo os intervalos de string da sequencia em inteiro
        int A = Integer.parseInt(sequencia.substring(0,2));
        int L = Integer.parseInt(sequencia.substring(2,4));
        int pos = Integer.parseInt(sequencia.substring(4,6));
        
        String str_acoes = sequencia.substring(6);
        this.acoes = str_acoes.toCharArray();
        
        umAquario = new AquarioLombriga(A,L,pos);
        apresenta();
    }
    
    void apresenta() {
    	umAquario.apresenta();
    }
    
    void passo() {
        for ( int i = 0; i < acoes.length; i++ ) {
            switch (acoes[i]) {
                case 'C':
                    umAquario.crescer();
                    break;

                case 'M':
                    umAquario.mover();
                    break;

                case 'V':
                    umAquario.virar();
                    break;
            }
            apresenta();
        }
    }
}
