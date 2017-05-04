package ru.a799000.android.anitapplication.flowcontroller;

import android.content.Context;
import android.content.Intent;

import ru.a799000.android.anitapplication.ui.MainActivity;

public class FlowController {

    public static void launchCatalogActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
