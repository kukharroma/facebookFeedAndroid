package com.cooksdev.facebookfeedandroid.presentation.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by roma on 09.09.16.
 */
public class DateFormatter {

    private static final String DATE_FORMAT = "dd MMM yyyy HH:mm";

    public static String convertDate(Date date) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(date);
    }
}
