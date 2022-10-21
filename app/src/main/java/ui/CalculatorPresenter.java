package ui;

import android.icu.number.NumberFormatter;
import android.icu.number.NumberRangeFormatter;

import java.text.DecimalFormat;
import java.util.Locale;

import model.Calculator;
import model.Operator;

public class CalculatorPresenter {

    private DecimalFormat formatter = new DecimalFormat("#.##");

    private CalculatorView view;
    private Calculator calculator;

    private double argOne;
    private Double argTwo = null;
    private Operator selectedOperator;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }


    public void onDigitPressed(int digit) {

        if (argTwo == null) {
            argOne = argOne * 10 + digit;
            showFormatted(argOne);

        } else {
            argTwo = argTwo * 10 + digit;
            showFormatted(argTwo);
        }
    }

    public void onOperatorPressed(Operator operator) {

        if (selectedOperator != null) {

            argOne = calculator.perform(argOne, argTwo, selectedOperator);
            showFormatted(argOne);


        }

        argTwo = 0.0;

        selectedOperator = operator;


    }

    public void onPointPressed() {

        if (argTwo == null){

            argOne = argOne * 0.1;
            showFormatted(argOne);

        }else {

            argTwo = argTwo * 0.1;
            showFormatted(argTwo);

        }

    }

    private void showFormatted(double value) {

        view.showResult(formatter.format(value));

    }
}
