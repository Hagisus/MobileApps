package pl.kgrzeg.hotels;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Hotel> hotelList;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewHotels);

        hotelList = new ArrayList<>();
        hotelList.add(new Hotel("Grand Hotel Sopot", 4.5f, 499, 639, "Near sea", 8798.5f, "https://www.ahstatic.com/photos/3419_ho_00_p_2048x1536.jpg"));
        hotelList.add(new Hotel("inturjoven Hostel Sevilla", 3f, 199, 279, "We're living here!", 2.5f, "https://t-ec.bstatic.com/images/hotel/max1024x768/107/107697876.jpg"));
        hotelList.add(new Hotel("Grand Budapest Hotel", 1.4f, 249, 229, "I am film name!", 9.5f, "http://1.fwcdn.pl/ph/18/17/661817/474872_1.1.jpg"));

        MyStudentAdapter adapter = new MyStudentAdapter(
                this,
                R.layout.hotel_item,
                hotelList
        );


        lista.setAdapter(adapter);

    }
}
