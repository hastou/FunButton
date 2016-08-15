package funbutton.hastou.com.funbutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    private Toast dontTouchToast;

    private View.OnTouchListener viewTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            dontTouchToast.show();
            Button button = (Button) view;
            int largeur = button.getWidth();
            int hauteur = button.getHeight();

            float x = motionEvent.getX();
            float y = motionEvent.getY();

            button.setTextSize((Math.abs(x - largeur / 2) + Math.abs(y - hauteur / 2)) / 22);
            button.setTextColor(Color.rgb((int) (y / hauteur * 255), (int) (x / largeur * 255), 0));
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dontTouchToast = Toast.makeText(getApplicationContext(), "Don't touch me !", Toast.LENGTH_SHORT);
        dontTouchToast.setGravity(Gravity.LEFT|Gravity.BOTTOM, 10, 10);
        Button interactiveButton = (Button) findViewById(R.id.interactive_button);
        interactiveButton.setOnTouchListener(viewTouchListener);
    }
}
