package pl.kgrzeg.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private final String version = "v0.2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.textViewVersion)).setText(version);
    }

    public void doLogin(View view) {
        Intent i = new Intent(this, UserPrivateActivity.class);
        startActivity(i);
    }

    public void doRegister(View view) {
    }
}
