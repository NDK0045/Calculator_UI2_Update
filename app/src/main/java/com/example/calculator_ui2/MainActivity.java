package com.example.calculator_ui2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    double firstNum;
    double secondNum;
    String function;
    @Override
    protected void onCreate(Bundle savedInsatanceState) {

        super.onCreate(savedInsatanceState);
        setContentView(R.layout.activity_main);

        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);



        Button sin = findViewById(R.id.sin);
        Button cos = findViewById(R.id.cos);
        Button tan = findViewById(R.id.tan);
        Button cotan = findViewById(R.id.cotan);

        Button percent = findViewById(R.id.percent);
        Button one_dive_by_x = findViewById(R.id.one_dive_by_x);
        Button sqrt_x = findViewById(R.id.sqrt_x);
        Button x_pow_2 = findViewById(R.id.x_pow_2);

        Button delete = findViewById(R.id.delete);
        Button exit = findViewById(R.id.exit);
        Button C = findViewById(R.id.clear_all);

        Button devide = findViewById(R.id.devide);
        Button multily = findViewById(R.id.multiply);
        Button minus = findViewById(R.id.minus);
        Button plus = findViewById(R.id.plus);
        Button dot = findViewById(R.id.dot);
        Button equal = findViewById(R.id.equal);

        TextView screen = findViewById(R.id.screen);

        C.setOnClickListener(vire ->{
            firstNum=0;
            screen.setText("0");
        });

        exit.setOnClickListener(view->{
            finishAffinity();
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(zero);
        nums.add(one);
        nums.add(two);
        nums.add(three);
        nums.add(four);
        nums.add(five);
        nums.add(six);
        nums.add(seven);
        nums.add(eight);
        nums.add(nine);
        for(Button b :nums) {
            b.setOnClickListener(view ->{
                if(!screen.getText().toString().equals("0"))
                {
                    screen.setText(screen.getText().toString()+b.getText().toString());
                }else {
                    screen.setText(b.getText().toString());
                }

            });
        }

        ArrayList<Button> func = new ArrayList<>();
        func.add(multily);
        func.add(devide);
        func.add(minus);
        func.add(plus);
        for(Button b:func) {
            b.setOnClickListener(view->{
                firstNum = Double.parseDouble(screen.getText().toString());
                function = b.getText().toString();
                screen.setText("0");

            });
        }

        delete.setOnClickListener(view->{
            String num = screen.getText().toString();
            if (num.length()>1){
                screen.setText(num.substring(0,num.length()-1));
            }else if (num.length()==1 && !num.equals("0")){
                screen.setText("0");
            }
        });
       dot.setOnClickListener(view ->{
            if (!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString()+".");
            }
       });

       equal.setOnClickListener(view->{
           double secondNum = Double.parseDouble(screen.getText().toString());
           double result;
           switch (function)
           {
               case "/":
                   result=firstNum/secondNum;
                   break;
               case "X":
                   result=firstNum*secondNum;
                   break;
               case "+":
                   result=firstNum+secondNum;
                   break;
               case "-":
                   result=firstNum-secondNum;
                   break;
               default:
                   result=firstNum+secondNum;
           }
            screen.setText(String.valueOf(result));
           firstNum = result;
       });

            //func.add(percent);
        //func.add(sin);
        //func.add(cos);
        //func.add(tan);
        //func.add(cotan);
        //func.add(one_dive_by_x);
        //func.add(sqrt_x);
        //func.add(x_pow_2);
        //func.add(delete);
        //func.add(CE);
        //func.add(C);
    }
}