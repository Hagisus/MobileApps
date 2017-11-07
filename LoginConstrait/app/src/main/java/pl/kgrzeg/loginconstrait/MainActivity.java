package pl.kgrzeg.loginconstrait;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.Name);
        password= findViewById(R.id.Password);
    }

    public void doLogin(View view) {
        String n = name.getText().toString();
        String p = password.getText().toString();

        if( n.equals("Grzesio") && p.equals("secret") ){
            Intent intentPrivateScreen = new Intent(this, PrivateActivity.class);

            intentPrivateScreen.putExtra("userName", n);
            intentPrivateScreen.putExtra("userAge", 20);

            Toast toast = Toast.makeText(this, "Logged in!", Toast.LENGTH_SHORT);
            toast.show();

            startActivity(intentPrivateScreen);
        }else{
            Toast toast = Toast.makeText(this, "Wrong password!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
