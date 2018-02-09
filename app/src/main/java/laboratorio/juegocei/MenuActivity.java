package laboratorio.juegocei;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import android.graphics.*;
import android.view.*;
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        View activityMenu = findViewById(R.id.relLayoutMenu);
        //activityMenu.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.portada);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        background = Bitmap.createScaledBitmap(background, size.x, size.y, true);
        activityMenu.setBackgroundDrawable(new BitmapDrawable(background));
        Button jugar = (Button) findViewById(R.id.jugar);
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MenuActivity.this, GameActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
