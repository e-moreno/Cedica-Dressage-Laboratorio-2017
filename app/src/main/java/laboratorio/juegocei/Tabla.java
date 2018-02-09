package laboratorio.juegocei;

import junit.framework.Test;

/**
 * Created by Moren on 7/2/2018.
 */

public enum Tabla {
    TABLA1_NIVELC_TEST2(
            new Tramo[]{Tramo.PRIMER_TRAMO,Tramo.SEGUNDO_TRAMO,Tramo.TERCER_TRAMO,Tramo.CUARTO_TRAMO,Tramo.QUINTO_TRAMO},
            new Character[]{'E','F','C','B','X'}
    ),
    TABLA2_GRADO1_TESTA(
            new Tramo[]{},
            new Character[]{}
    );
    private Tramo[] tramos;
    private Character[] letras;
    private Tabla(Tramo[] tramos2, Character[] letras2){
        letras = letras2;
        tramos = tramos2;
    }
    public Tramo getTramo(int i){
        return tramos[i];
    }
    public int length(){
        return tramos.length;
    }
}
