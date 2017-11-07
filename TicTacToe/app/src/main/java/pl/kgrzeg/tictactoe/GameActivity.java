package pl.kgrzeg.tictactoe;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int player_now = 1;
    int[] points = {0, 0};
    String[] names = new String[2];
    Drawable[] signs = new Drawable[3];
    ImageView[] fields = new ImageView[9];
    TextView[] ivpoints = new TextView[2];
    TextView[] ivplay = new TextView[2];
    int[] moves = {2,2,2,2,2,2,2,2,2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        signs[0] = getResources().getDrawable(R.drawable.plus);
        signs[1] = getResources().getDrawable(R.drawable.minus);
        signs[2] = getResources().getDrawable(R.drawable.empty);

        Bundle extras = getIntent().getExtras();
        names[0] = extras.getString("Name1");
        names[1] = extras.getString("Name2");


        ((TextView)findViewById(R.id.Nick1)).setText(names[0]);
        ((TextView)findViewById(R.id.Nick2)).setText(names[1]);

        ivpoints[0] = findViewById(R.id.Points1);
        ivpoints[1] = findViewById(R.id.Points2);

        ivplay[0] = findViewById(R.id.Playing1);
        ivplay[1] = findViewById(R.id.Playing2);

        fields[0] = findViewById(R.id.field1);
        fields[1] = findViewById(R.id.field2);
        fields[2] = findViewById(R.id.field3);
        fields[3] = findViewById(R.id.field4);
        fields[4] = findViewById(R.id.field5);
        fields[5] = findViewById(R.id.field6);
        fields[6] = findViewById(R.id.field7);
        fields[7] = findViewById(R.id.field8);
        fields[8] = findViewById(R.id.field9);

        RandomPlayer();
        SwitchPlayer();

    }

    public void endGame(View view) {
        finish();
    }

    public void doMove(View view) {

        ImageView field = (ImageView)view;

        int n = 0;
        switch(field.getId()){
            case R.id.field1: n = 0; break;
            case R.id.field2: n = 1; break;
            case R.id.field3: n = 2; break;
            case R.id.field4: n = 3; break;
            case R.id.field5: n = 4; break;
            case R.id.field6: n = 5; break;
            case R.id.field7: n = 6; break;
            case R.id.field8: n = 7; break;
            case R.id.field9: n = 8; break;
        }

        if( moves[n] != 2){
            Toast.makeText(this, "This field is occupied", Toast.LENGTH_SHORT).show();
            return;
        }

        field.setImageDrawable(signs[player_now]);
        moves[n] = player_now;

        if(CheckWin())
            win();

        if (CheckFull())
            draw();

        SwitchPlayer();
    }

    public boolean CheckWin(){
        //horizontal lines
        for (int j = 0; j < 3; j++) {
            if( moves[j*3] != 2 &&
                    moves[j*3] == moves[j*3+1] &&
                    moves[j*3+1] ==( moves[j*3+2])){
                return true;
            }
        }
        //vertical lines
        for (int j = 0; j < 3; j++) {
            if( moves[j] != 2 &&
                    moves[j] == moves[j+3] &&
                    moves[j+3] ==( moves[j+6])){
                return true;
            }
        }
        //cross lines
        if( moves[0] != 2 &&
                moves[0] == moves[4] &&
                moves[4] ==( moves[8])){
            return true;
        }
        if( moves[2] != 2 &&
                moves[2] == moves[4] &&
                moves[4] ==( moves[6])){
            return true;
        }

        return false;
    }
    public boolean CheckFull(){
        for (int i = 0; i < 9; i++) {
            if( moves[i] == 2)
                return false;
        }
        return true;
    }

    public void ClearFields(){
        for (int i = 0; i < 9; i++) {
            fields[i].setImageDrawable(signs[2]);
            moves[i] = 2;
        }
        RandomPlayer();
    }

    public void win(){
        AddPoint();
        Toast.makeText(this, "Player "+names[player_now]+" won!", Toast.LENGTH_SHORT).show();
        ClearFields();
    }
    public void draw(){
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        ClearFields();
    }

    public void AddPoint(){
        points[player_now]++;
        ivpoints[player_now].setText(String.valueOf(points[player_now]));
    }
    public void RandomPlayer(){
        Random randomGenerator = new Random();
        if(randomGenerator.nextBoolean())
            player_now = 0;
        else
            player_now = 1;
    }
    public void SwitchPlayer(){
        ivplay[player_now].setVisibility(View.INVISIBLE);
        player_now = (player_now+1)%2;
        ivplay[player_now].setVisibility(View.VISIBLE);
    }

}
