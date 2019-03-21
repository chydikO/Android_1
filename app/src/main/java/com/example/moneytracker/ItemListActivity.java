package com.example.moneytracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ArrayList<Record> mData = new ArrayList<>();
    private static final String TAG = "Log:";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

         createDate();

        mRecycleView = findViewById(R.id.list);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this ));
        mRecycleView.setAdapter(new ItemListAdapter());
        //адаптер - это инструмент связи данных с визуальным представлением 1:41
    }

    private void createDate() {
        mData.add(new Record("Молоко", 35));
        mData.add(new Record("Жизнь", 1));
        mData.add(new Record("Курсы", 50));
        mData.add(new Record("Хлеб", 26));
        mData.add(new Record("Тот самый ужин который я оплатил за всех потому что платил картой", 600000));
        mData.add(new Record("", 0));
        mData.add(new Record("Тот самый ужин", 604));
        mData.add(new Record("ракета Falcon Heavy", 1));
        mData.add(new Record("Лего Тысячелетний сокол", 100000000));
        mData.add(new Record("Монитор", 100));
        mData.add(new Record("MacBook Pro", 100));
        mData.add(new Record("Шоколадка", 100));
        mData.add(new Record("Шкаф", 100));
        mData.add(new Record("Молоко", 35));
        mData.add(new Record("Жизнь", 1));
        mData.add(new Record("Курсы", 50));
    }

    class ItemListAdapter extends RecyclerView.Adapter<RecordViewHolder> {
        @NonNull
        @Override
        public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            Log.d(TAG, "onCreateViewHolder " + mRecycleView.getChildCount());
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_record, viewGroup, false);
            return new RecordViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecordViewHolder viewHolder, int i) {
            Record record = mData.get(i);
            viewHolder.applyData(record);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    private class RecordViewHolder extends RecyclerView.ViewHolder {
        private final TextView price;
        private final TextView title;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Record record) {
            title.setText(record.getTitle());
            price.setText(String.valueOf(record.getPrice()));
        }
    }
}
