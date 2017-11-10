package pl.kgrzeg.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    private final String version = "v0.2";
    EditText editTextEmail, editTextPassword;
    boolean freeze_login = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.textViewVersion)).setText(version);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void doLogin(View view) {
        if(freeze_login)
            return;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://miguelcamposrivera.com/mecaround/api/v1/")
                .build();

        MecaroundServerInterface service = retrofit.create(MecaroundServerInterface.class);

        Call<LoginResponse> serverResponse = service.serverLogin(
                editTextEmail.getText().toString(),
                editTextPassword.getText().toString()
        );

        freeze_login = true;

        serverResponse.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.code() == 200){
                    freeze_login = false;
                    Intent i = new Intent(MainActivity.this, UserPrivateActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Email and/or password are not ok", Toast.LENGTH_SHORT).show();
                freeze_login = false;
            }
        });

    }

    public void doRegister(View view) {
    }
}
