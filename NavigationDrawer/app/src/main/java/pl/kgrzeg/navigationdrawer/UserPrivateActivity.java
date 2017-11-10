package pl.kgrzeg.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class UserPrivateActivity extends AppCompatActivity {
    private String userKey;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()) {
                case R.id.navigation_awaria:
                    f = new AwariaItemFragment();
                    return true;
                case R.id.navigation_mechanicy:

                    return true;
                case R.id.navigation_profile:

                    return true;
            }

            if(f != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentcontainer,f)
                        .commit();
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_private);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Bundle extras = getIntent().getExtras();
        userKey = extras.getString("key");

        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.fragmentcontainer, new AwariaItemFragment())
            .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_options_menu, menu);
        return true;
    }
}
