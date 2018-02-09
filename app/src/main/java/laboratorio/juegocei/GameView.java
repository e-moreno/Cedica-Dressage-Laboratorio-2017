package laboratorio.juegocei;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by diego on 6/11/2017.
 */

public class GameView extends SurfaceView implements Runnable {

    //*****MAIN LOOP **
    //indica si el juego esta reproduciéndose
    boolean playing;
    //thread del juego
    private Thread gameThread = null;
    //****FIN MAIN LOOP **


    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    private Bitmap background;
    private Bitmap pista;
    private Bitmap caballo;

    private int screenX; //ancho de pantalla
    private int screenY; //alto de pantalla
    private final int MARGEN_IZQUIERDO_DERECHO_PISTA;
    private int MARGEN_ARRIBA_PISTA;
    public int MARGEN_ABAJO_PISTA;
    public final int ANCHO_ORIGINAL_IMAGEN_PISTA = 951; //en pixels
    public final int ALTO_ORIGINAL_IMAGEN_PISTA = 1211; //en pixels
    public int anchoPista;//ancho redimensionado de la pista en pixels
    public int altoPista;//alcho redimensionado de la pista en pixels

    private PathMeasure pathMeasureTramoActual;
    private float longitudTramoActual;
    private float distanciaRecorridaTramoActual;
    Path path = null;
    private boolean firsttime = true;

    private Matrix matrix = new Matrix();

    int frame = 0;

    //Puntos de prueba para una imagen de ANCHO_ORIGINAL_IMAGEN_PISTA  x ALTO_ORIGINAL_IMAGEN_PISTA

    private Tabla nivel = Tabla.TABLA1_NIVELC_TEST2;
    private int tramoactual = 0;
    private int totalTramos = nivel.length();
    private Tramo tramo_actual = nivel.getTramo(tramoactual);
    private Path[] paths = new Path[totalTramos];
    public GameView(Context context, int screenX, int screenY)  {
        super(context);
        this.setScreenX(screenX);
        this.setScreenY(screenY);

        surfaceHolder = getHolder();

        //configuro paint
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);


