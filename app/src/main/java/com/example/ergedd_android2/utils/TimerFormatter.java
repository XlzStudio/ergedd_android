package com.example.ergedd_android2.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class TimerFormatter {
    public static String formatterTime(int currentPosition){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        String format = simpleDateFormat.format(new Date(currentPosition + 0));
        return format;
    }
}
