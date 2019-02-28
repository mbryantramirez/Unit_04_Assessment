package org.pursuit.unit_04_assessment.network;

import org.pursuit.unit_04_assessment.models.Message;
import org.pursuit.unit_04_assessment.models.MessageResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageService {
    @GET("JDVila/storybook/master/echinoderms.json")
    Call<MessageResponse>getMessage();
}
