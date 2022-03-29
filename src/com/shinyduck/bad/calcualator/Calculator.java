package com.shinyduck.bad.calcualator;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Calculator implements ActionListener {
    JFrame frame;
    JLabel main_text = new JLabel();
    List<Integer> values = new ArrayList<Integer>();
    List<String> operators = new ArrayList<>();
    String value = "";

    /**
        This will initialize the calculator and tun it. It is made as a class so it may scale better
     **/
    public Calculator() {
        frame = new JFrame("A VERY GOOD CALCULATOR \uD83D\uDE00\t");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        init(frame);
        frame.setLayout(null);

        frame.setVisible(true);
    }

    private void init(@NotNull JFrame frame) {
        int width = 40;
        int height = 40;

        main_text.setBounds(170, 25, 100, 50);
        JButton one = new JButton("1");
        one.setBounds(100, 100, 40, 40);
        JButton two = new JButton("2");
        two.setBounds(160, 95, one.getWidth(), one.getHeight());
        JButton three = new JButton("3");
        three.setBounds(220, 100, width, height);
        JButton times = new JButton("X");
        times.setBounds(280, 105, width+5, height+5);
        JButton four = new JButton("4");
        four.setBounds(100, 160, width, height);
        JButton five = new JButton("5");
        five.setBounds(160, 160, width, height);
        JButton six = new JButton("6");
        six.setBounds(220, 160, width, height);
        JButton minus = new JButton("-");
        minus.setBounds(275, 160, width, height);
        JButton seven = new JButton("7");
        seven.setBounds(100, 220, width, height);
        JButton eight = new JButton("8");
        eight.setBounds(160, 220, width, height);
        JButton nine = new JButton("9");
        nine.setBounds(220, 220, width, height);
        JButton add = new JButton("+");
        add.setBounds(300, 230, width+7, height+2);
        JButton divide = new JButton("÷");
        divide.setBounds(eight.getX(), eight.getY()+60, width, height);
        JButton equal = new JButton("=");
        equal.setBounds(add.getX()-20, add.getY()+60, width+10, height+2);
        JButton zero = new JButton("0");
        zero.setBounds(0, 200, width, height);

        frame.add(main_text);
        frame.add(one);
        frame.add(two);
        frame.add(three);
        frame.add(times);
        frame.add(four);
        frame.add(five);
        frame.add(six);
        frame.add(minus);
        frame.add(seven);
        frame.add(eight);
        frame.add(nine);
        frame.add(add);
        frame.add(divide);
        frame.add(equal);
        frame.add(zero);

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        add.addActionListener(this);
        minus.addActionListener(this);
        divide.addActionListener(this);
        times.addActionListener(this);
        equal.addActionListener(this);
        zero.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String start = e.getActionCommand();
        String target = "";

        switch (start) {
            case "0":
                target = "0";
            case "1":
                target = "1";
                break;
            case "2":
                target = "2";
                break;
            case "3":
                target = "3";
                break;
            case "4":
                target = "4";
                break;
            case "5":
                target = "5";
                break;
            case "6":
                target = "6";
                break;
            case "7":
                target = "7";
                break;
            case "8":
                target = "8";
                break;
            case "9":
                target = "9";
                break;
            case "X":
                target = "X"; break;
            case "÷":
                target = "÷";
                break;
            case "+":
                target = "+";
                break;
            case "-":
                target = "-";
                break;
            case "=": target = "=";
        };

        try {
            int i = Integer.parseInt(target);

            main_text.setText(main_text.getText() + i);
            value = value + i;
        } catch (NumberFormatException n) {
            if (target.equals("=")) {
                Random r = new Random();

                main_text.setText(String.valueOf(r.nextInt()));
            }

            main_text.setText(main_text.getText() + target);

            operators.add(target);
            values.add(Integer.parseInt(value));
        }
    }
}
