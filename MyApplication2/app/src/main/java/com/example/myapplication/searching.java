package com.example.myapplication;

public class searching {

    public boolean binary_search_rec(int d, int a[], int start, int end) {
        //traverse
        int step = (end-start)/2;
        int median = start + step;

        if (a[median] == d)
            return true;
        if (start != end) {
            //rec left
            if (a[median] < d)
                return binary_search_rec(d, a, median+1, end);
            //rec right
            if (a[median] > d)
                return binary_search_rec(d, a, start, median - 1);
        }

        return false;




    }





    public boolean binary_search(int d, int a[]) {

        int len = a.length;
        int start = 0;
        int end = len - 1;

        boolean found = false;

        while (start != end) {
            //traverse
            int step = (end - start) / 2;
            int median = start + step;

            if (a[median] == d) {
                found = true;
                break;
            }
            if (start == end)
                break;
            //left bound
            if(a[median] > d) {

                end = median - 1;
            }
            //right bound
            if (a[median] < d) {
                start = median + 1;
            }


        }

        return found;


    }
}
