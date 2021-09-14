package com.idnan;

import com.idnan.charecterPrinter.CharecterPrinter;
import com.idnan.charecters.Mage;


public class Main {

    public static void main(String[] args) {
        Mage mage = new Mage("Bollo");
        new CharecterPrinter().displayStats(mage);
    }
}
