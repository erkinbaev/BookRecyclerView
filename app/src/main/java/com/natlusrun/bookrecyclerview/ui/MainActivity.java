package com.natlusrun.bookrecyclerview.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.natlusrun.bookrecyclerview.R;
import com.natlusrun.bookrecyclerview.data.BookRepo;
import com.natlusrun.bookrecyclerview.data.model.Book;
import com.natlusrun.bookrecyclerview.data.model.BookInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookRvAdapter.ItemClickListener {

    private List<Book> books;
    private Context context;
    private RecyclerView recyclerView;


    private TextView mBookName, mBookPrice, mBookDesc;
    //BookRvAdapter bookRvAdapter;
    //BookRepo bookRepo;

    /*ДЗ
    1. Список книг с возможностью просмотра подробной информации о каждой книге.
    Как это должно выглядеть
    На главном экране RecyclerView со списком книг. Один элемент списка должен содержать как минимум название книги
    (по желанию можете добавить картинку или год выпуска).
    По нажатию на книгу открывается новый экран с более подробной информацией о книге.
    Как минимум должно быть краткое описание (по желанию можете добавить больше информации автора, персонажей и т.д.)
    Обязательно делите на слои как на уроке! Не будет правильного деления на слои, домашку не приму!
    2. Доделать пример с авторизацией.
    Как это должно выглядеть
    Добавить кнопку log out на экране с именем пользователя. При нажатии на кнопку открывается MainActivity
    а все SharedPreferences стираются.
    (доп) Пропишите хардкодом имя пользователя и пароль на уровне данных.
    И при авторизации берите данные оттуда и сверяйте с тем что ввел пользователь. Если данные ошибочны,
    то выводите Toast о том что данные неверны.
    дедлайн - понедельник 21 сентября*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //books = BookRepo.getBookList();

        recyclerView = findViewById(R.id.book_rv);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(llm);

        books = new ArrayList<>();
        books = BookRepo.getBookList();
        //initBookData();
        initAdapter();
    }

    private void initAdapter() {
        BookRvAdapter adapter = new BookRvAdapter(books);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "You clicked " + position, Toast.LENGTH_SHORT).show();
        books.get(position);
        Intent intent = new Intent(this, BookInfoActivity.class);
        intent.putExtra(BookInfoActivity.KEY, books.get(position));
        startActivity(intent);
    }
}