package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Screen;

    private Button AC, Addition, Subtract, Multiply, Division, Back, Equals, Squareroot, Decimal_point,
            Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Power ;
    private String input, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen = findViewById(R.id.screen);
        AC = findViewById(R.id.ac);
        Addition = findViewById(R.id.addition);
        Subtract = findViewById(R.id.subtraction);
        Multiply = findViewById(R.id.multiply);
        Division = findViewById(R.id.division);
        Back = findViewById(R.id.go_back);
        Equals = findViewById(R.id.equals);
        Squareroot= findViewById(R.id.squareroot);
        Decimal_point = findViewById(R.id.decimal);
        Zero = findViewById(R.id.zero);
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);
        Power = findViewById(R.id.power);

    }

    public void buttonClick(View view) {


        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data) {

            case "AC":
                input="";
                break;
            case "x":
                Solve();
                input+="*";
                break;

            case "^":
                Solve();
                input+="^";
                break;
            case "√":
                Solve();
                input+="√";
                break;
            case "←":
                String newInput = input.substring(0, input.length() - 1);
                input = newInput;
                break;
            case "=":
                Solve();
                answer=input;
                break;

            default:
                if (input == null) {
                    input ="";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")) {
                    Solve();
                }
                input+=data;
        }

        Screen.setText(input);
    }

    private void Solve() {

        if (input.split("\\*").length == 2) {
            String[] number = input.split("\\*");
            try {
                double multiplication = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input=multiplication+"";
            } catch (Exception e) {
                //
            }
        } else if (input.split("/").length == 2) {
            String[] number = input.split("/");
            try {
                double division = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input=division+"";
            } catch (Exception e) {
                //
            }

        }
        else if (input.split("\\^").length == 2) {
            String[] number = input.split("\\^");
            try {
                double power =Math.pow(Double.parseDouble(number[0]) ,Double.parseDouble(number[1]));
                input=power+"";
            } catch (Exception e) {
                //toggle error
            }
        }else if (input.split("√").length == 2) {
            String[] number = input.split("√");
            try {
                double squareRoot =Double.parseDouble(number[0])*Math.sqrt(Double.parseDouble(number[1]));
                input=squareRoot+"";
            } catch (Exception e) {
                //toggle error
            }
        }else if (input.split("\\+").length == 2) {

            String[] number = input.split("\\+");
            try {
                double addition =Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input = addition+"";
            } catch (Exception e) {
                //toggle error
            }
        }else if (input.split("-").length == 2) {
            String[] number = input.split("-");

            //to subtract from negative number like -5-8
            if(number[0].equals("") && number.length==2){
                number[0]=0+"";
            }
            try {
                double subtraction=0;
                if(number.length==2) {
                    subtraction = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                } else if(number.length==3){
                    subtraction=-Double.parseDouble(number[1])-Double.parseDouble(number[0]);
                }
                input= subtraction+"";
            } catch (Exception e) {
                //toggle error
            }
        }

        //to remove the last digit .0 from integer result

        String[] n =input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }

        }
        Screen.setText(input);
    }
}

