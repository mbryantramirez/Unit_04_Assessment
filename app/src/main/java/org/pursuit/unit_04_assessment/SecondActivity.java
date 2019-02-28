package org.pursuit.unit_04_assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.pursuit.unit_04_assessment.fragment.DetailFragment;

public class SecondActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {

    private final String WEB_KEY = "Start Web";
    private final String ANIMAL_IMAGE = "My animal Image";
    private final String ANIMAL_NAME ="My animal name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        DetailFragment detailFragment = new DetailFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.secondactivity_container, detailFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String website ,String animal,String image) {

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra(WEB_KEY, website)
                .putExtra(ANIMAL_IMAGE,image)
                .putExtra(ANIMAL_NAME,animal);
        startActivity(intent);

    }
}
