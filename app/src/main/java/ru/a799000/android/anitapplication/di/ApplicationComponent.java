package ru.a799000.android.anitapplication.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.a799000.android.anitapplication.repository.net.interfaceapi.TestApiService;


@Singleton
@Component(modules={ApplicationModule.class,NetworkingModule.class})
public interface ApplicationComponent {
    TestApiService getTestApiService();
}
