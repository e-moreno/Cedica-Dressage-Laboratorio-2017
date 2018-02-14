package laboratorio.juegocei;

import android.graphics.Point;

/**
 * Created by Moren on 7/2/2018.
 */

public enum Tramo {
    PRIMER_TRAMO(
            new Point[]{new Point(465,1185),new Point(477,6),
                    new Point(168,3), new Point(108,507)}
    ),
    SEGUNDO_TRAMO(
            new Point[]{new Point(96,555), new Point(120,657),
                    new Point(168,732), new Point(243,801),
                    new Point(243,801), new Point(330,843),
                    new Point(465,870), new Point(585,864),
                    new Point(723,813), new Point(819,705),
                    new Point(858,543), new Point(810,393),
                    new Point(708,282), new Point(561,231),
                    new Point(432,225), new Point(300,249),
                    new Point(201,318), new Point(126,429),
                    new Point(18,1140), new Point(939,1140),
                    new Point(894,Letra.F.getY())
            }
    ),
    TERCER_TRAMO(
            new Point[]{
                    new Point(906,Letra.F.getY()), new Point(99,540),
                    new Point(171,9),new Point(483,6)
            }
    ),
    CUARTO_TRAMO(new Point[]{
            new Point(478,4), new Point(796,6),
            new Point(850,570), new Point(820,698),
            new Point(758,786), new Point(758,786),
            new Point(658,838), new Point(524,860),
            new Point(404,854),new Point(286,822),
            new Point(208,762), new Point(140,664),
            new Point(114,534), new Point(146,438),
            new Point(200,356),new Point(280,284),
            new Point(384,246),new Point(486,236),
            new Point(572,244), new Point(652,268),
            new Point(652,270), new Point(652,272),
            new Point(738,334), new Point(780,378),
            new Point(820,468), new Point(844,566)
    }),
    QUINTO_TRAMO(new Point[]{
            new Point(864,603),new Point(939,1140),
            new Point(489,1140),new Point(471,606)
    });

    private Point[] recorrido;
    private Tramo(Point[] puntos){
        recorrido = puntos;
    }
    public Point getPoint(int i){
        return recorrido[i];
    }

    public int getLength(){
        return recorrido.length;
    }
}
