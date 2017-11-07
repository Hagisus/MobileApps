package pl.kgrzeg.relativelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewCage;
    TextView name, profession;
    int points = 1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewCage = (ImageView)findViewById(R.id.imageViewPhoto);
        name = (TextView) findViewById(R.id.textViewName);
        profession = (TextView) findViewById(R.id.textViewProfession);

        Picasso.with(this)
                .load("http://gifimage.net/wp-content/uploads/2017/06/nicolas-cage-gif-11.gif")
                .into(imageViewCage);

        name.setText("Nicolas Cage");
        profession.setText("Actor");
        ((TextView) findViewById(R.id.textViewPoints)).setText(String.valueOf(points));
    }
}
