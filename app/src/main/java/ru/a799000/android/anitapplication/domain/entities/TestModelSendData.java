package ru.a799000.android.anitapplication.domain.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex on 02.05.2017.
 */

public class TestModelSendData {

    @SerializedName("send_date_client")
    @Expose
    private String sendDateClient;

    public String getSendDateClient() {
        return sendDateClient;
    }

    public void setSendDateClient(String sendDateClient) {
        this.sendDateClient = sendDateClient;
    }

    @Override
    public String toString() {
        return "TestModelSendData{" +
                "sendDateClient='" + sendDateClient + '\'' +
                '}';
    }
}
