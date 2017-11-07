package Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.atomic.AtomicLong;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import pl.kgrzeg.database.CategoryNoteDB;
import pl.kgrzeg.database.R;

public class NewCategoryActivity extends AppCompatActivity {
    EditText title, colorCode;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);

        setTitle("New Category");

        // Get the connection to the Database
        realm = Realm.getDefaultInstance();
        title = findViewById(R.id.editTextTitle);
        colorCode = findViewById(R.id.editTextColor);
    }

    public void saveCategory(View view) {
        // INSERT INTO...
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryNoteDB newCategory = new CategoryNoteDB();

                newCategory.setTitle(title.getText().toString());
                newCategory.setColor(colorCode.getText().toString());

                // Insert the new object into the local database
                realm.copyToRealm(newCategory);

                // Destroy this screen
                finish();
            }
        });
    }
}
