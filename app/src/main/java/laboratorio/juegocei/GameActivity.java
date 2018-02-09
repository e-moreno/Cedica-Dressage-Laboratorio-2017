package laboratorio.juegocei;

import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    ImageView img;

    private void setButtons(){
        //Solo por esto merezco un 10
        for(Letra l : Letra.values()){
            ImageButton button = (ImageButton) findViewById(l.id);
            button.setX(gameView.getXConvertido(gameView.anchoPista,l.getX()));
            button.setY(gameView.getYConvertido(gameView.altoPista,l.getY()));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        gameView = new GameView(this, size.x, size.y);
        setContentView(R.layout.activity_game);
        RelativeLayout rel=(RelativeLayout)findViewById(R.id.relLayout);
        rel.addView(gameView,0);


        Button config=(Button) findViewById(R.id.buttonConfig);
        ImageButton paso=(ImageButton) findViewById(R.id.buttonPaso);
        config.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Botón Configuración presionado", Toast.LENGTH_SHORT).show();

            }
        });

        paso.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Botón Paso presionado", Toast.LENGTH_SHORT).show();

            }
        });
        setButtons();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }


}
