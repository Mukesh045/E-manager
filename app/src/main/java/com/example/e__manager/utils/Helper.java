package com.example.e__manager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    public static String formateDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
        return dateFormat.format(date);
    }


}
