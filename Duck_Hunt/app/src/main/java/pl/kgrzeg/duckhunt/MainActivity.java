package pl.kgrzeg.duckhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    EditText editTextNick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ImageView title = findViewById(R.drawable.title);
        Picasso.with(this)
                .load(R.drawable.title)
                .into(title);
        */
        editTextNick = findViewById(R.id.editTextName);
    }

    public void startGame(View view) {
        String nick = editTextNick.getText().toString();

        if(!nick.isEmpty()){
            //start the game
            Intent i = new Intent(this, gameActivity.class);

            i.putExtra("nick", nick);
            startActivity(i);
        }else{
            Toast.makeText(this, getString(R.string.message_wrong_nick), Toast.LENGTH_SHORT).show();
            editTextNick.setError(getString(R.string.error_wrong_nick));
        }
    }
}
