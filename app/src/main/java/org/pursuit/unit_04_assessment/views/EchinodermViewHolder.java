package org.pursuit.unit_04_assessment.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_04_assessment.R;
import org.pursuit.unit_04_assessment.fragment.DetailFragment;
import org.pursuit.unit_04_assessment.models.Message;

public class EchinodermViewHolder extends RecyclerView.ViewHolder {
    private ImageView animalImageView;
    private TextView animalTextView, wikiTextView;
    private DetailFragment.OnFragmentInteractionListener onFragmentInteractionListener;

    public EchinodermViewHolder(@NonNull View itemView) {
        super(itemView);
        setViews();
        if (itemView.getContext() instanceof DetailFragment.OnFragmentInteractionListener) {
            onFragmentInteractionListener  = (DetailFragment.OnFragmentInteractionListener) itemView.getContext() ;


        } else {
            throw new RuntimeException(itemView.getContext().toString() + " Hey implement DetailFragment.OnFragmentInteractionListener!");
        }
    }


    public void onBind(Message message) {
        animalTextView.setText(message.getAnimal());
        wikiTextView.setText(message.getWiki());
        Picasso.get().load(message.getImage()).into(animalImageView);
        final String animalName = message.getAnimal();
        final String website = message.getWiki();
        final String image = message.getImage();
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onFragmentInteractionListener.onFragmentInteraction(website, animalName, image);

            }
        });
    }


    public void setViews() {
        animalTextView = itemView.findViewById(R.id.animal_textview);
        wikiTextView = itemView.findViewById(R.id.wiki_textview);
        animalImageView = itemView.findViewById(R.id.animal_imageview);


    }
}
