package com.edu.stu.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.stu.mvpdemo.view.Book;
import com.edu.stu.mvpdemo.view.BookPresenter;
import com.edu.stu.mvpdemo.view.BookView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_txt;
    private Button bt_sub;

    private BookPresenter mBookPresenter = new BookPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_txt = findViewById(R.id.tv_txt);
        bt_sub = findViewById(R.id.bt_submit);

        bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mBookPresenter.getSearchBooks("金瓶梅", null, 0, 1);

            }
        });

        mBookPresenter.onCreate();
        mBookPresenter.attachView(mBookView);

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    private BookView mBookView = new BookView() {
        @Override
        public void onSuccess(Book mBook) {
            tv_txt.setText(mBook.toString());
        }

        @Override
        public void onError(String result) {
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.onStop();
    }
}
