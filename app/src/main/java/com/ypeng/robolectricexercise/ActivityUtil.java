package com.ypeng.robolectricexercise;

import android.content.Context;
import android.content.Intent;

/**
 * Created by YHoP on 1/7/16.
 */
public class ActivityUtil {
    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startWelcomeActivity() {
        context.startActivity(new Intent(context, WelcomeActivity.class));
    }
}
