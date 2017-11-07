package Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;
import pl.kgrzeg.database.NoteDB;
import pl.kgrzeg.database.R;

public class NewNoteActivity extends AppCompatActivity {
    EditText title, describe;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        setTitle("New Note");

        // Get the connection to the Database
        realm = Realm.getDefaultInstance();
        title = findViewById(R.id.editTextTitle);
        describe = findViewById(R.id.editTextDescribe);
    }

    public void saveNote(View view) {
        // INSERT INTO...
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                NoteDB newNote = new NoteDB();

                newNote.setTitle(title.getText().toString());
                newNote.setDescription(describe.getText().toString());

                // Insert the new object into the local database
                realm.copyToRealm(newNote);

                // Destroy this screen
                finish();
            }
        });
    }
}
