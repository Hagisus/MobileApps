package Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import Adapters.MyNotesAdapter;
import io.realm.Realm;
import io.realm.RealmResults;
import pl.kgrzeg.database.NoteDB;
import pl.kgrzeg.database.R;

public class NoteListActivity extends AppCompatActivity {
    ListView lista;
    RealmResults<NoteDB> noteDBList;
    Realm realm;
    long idCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        Bundle extras = getIntent().getExtras();
        idCategory = extras.getLong("categoryId");

        lista = findViewById(R.id.ListViewNotes);
        realm = Realm.getDefaultInstance();
        // SELECT * FROM NoteDB WHERE idCategory = x;
        noteDBList = realm.where(NoteDB.class)
                .equalTo("idCat", idCategory)
                .findAll();


        MyNotesAdapter adapter = new MyNotesAdapter(
                this,
                R.layout.note_item, //the template to draw one item
                noteDBList
        );

        lista.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_new_note:
                Intent i = new Intent(this, NewNoteActivity.class);
                startActivity(i);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
