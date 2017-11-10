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
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private final String version = "v0.3";
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

        if( editTextEmail.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty() ){
            Toast.makeText(this, "Type the email and password!", Toast.LENGTH_LONG).show();
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://miguelcamposrivera.com/mecaround/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MecaroundServerInterface service = retrofit.create(MecaroundServerInterface.class);

        freeze_login = true;
        Call<LoginResponse> serverResponse = service.serverLogin(
                editTextEmail.getText().toString(),
                editTextPassword.getText().toString()
        );


        serverResponse.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == 200) {
                    freeze_login = false;

                    Intent i = new Intent(MainActivity.this, UserPrivateActivity.class);

                    i.putExtra("key", response.body().getKey());

                    startActivity(i);
                } else {
                    freeze_login = false;

                    Toast.makeText(MainActivity.this, "Email and/or password are not ok", Toast.LENGTH_SHORT).show();
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
