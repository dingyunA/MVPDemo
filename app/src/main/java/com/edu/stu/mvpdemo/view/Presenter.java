package com.edu.stu.mvpdemo.view;

import android.content.Intent;

/**
 * Created by Dingyun on 2018/3/21.
 */

public interface Presenter {
    void onCreate();

    void onStart();//暂时没用到

    void onStop();

    void pause();//暂时没用到

    void attachView(View view);

    void attachIncomingIntent(Intent intent);//暂时没用到
}
