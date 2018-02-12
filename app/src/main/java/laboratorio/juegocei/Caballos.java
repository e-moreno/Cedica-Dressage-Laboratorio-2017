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
    }),
    //ABAJO
    CABALLO_SUR(new int[]{
            R.drawable.sur0010,R.drawable.sur0011,R.drawable.sur0012,
            R.drawable.sur0013,R.drawable.sur0014,R.drawable.sur0015,
            R.drawable.sur0016,R.drawable.sur0017,R.drawable.sur0018,
            R.drawable.sur0019,R.drawable.sur0020,R.drawable.sur0021,
            R.drawable.sur0022,R.drawable.sur0023,R.drawable.sur0024,
            R.drawable.sur0025,R.drawable.sur0026,R.drawable.sur0027,
            R.drawable.sur0028,R.drawable.sur0029,R.drawable.sur0030
    }),
    //DERECHA
    CABALLO_ESTE(new int[]{
            R.drawable.este_1, R.drawable.este_2, R.drawable.este_3,
            R.drawable.este_4, R.drawable.este_5, R.drawable.este_6,
            R.drawable.este_7, R.drawable.este_8, R.drawable.este_9,
            R.drawable.este_10, R.drawable.este_11, R.drawable.este_12,
            R.drawable.este_13, R.drawable.este_14, R.drawable.este_15,
            R.drawable.este_16, R.drawable.este_17, R.drawable.este_18,
            R.drawable.este_19, R.drawable.este_20, R.drawable.este_21
    }),
    //IZQUIERDA
    CABALLO_OESTE(new int[]{
            R.drawable.oeste0010,R.drawable.oeste0011,R.drawable.oeste0012,
            R.drawable.oeste0013,R.drawable.oeste0014,R.drawable.oeste0015,
            R.drawable.oeste0016,R.drawable.oeste0017,R.drawable.oeste0018,
            R.drawable.oeste0019,R.drawable.oeste0020,R.drawable.oeste0021,
            R.drawable.oeste0022,R.drawable.oeste0023,R.drawable.oeste0024,
            R.drawable.oeste0025,R.drawable.oeste0026,R.drawable.oeste0027,
            R.drawable.oeste0028,R.drawable.oeste0029,R.drawable.oeste0030
    });

    private int[] ids;

    Caballos(int[] ids2){
        ids = ids2;
    }


    public int[] getIds(){
        return ids;
    }
}
