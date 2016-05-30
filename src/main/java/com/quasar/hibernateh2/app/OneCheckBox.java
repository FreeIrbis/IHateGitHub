/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.hibernateh2.app;

import javafx.scene.control.CheckBox;

/**
 *
 * @author Irbis
 */
public class OneCheckBox {

    public static Long SelectOneCheckBox(CheckBox chk1, CheckBox chk2) {
        Long check = null;
        if (chk1.isSelected()) {
            check = 1L;
        }
        if (chk2.isSelected()) {
            check = 2L;
        }
        return check;
    }

    public static void ChekedOneCheckBox(CheckBox chk1, CheckBox chk2) {
        if (chk1.isFocused()) {
            chk1.setSelected(true);
            chk2.setSelected(false);
        } else {
            chk2.setSelected(true);
            chk1.setSelected(false);
        }
    }
}
