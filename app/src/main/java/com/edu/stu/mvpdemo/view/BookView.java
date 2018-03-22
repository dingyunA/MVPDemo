package com.edu.stu.mvpdemo.view;

/**
 * Created by Dingyun on 2018/3/21.
 */

public interface BookView  extends View{
    void onSuccess(Book mBook);
    void onError(String result);
}
