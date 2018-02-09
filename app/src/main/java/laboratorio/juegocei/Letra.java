package laboratorio.juegocei;

import android.graphics.Point;

/**
 * Created by Moren on 8/2/2018.
 */

public enum Letra {

    H(60,150,R.id.hbutton),
    E(30,543,R.id.ebutton),
    K(0,934,R.id.kbutton),
    A(440,1211,R.id.abutton),
    F(905,934,R.id.fbutton),
    B(875,543,R.id.bbutton),
    M(845,150,R.id.mbutton),
    C(440,-10,R.id.cbutton),
    X(440,500,R.id.xbutton);

    private Point position;
    int id;

    private Letra(int x, int y, int id2){
        position = new Point(x,y);
        id = id2;
    }

    public Point getPosition(){
        return position;
    }

    public int getX(){
        return position.x;
    }

    public int getY(){
        return position.y;
    }

    public int getId(){
        return id;
    }
}
