package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonBubbleSort = findViewById(R.id.bubble_sort);
        Button buttonQuickSort = findViewById(R.id.quick_sort);
        Button buttonInsertionSort = findViewById(R.id.insertion_sort);
        Button buttonBinarySearchRec = findViewById(R.id.binary_search_rec);
        Button buttonBinarySearch = findViewById(R.id.binary_search);
        TextView tv = findViewById(R.id.textView);
        buttonBubbleSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a[] = {10, 3, 2, 40, 22, 17};
                sorting ex = new sorting();
                tv.setText(ex.bubbleSort(a));
            }
        });

        buttonQuickSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a[] = {10, 3, 2, 40, 22, 17};
                sorting ex = new sorting();
                tv.setText("quick sort");
            }
        });

        buttonInsertionSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a[] = {10, 3, 2, 40, 22, 17};
                sorting ex = new sorting();
                tv.setText(ex.insertionSort(a));
            }
        });

        buttonBinarySearchRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a[] = {2,3, 10, 17,22,40};
                searching ex = new searching();
                String text = "true";
                if(ex.binary_search_rec(16,a,0,a.length-1))
                    text = "false";
                tv.setText(text);
                if(!ex.binary_search_rec(22,a,0,a.length-1))
                    text = "false";
                tv.setText(text);
                if(ex.binary_search_rec(30,a,0,a.length-1))
                    text = "false";
                tv.setText(text);
                if(ex.binary_search_rec(50,a,0,a.length-1))
                    text = "false";
                tv.setText(text);
            }
        });

        buttonBinarySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a[] = {2,3, 10, 17,22,40};
                searching ex = new searching();
                String text = "true";
                if(ex.binary_search_rec(16,a,0,a.length-1))
                    text = "false";
                tv.setText(text);
                if(!ex.binary_search_rec(22,a,0,a.length-1))
                    text = "false";
                tv.setText(text);
                if(ex.binary_search_rec(30,a,0,a.length-1))
                    text = "false";
                tv.setText(text);
                if(ex.binary_search_rec(50,a,0,a.length-1))
                    text = "false";
                tv.setText(text);
            }
        });
    }
}