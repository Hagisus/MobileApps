package pl.kgrzeg.navigationdrawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AwariaItemFragment extends Fragment {
    private int mColumnCount = 1;
    private List<AwariaItem> awariaItemList;

    public AwariaItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        awariaItemList = new ArrayList<>();
        awariaItemList.add(new AwariaItem(
                "Stłuczone lusterko",
                "Uszkodziłem lusterku cofając do przodu w dynamicznym korku",
                "Fiat Multipla",
                "http://www.diamondglassandleadlights.com.au/wp-content/uploads/2014/09/car-side-mirror2.jpg" ));
        awariaItemList.add(new AwariaItem(
                "Wgniecona maska",
                "Lekko stuknięte autko, drzewo wzięło się z nikąd >.<",
                "BMW 3",
                "http://www.rgbstock.com/cache1nt0Tt/users/j/ja/jaz1111/300/dMG8Wo.jpg" ));
        awariaItemList.add(new AwariaItem(
                "Uszkodzona lampa",
                "Delikatnie uszkodzony prawy przedni reflektor. Wyklepie się.",
                "Czerwone auto",
                "https://www.ramysgarage.com/wp-content/uploads/2013/02/car-broken-headlights.png" ));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_awariaitem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyAwariaItemRecyclerViewAdapter(getActivity(),awariaItemList));
        }
        return view;
    }
}
