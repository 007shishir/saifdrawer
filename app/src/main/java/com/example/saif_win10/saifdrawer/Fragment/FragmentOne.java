package com.example.saif_win10.saifdrawer.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saif_win10.saifdrawer.PartOneFragment.PartOneChapter01;
import com.example.saif_win10.saifdrawer.R;


public class FragmentOne extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmen_part1, container, false);

        Button btn1 = (Button) v.findViewById(R.id.btn01);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new PartOneChapter01());
                fr.commit();
            }
        });

        return v;
    }


}
