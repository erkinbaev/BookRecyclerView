package com.natlusrun.bookrecyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.natlusrun.bookrecyclerview.R;
import com.natlusrun.bookrecyclerview.data.BookInfoRepo;
import com.natlusrun.bookrecyclerview.data.model.Book;
import com.natlusrun.bookrecyclerview.data.model.BookInfo;

import java.util.List;

public class BookInfoActivity extends AppCompatActivity {

    private List<BookInfo> bookInfoList;

    private TextView book_name_tv;
    private TextView book_price_tv;
    private TextView book_desc_tv;
    private Button book_buy_btn;

    public static final String KEY = "BOOK_INFO_ACTIVITY";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        initViews();
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent() != null) {
            Book book = (Book) getIntent().getSerializableExtra(BookInfoActivity.KEY);
            book_name_tv.setText(book.getName());
            book_price_tv.setText(book.getPrice());
            book_desc_tv.setText(book.getDesc());
        }
    }

    private void initViews() {
        book_name_tv = findViewById(R.id.book_name_info_tv);
        book_price_tv = findViewById(R.id.book_info_price_tv);
        book_desc_tv = findViewById(R.id.book_info_desc_tv);
    }
}
