package app.ntnt.finalprojectexamonline.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.ntnt.finalprojectexamonline.R;


public class AccountFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //view= inflater.inflate(R.layout.fragment_account, container, false);
        view= inflater.inflate(R.layout.activity_account, container, false);
        return view;
    }
}