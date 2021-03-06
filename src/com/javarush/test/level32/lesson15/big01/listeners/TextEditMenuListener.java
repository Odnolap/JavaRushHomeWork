package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by Odnolap on 16.07.2016.
 */
public class TextEditMenuListener implements MenuListener {

    private View view;

    public TextEditMenuListener(View view){
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        JMenu menu = (JMenu)e.getSource();
        for (Component c : menu.getMenuComponents()) {
            c.setEnabled(isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
    public boolean isHtmlTabSelected() {
        return view.isHtmlTabSelected();
    }
}
