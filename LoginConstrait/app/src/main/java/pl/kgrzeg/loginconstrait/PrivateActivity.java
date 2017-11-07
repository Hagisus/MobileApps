package pl.kgrzeg.loginconstrait;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PrivateActivity extends AppCompatActivity {

    TextView textViewName, textViewAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private);

        textViewName = findViewById(R.id.textViewName);
        textViewAge = findViewById(R.id.textViewAge);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("userName");
        int age = extras.getInt("userAge");

        textViewName.setText(name);
        textViewAge.setText(String.valueOf(age));
    }

    public void doLogout(View view) {
        finish();
    }
}
