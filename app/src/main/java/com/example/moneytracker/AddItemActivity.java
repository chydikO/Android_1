package com.example.moneytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * ДЗ №2
 *  Делаем плюсик активным только когда оба поля не пустые.
 *  Делаем так чтобы символ валюты всегда был на экране.
 */

public class AddItemActivity extends AppCompatActivity {

    //logt + tab
    private static final String TAG = "AddItemActivity";

    private EditText name;
    private EditText price;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //setTitle(R.string.add_item_title);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        addButton = findViewById(R.id.addButon);

        final TextWatcher watcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addButton.setEnabled(!TextUtils.isEmpty(name.getText())
                        && !TextUtils.isEmpty(price.getText()));
                if (price.getId() == R.id.price){
                    Log.i(TAG, "afterTextChanged: " + s);

                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) {
                //price.setText(s + "₴");
            }
        };

        name.addTextChangedListener(watcher);
        price.addTextChangedListener(watcher);
/*
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //logi + tab
                Log.i(TAG, "afterTextChanged: " + s);

                //если поле name не пустое, активировать кнопку +
                addButton.setEnabled(!TextUtils.isEmpty(s));
            }
        });
*/
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String itemName = name.getText().toString();
            String itemPrice = name.getText().toString();
            }
        });
    }
}
