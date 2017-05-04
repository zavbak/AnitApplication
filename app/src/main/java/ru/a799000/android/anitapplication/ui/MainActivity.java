package ru.a799000.android.anitapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.widget.RxTextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import ru.a799000.android.anitapplication.R;
import ru.a799000.android.anitapplication.app.ApplicationAnit;
import ru.a799000.android.anitapplication.repository.net.intities.ResponseModelDataService;
import ru.a799000.android.anitapplication.repository.net.intities.SendModelDataService;
import ru.a799000.android.anitapplication.repository.net.auth.AutoritationManager;
import ru.a799000.android.anitapplication.repository.net.interfaceapi.ApiService;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observers.Observers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    ApiService mTestApiService;
    TextView tvHello;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText name = (EditText) findViewById(R.id.editTextSearch);

        tvHello = (TextView) findViewById(R.id.tvHello);
        mTestApiService = ApplicationAnit.getAppComponent().getTestApiService();


        Observable<ResponseModelDataService> testModelReplayDataObservable =
                getResponseModelDataServiceObservableAct("100");


        Subscription editTextSub =
                RxTextView.textChanges(name)
                        .debounce(100, TimeUnit.MILLISECONDS)
                        .map(CharSequence::toString)
                        .filter(s -> s.length()>2)
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(Schedulers.io())
                        .switchMap(s -> getResponseModelDataServiceObservableAct(s))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(responseModelDataService -> showText("ответ" + responseModelDataService.toString())
                                ,throwable ->showText("error" + throwable.getMessage()));

    }


    Observable<ResponseModelDataService> getResponseModelDataServiceObservableAct(String filterName){
        final SendModelDataService testModelSendData = new SendModelDataService();
        testModelSendData.setCommand("command_contractors");

        JSONObject dataJson = new JSONObject();
        String dataString = null;
        try {
            dataJson.put("offset",1);
            dataJson.put("page_size",100);
            dataJson.put("filter_name",filterName);
            dataString = dataJson.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        testModelSendData.setStrDataIn(dataString);

        final String aut = AutoritationManager.getStringAutorization("Admin", "123");

        return mTestApiService.getResponseModelDataServiceObservable(aut,testModelSendData);
    }

    public void showText(String s) {
        tvHello.setText("" + s);
    }


}
