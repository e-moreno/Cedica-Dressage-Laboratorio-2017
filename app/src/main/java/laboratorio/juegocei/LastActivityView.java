package laboratorio.juegocei;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Moren on 9/2/2018.
 */

public class LastActivityView extends SurfaceView implements Runnable{
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private Paint paint;
    private Bitmap background;
    private Bitmap pista;
    private int screenX;
    private int screenY;


    public LastActivityView(Context context, int screenX, int screenY){
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;
        //Imagen de fondo
        background = BitmapFactory.decodeResource(getResources(), R.drawable.fondo);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, true);

        //Imagen de pista
        pista = BitmapFactory.decodeResource(getResources(), R.drawable.fondo);
        pista = Bitmap.createScaledBitmap(pista,screenX,screenY,true);
        surfaceHolder = getHolder();
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void draw(){
        if (surfaceHolder.getSurface().isValid()) {
            //lock del canvas
            canvas = surfaceHolder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, paint);
            canvas.drawBitmap(pista, screenX / 20,screenY / 4, paint);
        }
    }

    public void run(){
        draw();
    }
}
