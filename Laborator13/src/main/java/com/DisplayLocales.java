package com;

import java.util.Arrays;
import java.util.Locale;

public class DisplayLocales implements Command {
    @Override
    public String execute () {
        return Arrays.toString(Locale.getAvailableLocales());
    }
}
