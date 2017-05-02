package ru.a799000.android.anitapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

import ru.a799000.android.anitapplication.R;
import ru.a799000.android.anitapplication.app.ApplicationAnit;
import ru.a799000.android.anitapplication.domain.entities.TestModelReplayData;
import ru.a799000.android.anitapplication.domain.entities.TestModelSendData;
import ru.a799000.android.anitapplication.repository.net.auth.AutoritationManager;
import ru.a799000.android.anitapplication.repository.net.interfaceapi.TestApiService;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TestApiService mTestApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTestApiService = ApplicationAnit.getAppComponent().getTestApiService();

        final TestModelSendData testModelSendData = new TestModelSendData();
        testModelSendData.setSendDateClient("" + new Date());

        final String aut = AutoritationManager.getStringAutorization("Admin", "123");

        Observable<TestModelReplayData> testModelReplayDataObservable = mTestApiService.getTestConnectionObservable(aut,testModelSendData);

        testModelReplayDataObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(testModelReplayData -> Toast.makeText(MainActivity.this,
                        testModelReplayData.getReceivedDateServer(), Toast.LENGTH_SHORT).show());




    }
}
