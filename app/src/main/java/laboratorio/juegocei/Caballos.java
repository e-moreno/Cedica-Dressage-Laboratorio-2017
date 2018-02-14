package laboratorio.juegocei;

/**
 * Created by Moren on 12/2/2018.
 */

public enum Caballos {
    //ARRIBA
    CABALLO_NORTE(new int[]{
            R.drawable.norte0010, R.drawable.norte0011, R.drawable.norte0012,
            R.drawable.norte0013, R.drawable.norte0014, R.drawable.norte0015,
            R.drawable.norte0016, R.drawable.norte0017, R.drawable.norte0018,
            R.drawable.norte0019, R.drawable.norte0020, R.drawable.norte0021,
            R.drawable.norte0022, R.drawable.norte0023, R.drawable.norte0024,
            R.drawable.norte0025, R.drawable.norte0026, R.drawable.norte0027,
            R.drawable.norte0028, R.drawable.norte0029, R.drawable.norte0030
    },0),
    //ABAJO
    CABALLO_SUR(new int[]{
            R.drawable.sur0010,R.drawable.sur0011,R.drawable.sur0012,
            R.drawable.sur0013,R.drawable.sur0014,R.drawable.sur0015,
            R.drawable.sur0016,R.drawable.sur0017,R.drawable.sur0018,
            R.drawable.sur0019,R.drawable.sur0020,R.drawable.sur0021,
            R.drawable.sur0022,R.drawable.sur0023,R.drawable.sur0024,
            R.drawable.sur0025,R.drawable.sur0026,R.drawable.sur0027,
            R.drawable.sur0028,R.drawable.sur0029,R.drawable.sur0030
    },1),
    //DERECHA
    CABALLO_ESTE(new int[]{
            R.drawable.este_1, R.drawable.este_2, R.drawable.este_3,
            R.drawable.este_4, R.drawable.este_5, R.drawable.este_6,
            R.drawable.este_7, R.drawable.este_8, R.drawable.este_9,
            R.drawable.este_10, R.drawable.este_11, R.drawable.este_12,
            R.drawable.este_13, R.drawable.este_14, R.drawable.este_15,
            R.drawable.este_16, R.drawable.este_17, R.drawable.este_18,
            R.drawable.este_19, R.drawable.este_20, R.drawable.este_21
    },2),
    //IZQUIERDA
    CABALLO_OESTE(new int[]{
            R.drawable.oeste0010,R.drawable.oeste0011,R.drawable.oeste0012,
            R.drawable.oeste0013,R.drawable.oeste0014,R.drawable.oeste0015,
            R.drawable.oeste0016,R.drawable.oeste0017,R.drawable.oeste0018,
            R.drawable.oeste0019,R.drawable.oeste0020,R.drawable.oeste0021,
            R.drawable.oeste0022,R.drawable.oeste0023,R.drawable.oeste0024,
            R.drawable.oeste0025,R.drawable.oeste0026,R.drawable.oeste0027,
            R.drawable.oeste0028,R.drawable.oeste0029,R.drawable.oeste0030
    },3),
    //ARRIBA DERECHA
    CABALLO_NORESTE(new int[]{
            R.drawable.noreste0010,R.drawable.noreste0011,R.drawable.noreste0012,
            R.drawable.noreste0013,R.drawable.noreste0014,R.drawable.noreste0015,
            R.drawable.noreste0016,R.drawable.noreste0017,R.drawable.noreste0018,
            R.drawable.noreste0019,R.drawable.noreste0020,R.drawable.noreste0021,
            R.drawable.noreste0022,R.drawable.noreste0023,R.drawable.noreste0024,
            R.drawable.noreste0025,R.drawable.noreste0026,R.drawable.noreste0027,
            R.drawable.noreste0028,R.drawable.noreste0029,R.drawable.noreste0030
    },4),
    //ARRIBA IZQUIERDA
    CABALLO_NOROESTE(new int[]{
            R.drawable.noroeste0010,R.drawable.noroeste0011,R.drawable.noroeste0012,
            R.drawable.noroeste0013,R.drawable.noroeste0014,R.drawable.noroeste0015,
            R.drawable.noroeste0016,R.drawable.noroeste0017,R.drawable.noroeste0018,
            R.drawable.noroeste0019,R.drawable.noroeste0020,R.drawable.noroeste0021,
            R.drawable.noroeste0022,R.drawable.noroeste0023,R.drawable.noroeste0024,
            R.drawable.noroeste0025,R.drawable.noroeste0026,R.drawable.noroeste0027,
            R.drawable.noroeste0028,R.drawable.noroeste0029,R.drawable.noroeste0030
    },5),
    //ABAJO DERECHA
    CABALLO_SURESTE(new int[]{
            R.drawable.sureste0010,R.drawable.sureste0011,R.drawable.sureste0012,
            R.drawable.sureste0013,R.drawable.sureste0014,R.drawable.sureste0015,
            R.drawable.sureste0016,R.drawable.sureste0017,R.drawable.sureste0018,
            R.drawable.sureste0019,R.drawable.sureste0020,R.drawable.sureste0021,
            R.drawable.sureste0022,R.drawable.sureste0023,R.drawable.sureste0024,
            R.drawable.sureste0025,R.drawable.sureste0026,R.drawable.sureste0027,
            R.drawable.sureste0028,R.drawable.sureste0029,R.drawable.sureste0030
    },6),
    //ABAJO IZQUIERDA
    CABALLO_SUROESTE(new int[]{
            R.drawable.suroeste0010,R.drawable.suroeste0011,R.drawable.suroeste0012,
            R.drawable.suroeste0013,R.drawable.suroeste0014,R.drawable.suroeste0015,
            R.drawable.suroeste0016,R.drawable.suroeste0017,R.drawable.suroeste0018,
            R.drawable.suroeste0019,R.drawable.suroeste0020,R.drawable.suroeste0021,
            R.drawable.suroeste0022,R.drawable.suroeste0023,R.drawable.suroeste0024,
            R.drawable.suroeste0025,R.drawable.suroeste0026,R.drawable.suroeste0027,
            R.drawable.suroeste0028,R.drawable.suroeste0029,R.drawable.suroeste0030
    },7);

    private int[] ids;
    private int id;

    Caballos(int[] ids2,int id2){
        ids = ids2;
        id = id2;
    }

    public int getId(){
        return id;
    }

    public int[] getIds(){
        return ids;
    }
}
