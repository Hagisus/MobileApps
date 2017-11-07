package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import io.realm.RealmResults;
import pl.kgrzeg.database.NoteDB;
import pl.kgrzeg.database.R;

/**
 * Created by course on 06/11/2017.
 */

public class MyNotesAdapter extends ArrayAdapter<NoteDB> {
    Context ctx;
    int layoutTemplate;
    RealmResults<NoteDB> notesList;

    public MyNotesAdapter(@NonNull Context context, int resource, @NonNull List<NoteDB> objects) {
        super(context, resource, objects);
        this.ctx = ctx;
        this.layoutTemplate = layoutTemplate;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        // Get current item
        NoteDB current = notesList.get(position);

        // Get all the view components
        TextView textViewTitle = v.findViewById(R.id.textViewTitle);

        return v;
    }
}
