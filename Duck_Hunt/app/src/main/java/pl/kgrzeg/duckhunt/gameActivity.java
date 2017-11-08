package pl.kgrzeg.duckhunt;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class gameActivity extends AppCompatActivity {
    TextView textViewName, textViewTime, textViewCounter;
    ImageView duck;
    int counter = 0;
    long time = 10000;
    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Hide the action bar
        getSupportActionBar().hide();

        textViewName = findViewById(R.id.textViewName);
        textViewTime = findViewById(R.id.textViewTime);
        textViewCounter = findViewById(R.id.textViewCounter);
        duck = findViewById(R.id.imageViewDuck);

        Bundle extras = getIntent().getExtras();
        textViewName.setText(extras.getString("nick"));

        moveDuck();
        textViewTime.setText(time / 1000 + "s");

        startCountDown();
    }

    private void startCountDown() {
        new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                textViewTime.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                textViewTime.setText("Game Over!");
                gameOver = true;

                showGameOverDialog();
            }
        }.start();
    }

    private void showGameOverDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(getString(R.string.dialog_gameover_message) +" "+String.valueOf(counter)+" "+ getString(R.string.dialog_gameover_message2))
                .setTitle(getString(R.string.dialog_gameover_title))
                .setCancelable(false);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                moveDuck();
                counter = 0;
                gameOver = false;
                startCountDown();
                //dialog.dismiss();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void duckClick(View view) {
        if(gameOver) {
            Toast.makeText(this, "Start a new game!", Toast.LENGTH_SHORT).show();
            return;
        }
        counter++;
        textViewCounter.setText(String.valueOf(counter));

        moveDuck();
    }

    private void moveDuck() {
        Random rand = new Random();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int heightixels = metrics.heightPixels;
        int widthPixels = metrics.widthPixels;

        int duckWidth = duck.getWidth();
        int duckHeight = duck.getHeight();

        int maxX = widthPixels - duckWidth;
        int maxY = heightixels - duckHeight;
        int min = 0;


        int randomX = rand.nextInt( (maxX - min) + 1) + min;
        int randomY = rand.nextInt( (maxY - min) + 1) + min;

        duck.setX(randomX);
        duck.setY(randomY);
    }
}
