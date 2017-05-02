package ru.a799000.android.anitapplication.domain.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Replay Auth
 */

public class TestModelReplayData {
    @SerializedName("send_date_client")
    @Expose
    private String sendDateClient;
    @SerializedName("received_date_server")
    @Expose
    private String receivedDateServer;
    @SerializedName("date_replay_date_server")
    @Expose
    private String dateReplayDateServer;
    @SerializedName("success_server")
    @Expose
    private Boolean successServer;
    @SerializedName("error_mess_server")
    @Expose
    private String errorMessServer;

    public String getSendDateClient() {
        return sendDateClient;
    }

    public void setSendDateClient(String sendDateClient) {
        this.sendDateClient = sendDateClient;
    }

    public String getReceivedDateServer() {
        return receivedDateServer;
    }

    public void setReceivedDateServer(String receivedDateServer) {
        this.receivedDateServer = receivedDateServer;
    }

    public String getDateReplayDateServer() {
        return dateReplayDateServer;
    }

    public void setDateReplayDateServer(String dateReplayDateServer) {
        this.dateReplayDateServer = dateReplayDateServer;
    }

    public Boolean getSuccessServer() {
        return successServer;
    }

    public void setSuccessServer(Boolean successServer) {
        this.successServer = successServer;
    }

    public String getErrorMessServer() {
        return errorMessServer;
    }

    public void setErrorMessServer(String errorMessServer) {
        this.errorMessServer = errorMessServer;
    }

}
