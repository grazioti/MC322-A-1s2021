package mc322.lab03;

public class AquarioLombriga {
    char aquario[];    //situa��o atual do aquario com a lombriga
    int A;             //tamanho do aquario
    int L;             //tamanho da lombriga
    int pos;           //posi��o inicial da lombriga
    int cauda;         //posi��o da cauda no aquario
    int cabeca;        //posi��o da cabe�a no aquario
    
    AquarioLombriga(int A, int L, int pos) {
        this.A = A;
        this.L = L;
        this.pos = pos;
    
        //caso da lombriga tiver tamanhos menores ou iguais a 1:
        if (L <= 1) {
        	this.L = 2;
        }
        
        //caso da lombriga ser maior que o aquario: aumentar o aqu�rio
        if (L > A) {
            this.A = L;
            this.pos = 1;
        }
        
        //caso a lombriga n�o caiba na posi��o especificada: colocar a lombriga na posi��o 1.
        if (A - pos < L) {
            this.pos = 1;
        }
    
        cauda = this.pos - 1;
        cabeca = cauda + this.L - 1;
        this.aquario = new char[this.A];
        
        for (int i = 0; i < this.A; i++)
            aquario[i] = '#';
            
        for (int i = cauda; i < cabeca; i++)
            aquario[i] = '@';
        
        aquario[cabeca] = 'O'; 
    }
    
    void apresenta() {
        System.out.println(aquario);
    }
    
    void virar() {
        aquario[cabeca] = '@';
        aquario[cauda] = 'O';
        int aux = cabeca;
        cabeca = cauda;
        cauda = aux;
    } 
        
    void crescer() {  
        if ( cauda < cabeca && cauda > 0 ) {
            aquario[cauda-1] = '@';
            cauda -= 1;
            
        }
        
        if ( cauda > cabeca && cauda < A-1 ) {
            aquario[cauda+1] = '@';
            cauda += 1;
        }
    }
        
    void mover() {
        if ( cabeca < cauda ) {
            if ( cabeca > 0 ) {
                //movendo para esquerda
                aquario[cauda] = '#';
                aquario[cabeca] = '@';
                cabeca -= 1;
                cauda -= 1;
                aquario[cabeca] = 'O';
            }
            else {
                virar();
            }
        }
        
        else if ( cabeca > cauda ) {
            if ( cabeca < A-1 ) {
                //movendo para direita
                aquario[cauda] = '#';
                aquario[cabeca] = '@';
                cabeca += 1;
                cauda += 1;
                aquario[cabeca] = 'O';
            }
            
            else {
                virar();
            }
        }
    }
}