package com.isil.am2template.fragments;

/**
 * Created by emedinaa on 15/09/17.
 */

public interface ColorFragmentListener {

    void selectedColor(String color);

    void selectedOptionColor(int option);

    boolean isProfileEnabled();

    void clear();
}
