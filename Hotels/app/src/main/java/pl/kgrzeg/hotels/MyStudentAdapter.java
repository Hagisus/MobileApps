package pl.kgrzeg.hotels;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

class MyStudentAdapter extends ArrayAdapter<Hotel>{
    Context ctx;
    int layoutTemplate;
    List<Hotel> hotelList;

    public MyStudentAdapter(@NonNull Context context, int resource, @NonNull List<Hotel> objects) {
        super(context, resource, objects);

        ctx = context;
        layoutTemplate = resource;
        hotelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        ImageView photo = v.findViewById(R.id.ivPhoto);
        TextView name = v.findViewById(R.id.tvName);
        TextView price = v.findViewById(R.id.tvPrice);
        TextView nprice = v.findViewById(R.id.tvNightlyPrice);
        TextView offer = v.findViewById(R.id.tvOffer);
        TextView distance = v.findViewById(R.id.tvDistance);
        TextView rating = v.findViewById(R.id.tvRating);
        RatingBar ratingbar = v.findViewById(R.id.ratingBar);

        Hotel current = hotelList.get(position);

        Picasso.with(ctx).load(current.getUrlPhoto()).into(photo);
        photo.setAdjustViewBounds(true);

        name.setText(current.getName());
        price.setText(String.valueOf(current.getPrice()));
        nprice.setText(String.valueOf(current.getNightlyPrice()));
        offer.setText(current.getLocalOffer());
        distance.setText(String.valueOf(current.getDistance())+" mi");
        rating.setText(String.valueOf(current.getRating()));
        ratingbar.setRating(current.getRating());

        return v;
    }
}
