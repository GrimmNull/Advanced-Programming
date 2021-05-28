package com;

import java.util.Locale;

public class SetLocale implements Command {
    Locale locale;

    public SetLocale (String localeName) {
        String[] splitLocale = localeName.split("_");
        this.locale = new Locale(splitLocale[0], splitLocale[1]);
    }

    @Override
    public String execute () {
        Locale.setDefault(locale);
        return locale.toString();
    }
}
