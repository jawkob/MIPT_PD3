package com.example.mipt_pd3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import static java.lang.Math.sqrt;


public class MainActivity extends AppCompatActivity {

    double main_Calculation_d = 0;
    double temp = 0;
    double operation_Num = 0;
    String operator;
    boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(main_Calculation_d);
    }

    //------ 0-9 number adding section start-------
    public void add_0(View view)
    {
        if (main_Calculation_d != 0)
        {
            main_Calculation_d *= 10;
            display(main_Calculation_d);
        }
    }
    public void add_1(View view)
    {
        add_Number(1);
    }
    public void add_2(View view)
    {
        add_Number(2);
    }
    public void add_3(View view)
    {
        add_Number(3);
    }
    public void add_4(View view)
    {
        add_Number(4);
    }
    public void add_5(View view)
    {
        add_Number(5);
    }
    public void add_6(View view)
    {
        add_Number(6);
    }
    public void add_7(View view)
    {
        add_Number(7);
    }
    public void add_8(View view)
    {
        add_Number(8);
    }
    public void add_9(View view)
    {
        add_Number(9);
    }

    public void add_Number(int num)
    {
        if (main_Calculation_d != 0)
        {
            main_Calculation_d *= 10;
            main_Calculation_d += num;
            display(main_Calculation_d);
        }
        else
        {
            main_Calculation_d = num;
            display(main_Calculation_d);
        }
    }

    //--------------------- section end -------------
    //-------------------extras start----------------
    public static String make_db_nice(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }

    public void display (double a)
    {
        TextView calculaitonViewer = (TextView) findViewById(R.id.textView);
        calculaitonViewer.setText(make_db_nice(a));
    }

    //--------------------- section end -------------
    //-------- number operations section start-------
    public void clear(View view)
    {
        main_Calculation_d = 0;
        display(main_Calculation_d);
    }

    public void change_Sign(View view)
    {
        main_Calculation_d *= -1;
        display(main_Calculation_d);
    }

    public void sqRoot(View view)
    {
        main_Calculation_d = sqrt(main_Calculation_d);
        display(main_Calculation_d);
    }

    public void divide(View view)
    {
        first = true;
        operator = "divide";
        temp = main_Calculation_d;
        clear(view);
    }

    public void subtract(View view)
    {
        first = true;
        operator = "subtract";
        temp = main_Calculation_d;
        clear(view);
    }

    public void multiply(View view)
    {
        first = true;
        operator = "multiply";
        temp = main_Calculation_d;
        clear(view);
    }

    public void add(View view)
    {
        first = true;
        operator = "add";
        temp = main_Calculation_d;
        clear(view);
    }

    public void delete(View view) {
        if (main_Calculation_d >= 10) {
            int cutter;
            if (main_Calculation_d % 1 == 0)
                cutter = 3;
            else
                cutter = 1;
            String tmp = String.valueOf(main_Calculation_d);
            tmp = tmp.substring(0, (tmp.length() - cutter));
            main_Calculation_d = Double.parseDouble(tmp);
            TextView calculaitonViewer = (TextView) findViewById(R.id.textView);
            calculaitonViewer.setText(tmp);
        }
        else
        {
            main_Calculation_d = 0;
            display(main_Calculation_d);
        }
    }

    public void answer(View view)
    {
        if (first)
        {
            operation_Num = main_Calculation_d;
            first = false;
        }
        switch (operator) {
            case "divide":
                main_Calculation_d = temp / operation_Num;
                temp = main_Calculation_d;
                display(main_Calculation_d);
                break;
            case "subtract":
                main_Calculation_d = temp - operation_Num;
                temp = main_Calculation_d;
                display(main_Calculation_d);
                break;
            case "multiply":
                main_Calculation_d = temp * operation_Num;
                temp = main_Calculation_d;
                display(main_Calculation_d);
                break;
            case "add":
                main_Calculation_d = temp + operation_Num;
                temp = main_Calculation_d;
                display(main_Calculation_d);
                break;
        }
    }

}