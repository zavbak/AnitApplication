package ru.a799000.android.anitapplication.repository.net.interfaceapi;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.a799000.android.anitapplication.repository.net.intities.ResponseModelDataService;
import ru.a799000.android.anitapplication.repository.net.intities.SendModelDataService;
import rx.Observable;

/**
 * Created by Alex on 20.04.2017.
 */

public interface ApiService {
    @POST("/anitapi/hs/api/")
    Observable<ResponseModelDataService> getResponseModelDataServiceObservable(
            @Header("Authorization") String credentials,
            @Body SendModelDataService testConnectionSendData);


}

