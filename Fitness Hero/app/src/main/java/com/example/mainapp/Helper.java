package com.example.mainapp;

import android.widget.EditText;

public class Helper {

        public static boolean isStringOnlyAlphabet(String str) {
            return ((str != null)
                    && (!str.equals(""))
                    && (str.matches("^[a-zA-Z]*$")));
        }
}
