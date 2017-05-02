package ru.a799000.android.anitapplication.repository.net.interfaceapi;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.a799000.android.anitapplication.domain.entities.TestModelReplayData;
import ru.a799000.android.anitapplication.domain.entities.TestModelSendData;
import rx.Observable;

/**
 * Created by Alex on 20.04.2017.
 */

public interface TestApiService {
    @POST("/DB/hs/api/")
    Observable<TestModelReplayData> getTestConnectionObservable(@Header("Authorization") String credentials,
                                                                @Body TestModelSendData testConnectionSendData);


}
