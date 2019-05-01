package com.example.chattingapp.Fragments;

import com.example.chattingapp.Notifications.MyResponse;
import com.example.chattingapp.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAa1DWFQA:APA91bHV0eyVg6GrTF7_QJvQ0vpFyLsahBWkppdTrvVXUrfZ2m48aSwR8GiFRONbqAK2Oa7cEYSAOcE2NsqD2y6Bxg2P1r1AwDQFIXPfriLIA9HcNeOH43VZypCE9QWJq4usO5i0uQxu"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
