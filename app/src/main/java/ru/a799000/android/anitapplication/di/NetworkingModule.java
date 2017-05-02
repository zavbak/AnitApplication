package ru.a799000.android.anitapplication.di;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.a799000.android.anitapplication.repository.net.interfaceapi.TestApiService;


@Module
public class NetworkingModule {

    private final String mBaseUrl;

    public NetworkingModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    public Retrofit provideRestAdapter() {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }


    @Provides
    @Singleton
    public TestApiService provideCatalogAPIService(Retrofit retrofit) {
        return  retrofit.create(TestApiService.class);

    }
}
