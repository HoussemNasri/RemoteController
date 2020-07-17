package com.company.util;

import java.awt.event.KeyEvent;

public class KeyCodeUtils {
    /**
    * @param c Character to convert to an keycode
    * @return the keycode corresponding to the supplied charcter
    * */
    public static int keyCodeFromChar(char c){
        return KeyEvent.getExtendedKeyCodeForChar(c);
    }
}
