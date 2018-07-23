package com.alex.app_clean.post.view;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alex.app_clean.R;
import com.alex.app_clean.adapter.PictureAdapterRecyclerView;
import com.alex.app_clean.model.Picture;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final int REQUEST_CAMERA = 1;
    private RecyclerView rv;
    private List<Picture> pictures;
    private PictureAdapterRecyclerView rvAdapter;
    private FloatingActionButton fabCamera;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Home ",false,view);

        rv =view.findViewById(R.id.pictureRecycler);
        fabCamera=view.findViewById(R.id.fabCamera);

        LinearLayoutManager linearLayoutM = new LinearLayoutManager(getContext());
        linearLayoutM.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutM);
        //       FireArranque();
        pictures=new ArrayList<>();

        rvAdapter = new PictureAdapterRecyclerView(todoslosdatos(),R.layout.cardview_item,getActivity());
        rv.setAdapter(rvAdapter);


        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });


//        mDataReference.child("datos").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if(pictures.size()>0);
//                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
//                    Picture picture = postSnapshot.getValue(Picture.class);
//                    pictures.add(picture);
//                }
//                rvAdapter  = new PictureAdapterRecyclerView(pictures, R.layout.cardview_item, getActivity());
//                rv.setAdapter(rvAdapter);
//
//                rvAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });



        return view;
    }

    private void takePicture() {

        Intent intentTakePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intentTakePicture.resolveActivity(getActivity().getPackageManager())!= null){
        startActivityForResult(intentTakePicture,REQUEST_CAMERA);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CAMERA && resultCode == getActivity().RESULT_OK){
            Log.d("HomeFragment","CAMERA OK!! :3");
        }
    }

    //    private void FireArranque(){
//        FirebaseApp.initializeApp(this.getContext());
//        mDataBase = FirebaseDatabase.getInstance();
//        mDataReference= mDataBase.getReference("tutorial");
//    }


    private List<Picture>todoslosdatos(){

        return new ArrayList<Picture>(){{
            add(new Picture("200","https://www.riu.com/fcs_images/guia-destinos/guia_MX_13792_2x1.jpg","4 dias","Alexander Ramirez"));
            add(new Picture("12","https://www.caf.com/media/7960612/ciudades-con-futuro-p-sec.jpg","8 dias","jose barreto"));
            add(new Picture("72","http://coratierras.org/wp-content/uploads/2017/07/bosques-hermosos-1.jpg","19 dias","paola morales"));
            add(new Picture("44","https://www.cortinas.es/media/custom/Paisajes-Monta%C3%B1as-03.jpg","19 dias","paola morales"));
            add(new Picture("17","http://1.bp.blogspot.com/_oW3fxNnIpJ8/TQOz1Kpa6XI/AAAAAAAAPSs/awkq7MhRMs0/s1600/5.jpg","56 dias","carlos noriega"));

        }};
    }


    private void showToolbar(String tittle,Boolean upButton,View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }


}
