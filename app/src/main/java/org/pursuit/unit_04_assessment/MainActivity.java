package org.pursuit.unit_04_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.pursuit.unit_04_assessment.controller.EchinodermAdapter;
import org.pursuit.unit_04_assessment.models.Message;
import org.pursuit.unit_04_assessment.models.MessageResponse;
import org.pursuit.unit_04_assessment.network.MessageService;
import org.pursuit.unit_04_assessment.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView echinodermRecyclerView;
    private Retrofit retrofit;
    private MessageService myMessageService;
    private EchinodermAdapter myEchinodermAdapter;
    private List<Message> messageList = new ArrayList<>();

    private static final String TAG = "My Response Error";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRecycleView();
        getMessage();


    }


    public void setUpRecycleView() {
        echinodermRecyclerView = findViewById(R.id.echinoderm_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        echinodermRecyclerView.setLayoutManager(layoutManager);
        myEchinodermAdapter = new EchinodermAdapter(messageList);
        echinodermRecyclerView.setAdapter(myEchinodermAdapter);

    }

    public void getMessage(){
        retrofit = RetrofitSingleton.ourInstance();
        myMessageService = retrofit.create(MessageService.class);
        final Call<MessageResponse> message = myMessageService.getMessage();
        message.enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                Log.d(TAG , "OnResponse " + response.body().getMessage().get(0).getAnimal());
                messageList.addAll(response.body().getMessage());
                myEchinodermAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Log.d(TAG , "OnResponse " + t.getMessage());

            }
        });




    }


}
