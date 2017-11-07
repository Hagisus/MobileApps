package pl.kgrzeg.inputelements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkHobby(View view) {
        CheckBox cb = (CheckBox)view;
        boolean checked = cb.isChecked();
        int id = cb.getId();

        String text = "";
        switch(id){
            case R.id.checkBoxVideoGames:
                if(checked)
                    text = "You're freak!";
                else
                    text = "You don't like video games?!";
                break;
            case R.id.checkBoxSport:
                if(checked)
                    text = "You're sportsman!";
                else
                    text = "Its ok, bro. I don't like sport too...";
                break;
            case R.id.checkBoxMusic:
                if(checked)
                    text = "You like music!";
                else
                    text = "You don't like music.";
                break;
        }

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
