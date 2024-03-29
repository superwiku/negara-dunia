package com.example.superwiku.countries;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

import java.text.NumberFormat;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailUmumFragment extends Fragment {

    TextView txtdtlnama,txtdtlibukota,txtdtlsubbenua,txtdtlluas,txtdtlpopulasi;
    ImageView imgdtlbendera;
    List<NegaraFull> negaraFulls;
    NegaraFull negaraFull;
    ApiInterface apiInterface;
    public static String KEY_ACTIVITY="msg_activity";


    public DetailUmumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detail_umum,container,false);
        txtdtlnama=view.findViewById(R.id.txt_dtlnama);
        txtdtlibukota=view.findViewById(R.id.txt_dtlibukota);
        txtdtlsubbenua=view.findViewById(R.id.txt_dtlsubbenua);
        txtdtlluas=view.findViewById(R.id.txt_dtlluas);
        txtdtlpopulasi=view.findViewById(R.id.txt_dtlpopulasi);
        imgdtlbendera=view.findViewById(R.id.img_dtlbendera);
        negaraFull= (NegaraFull) this.getArguments().getSerializable(KEY_ACTIVITY);

        if (negaraFull != null) {
            txtdtlnama.setText(negaraFull.getName());
            txtdtlibukota.setText(negaraFull.getCapital());
            txtdtlsubbenua.setText(negaraFull.getRegion());
            Long area=negaraFull.getArea();
            txtdtlluas.setText(NumberFormat.getNumberInstance().format(area) + " km2");
            Long popu=negaraFull.getPopulation();
            txtdtlpopulasi.setText(NumberFormat.getNumberInstance().format(popu) + " jiwa");
            SvgLoader.pluck().with(getActivity()).load(negaraFull.getFlag(),imgdtlbendera);
        }


//        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
//        Call<List<NegaraFull>> call7=apiInterface.getSatuNegara(getArguments);
//        call7.enqueue(new Callback<List<NegaraFull>>() {
//            @Override
//            public void onResponse(Call<List<NegaraFull>> call, Response<List<NegaraFull>> response) {
//                negaraFull=response.body();
//                txtdtlnama.setText(negaraFull.get(0).getName());
//                txtdtlibukota.setText(negaraFull.get(0).getCapital());
//                txtdtlsubbenua.setText(negaraFull.get(0).getRegion());
//                Long area=negaraFull.get(0).getArea();
//                txtdtlluas.setText(NumberFormat.getNumberInstance().format(area) + " km2");
//                Long popu=negaraFull.get(0).getPopulation();
//                txtdtlpopulasi.setText(NumberFormat.getNumberInstance().format(popu) + " jiwa");
//                SvgLoader.pluck().with(getActivity()).load(negaraFull.get(0).getFlag(),imgdtlbendera);
//                }
//
//            @Override
//            public void onFailure(Call<List<NegaraFull>> call, Throwable t) {
//
//            }
//        });
        // Inflate the layout for this fragment
        return view;


    }

}
