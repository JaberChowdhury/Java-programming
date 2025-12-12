package com.example.practise;

import javafx.scene.control.Button;

public class MyButton {

    Button render(String title){
        Button b = new Button(title);
        b.resize(120,120);
        return b;
    }
}
