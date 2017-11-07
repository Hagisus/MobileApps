package pl.kgrzeg.customlist1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by course on 03/11/2017.
 */

class MyStudentAdapter extends ArrayAdapter<Student> {
    Context ctx;
    int layoutTemplate;
    List<Student> studentList;

    public MyStudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);

        this.ctx = context;
        this.layoutTemplate = resource;
        this.studentList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        ImageView photo = v.findViewById(R.id.photo);
        TextView name = v.findViewById(R.id.name);
        TextView training = v.findViewById(R.id.training);
        TextView shool = v.findViewById(R.id.shool);
        TextView age = v.findViewById(R.id.age);

        Student current = studentList.get(position);

        //set the current student info into the view components
        name.setText(current.getName());
        training.setText(current.getName());
        shool.setText(current.getShool());
        age.setText(current.getAge()+" years old");

        Picasso.with(ctx).load(current.getUrlPhoot()).into(photo);
        return v;
    }
}
