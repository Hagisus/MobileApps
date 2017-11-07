package pl.kgrzeg.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name1, name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = findViewById(R.id.editTextPlayer1);
        name2 = findViewById(R.id.editTextPlayer2);
    }

    public void startGame(View view) {

        if(name1.getText().toString().isEmpty()) {
            name1.setError("Write player 1 name");
            return;
        }
        if(name2.getText().toString().isEmpty()) {
            name2.setError("Write player 2 name");
            return;
        }

        Intent intentGameScreen = new Intent(this, GameActivity.class);

        intentGameScreen.putExtra("Name1", name1.getText().toString());
        intentGameScreen.putExtra("Name2", name2.getText().toString());

        startActivity(intentGameScreen);
    }
}
