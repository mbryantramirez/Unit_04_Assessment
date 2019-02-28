package org.pursuit.unit_04_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_04_assessment.R;
import org.pursuit.unit_04_assessment.models.Message;
import org.pursuit.unit_04_assessment.models.MessageResponse;
import org.pursuit.unit_04_assessment.views.EchinodermViewHolder;

import java.util.List;

public class EchinodermAdapter extends RecyclerView.Adapter <EchinodermViewHolder> {
    private View childView;
    private List <Message> messageList;

    public EchinodermAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public EchinodermViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.echinoderm_itemview_layout,viewGroup,false);
        return new EchinodermViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull EchinodermViewHolder echinodermViewHolder, int i) {

        Message message = messageList.get(i);
        echinodermViewHolder.onBind(message);




    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