        //Imagen de fondo
        background = BitmapFactory.decodeResource(getResources(), R.drawable.fondo);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, true);


        //Imagen de pista
        MARGEN_IZQUIERDO_DERECHO_PISTA = screenX / 20;
        MARGEN_ARRIBA_PISTA = screenX / 4;
        MARGEN_ABAJO_PISTA = screenX / 4;
        InputStream is=null;
        AssetManager am=null;
        try  {
            am= context.getAssets();
            is = am.open("pista.png");
        }catch (IOException ioe){

        }

        pista= BitmapFactory.decodeStream(is);
       // pista = BitmapFactory.decodeResource( getResources(), R.drawable.pista);
        anchoPista = screenX - (MARGEN_IZQUIERDO_DERECHO_PISTA * 2);//ancho en pixels
        altoPista = screenY - MARGEN_ARRIBA_PISTA - MARGEN_ABAJO_PISTA;//alto en pixels
        pista = Bitmap.createScaledBitmap(pista, anchoPista, altoPista, true);


        //Imagen del caballo
        caballo = BitmapFactory.decodeResource(getResources(), R.drawable.horse);

        for(int ind = 0; ind < totalTramos; ind++){
            tramo_actual = nivel.getTramo(ind);
            //convierto tramo_actual
            for (int j = 0; j < tramo_actual.getLength(); j++) {
                Point p = tramo_actual.getPoint(j);
                p.set(getXConvertido(anchoPista, p.x), getYConvertido(altoPista, p.y));
            }


            Point p;
            //Armo el path
            path = new Path();

            for (int i = 0; i < tramo_actual.getLength(); i++) {

                if (i == 0) {
                    path.moveTo(tramo_actual.getPoint(i).x, tramo_actual.getPoint(i).y);
                } else {
                    path.lineTo(tramo_actual.getPoint(i).x, tramo_actual.getPoint(i).y);
                }


            }
            paths[ind] = path;

        }

    }


    public int getYConvertido(int altoPista, int y) {
        return MARGEN_ARRIBA_PISTA /*+ altoPista */ + (y * altoPista / ALTO_ORIGINAL_IMAGEN_PISTA);
        /*int newY = y-80;
        return newY;*/
    }

    public int getXConvertido(int anchoPista, int x) {
        return (x * anchoPista / ANCHO_ORIGINAL_IMAGEN_PISTA) + MARGEN_IZQUIERDO_DERECHO_PISTA;
        /*int newX = x-270;
        return newX;*/
    }


    private void draw() {

        if (surfaceHolder.getSurface().isValid()) {
            //lock del canvas
            canvas = surfaceHolder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, paint);
            canvas.drawBitmap(pista, MARGEN_IZQUIERDO_DERECHO_PISTA, MARGEN_ARRIBA_PISTA, paint);
            if(!firsttime || tramoactual>0){
                canvas.drawPath((firsttime||tramoactual==0)?paths[0]:paths[tramoactual-1], paint); //dibujo tramo actual
            }

            this.dibujarCaballo(canvas, caballo, distanciaRecorridaTramoActual, pathMeasureTramoActual, matrix, anchoPista, altoPista, frame);

            if (distanciaRecorridaTramoActual < longitudTramoActual) {
                distanciaRecorridaTramoActual += 10;
                if (distanciaRecorridaTramoActual > longitudTramoActual) {// Si supera el punto de llegada, lo seteo al extremo del path
                    distanciaRecorridaTramoActual = longitudTramoActual;

                }
            }

            //Unlock del canvas
            surfaceHolder.unlockCanvasAndPost(canvas);
            firsttime = false;
        }
    }


    private void dibujarCaballo(Canvas canvas, Bitmap caballo, float distanciaRecorrida, PathMeasure pathMeasure, Matrix matrix, int anchoPista, int altoPista, int frame) {
        Bitmap caballoRedimiensionado = null;
        int caballo_offsetX;
        int caballo_offsetY;
        float x;
        float y;

        matrix.reset();
        if (pathMeasure != null) {
            float[] pos = new float[2];
            float[] tan = new float[2];
            pathMeasure.getPosTan(distanciaRecorrida, pos, tan);
            x = pos[0];
            y = pos[1];
            float degrees = (float) (Math.atan2(tan[1], tan[0]) * 180.0 / Math.PI) + 90; //angulo del tramo
            caballoRedimiensionado = redimensionarCaballo(caballo, anchoPista, altoPista, altoPista - (y - MARGEN_ARRIBA_PISTA));
            caballo_offsetX = caballoRedimiensionado.getWidth() / 2;
            caballo_offsetY = caballoRedimiensionado.getHeight() / 2;
            matrix.postRotate(degrees/* + 90*/, caballo_offsetX, caballo_offsetY);
            matrix.postTranslate(x - caballo_offsetX, y - caballo_offsetY);
            canvas.drawBitmap(caballoRedimiensionado, matrix, null);
        }


    }

    /*
        Redimensiona el caballo de acuerdo a la profundidad en la que se encuentra
     */
    private Bitmap redimensionarCaballo(Bitmap caballo, int anchoPista, int altoPista, float profundidad) { //profundidad va de 0 a alto de pista. 0 es menos profundo
        float incrementoPorProfundidad = (profundidad) * 1 / altoPista;
        float divisor = 2 + incrementoPorProfundidad;
        int anchoCaballo = (int) (anchoPista / divisor);
        int altoCaballo = anchoCaballo * caballo.getHeight() / caballo.getWidth();
        return Bitmap.createScaledBitmap(caballo, anchoCaballo, altoCaballo, true);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(tramoactual == totalTramos){
            Intent myIntent = new Intent(this.getContext(), LastActivity.class);
            this.getContext().startActivity(myIntent);
        }else {
            distanciaRecorridaTramoActual = 0;
            pathMeasureTramoActual = new PathMeasure(paths[tramoactual++], false);
            longitudTramoActual = pathMeasureTramoActual.getLength();
        }
        return super.onTouchEvent(event);
    }

    public void pause() {
        playing = false;
        try {

            gameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {

        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }


    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
    }


    @Override
    public void run() {
        while (playing) {
            update();
            draw();
            control();
        }
    }

    private void update() {

    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


