package com.edu.stu.mvpdemo.service;


import com.edu.stu.mvpdemo.view.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Dingyun on 2018/3/21.
 */

public interface RetrofitService {
    @GET("book/search")
    Observable<Book> getSearchBooks(
            @Query("q")String name,
            @Query("tag")String tag,
            @Query("start") int start,
            @Query("count") int count);

}
