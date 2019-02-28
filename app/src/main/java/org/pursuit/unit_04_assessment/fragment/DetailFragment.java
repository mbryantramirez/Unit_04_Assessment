package org.pursuit.unit_04_assessment.fragment;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_04_assessment.R;


public class DetailFragment extends Fragment {

    private static final String ANIMAL_IMAGE = "My animal Image";
    private static final String ANIMAL_NAME = "My animal name";
    private static final String WEB_KEY = "Start Web";


    private TextView fragNameTextView;
    private ImageView fragDisplayImageView;
    private Button fragGetWikiButton;
    private String myWebAddress;
    private String animalName;
    private String animalImage;


    public static DetailFragment newInstance(String name, String image, String website) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ANIMAL_NAME, name);
        args.putString(ANIMAL_IMAGE, image);
        args.putString(WEB_KEY, website);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            animalName = getArguments().getString(ANIMAL_NAME);
            animalImage = getArguments().getString(ANIMAL_IMAGE);
            myWebAddress = getArguments().getString(WEB_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView(view);
        fragNameTextView.setText(animalName);
        Picasso.get().load(animalImage).into(fragDisplayImageView);
        fragGetWikiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(myWebAddress));
                startActivity(intent);


            }
        });
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String website, String animal, String image);


    }

    public void setView(View v) {

        fragNameTextView = v.findViewById(R.id.detailfrag_animaltextview);
        fragDisplayImageView = v.findViewById(R.id.detailfrag_imageview);
        fragGetWikiButton = v.findViewById(R.id.detailfrag_button);


    }

}
