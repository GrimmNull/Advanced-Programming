package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.util.*;

public class LocaleExplore {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        ResourceBundle messages;

        while (true) {
            messages = ResourceBundle.getBundle("Messages", Locale.getDefault());
            System.out.print(messages.getString("prompt"));
            String command = scanner.nextLine();
            String[] splitCommand = command.split(" ");
            switch (splitCommand[0]) {
                case "locales" -> System.out.println(new DisplayLocales().execute());
                case "locale.set" -> {
                    new SetLocale(splitCommand[1]).execute();
                    System.out.println(MessageFormat.format(messages.getString("locale.set"), Locale.getDefault()));
                }
                case "info" -> new Info().execute();
                default -> System.out.println(messages.getString("invalid"));
            }
        }
    }
}
