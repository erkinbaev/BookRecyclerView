package com.natlusrun.bookrecyclerview.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.natlusrun.bookrecyclerview.R;
import com.natlusrun.bookrecyclerview.data.model.Book;

import java.util.List;

public class BookRvAdapter extends RecyclerView.Adapter<BookRvAdapter.BookViewHolder> {

    List<Book> bookList;

    public  ItemClickListener listener;

    private Context mContext;

    public BookRvAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
//        holder.bookName.setText(bookList.get(position).getName());
//        holder.bookPrice.setText(bookList.get(position).getPrice());
        holder.onBind(bookList.get(position));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


    class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cv;
        TextView bookName;
        TextView bookPrice;
        TextView bookDesc;


        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.cv);
            bookName = itemView.findViewById(R.id.book_name_tv);
            bookPrice = itemView.findViewById(R.id.book_price_tv);
            //bookDesc = itemView.findViewById(R.id.book_desc_tv);

            //bookDesc.setVisibility(View.GONE);
            itemView.setOnClickListener(this);
        }

        public void onBind(Book book) {
            bookName.setText(book.getName());
            bookPrice.setText(book.getPrice());
            //bookDesc.setText(book.getDesc());
        }

        @Override
        public void onClick(View v) {
            if (listener != null) listener.onItemClick(getAdapterPosition());
        }
    }

    public void setOnClickListener(ItemClickListener mListener) {
        this.listener = mListener;
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }
}
