package rs.aleph.android.example12.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import rs.aleph.android.example12.R;

public class DetailFragment extends Fragment {

    private int position = 0;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onAttach()", Toast.LENGTH_SHORT).show();
    }
    // onCreate method is a life-cycle method that is called when creating the fragment.
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onCreate()", Toast.LENGTH_SHORT).show();

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }
    }
    // onCreateView method is a life-cycle method that is called  to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onCreateView()", Toast.LENGTH_SHORT).show();

        // Finds view in the view hierarchy and returns it.
        return inflater.inflate(R.layout.fragment_detail, container, false);
        //inflater.inflate(R.layout.fragment_detail, container, false);
    } //68 red
}
