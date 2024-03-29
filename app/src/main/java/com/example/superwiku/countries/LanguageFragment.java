package com.example.superwiku.countries;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageFragment extends Fragment {
    public static String KEY_ACTIVITY_2="msg_activity_2";
    List<Language> languageList;
    NegaraFull negaraFull;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView languagerecyclerView;
    LanguageAdapter languageAdapter;
    public LanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bahasa, container, false);
        languagerecyclerView=(RecyclerView)view.findViewById(R.id.rv_languages);
        negaraFull=(NegaraFull)this.getArguments().getSerializable(KEY_ACTIVITY_2);
        if (negaraFull != null){
            languageList=negaraFull.getLanguages();
            layoutManager=new LinearLayoutManager(getActivity());
            languagerecyclerView.setLayoutManager(layoutManager);
            languageAdapter=new LanguageAdapter(languageList,getActivity());
            languagerecyclerView.setAdapter(languageAdapter);
        }

        return view;
    }


}
