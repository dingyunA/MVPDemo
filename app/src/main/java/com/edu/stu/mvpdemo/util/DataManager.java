package com.edu.stu.mvpdemo.util;

import android.content.Context;

import com.edu.stu.mvpdemo.service.RetrofitService;
import com.edu.stu.mvpdemo.view.Book;

import rx.Observable;


/**
 * Created by Dingyun on 2018/3/21.
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }
    public Observable<Book> getSearchBooks(String name, String tag, int start, int count){
        return mRetrofitService.getSearchBooks(name,tag,start,count);
    }

}
