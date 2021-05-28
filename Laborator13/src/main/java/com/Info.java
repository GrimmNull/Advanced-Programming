package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.util.*;

public class Info implements Command {
    Locale locale;

    public Info () {}

    public Info (String localeName) {
        this.locale = new Locale(localeName);
    }

    @Override
    public String execute () {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle messages= ResourceBundle.getBundle("Messages", Locale.getDefault());
        System.out.println(messages.getString("country") +":" + currentLocale.getDisplayCountry());
        System.out.println(messages.getString("language") +":" + currentLocale.getDisplayLanguage());
        System.out.println(messages.getString("currency") +":" + Currency.getInstance(currentLocale));
        String[] weekDays = DateFormatSymbols.getInstance(currentLocale).getWeekdays();
        System.out.println(messages.getString("weekdays") +":" + String.join(", ", Arrays.copyOfRange(weekDays, 1, weekDays.length)));
        System.out.println(messages.getString("today") +":" + DateFormat.getDateInstance(DateFormat.FULL, currentLocale).format(new Date()));
        return Locale.getDefault().toString();
    }
}