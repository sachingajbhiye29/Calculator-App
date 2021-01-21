package com.sachin.calculus;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.inputBTN);
        edit.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd){
        String oldStr = edit.getText().toString();
        int cursorPos = edit.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        edit.setText(String.format("%s%s%s", leftStr, strToAdd,rightStr));
        edit.setSelection(cursorPos+1);
    }


    public void clearBTN(View v){
        edit.setText("");
    }

    public void parenthesisBTN(View v){

        int cursorPos = edit.getSelectionStart();
        int openPar = 0;
        int closePar= 0;
        int textLen = edit.getText().length();
        for(int i=0 ;i < cursorPos; i++){

            if(edit.getText().toString().substring(i, i+1).equals("(")){
                openPar  = openPar+1;
            }
            if(edit.getText().toString().substring(i, i+1).equals(")")){
                closePar = closePar+1;
            }
        }

        if(openPar == closePar || edit.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText("(");

        }

        else if(closePar < openPar && !edit.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText(")");

        }
        edit.setSelection(cursorPos+1);
    }

    public void exponentBTN(View v){
        updateText("^");
    }

    public void divideBTN(View v){
        updateText("÷");
    }

    public void sevenBTN(View v){
        updateText("7");
    }

    public void eightBTN(View v) {
        updateText("8");
    }

    public void nineBTN(View v){
        updateText("9");

    }

    public void sixBTN(View v){
        updateText("6");

    }

    public void multiBTN(View v){
        updateText("×");
    }

    public void fourBTN(View v){
        updateText("4");

    }

    public void fiveBTN(View v){

        updateText("5");
    }

    public void threeBTN(View v){

        updateText("3");
    }

    public void twoBTN(View v){
        updateText("2");
    }

    public void oneBTN(View v){
        updateText("1");
    }

    public void zeroBTN(View v){
        updateText("0");
    }

    public void addBTN(View v){
        updateText("+");
    }

    public void minusBTN(View v){
        updateText("-");
    }

    public void equalBTN(View v){

        String userExp = edit.getText().toString();
        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×","*");
        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());
        edit.setText(result);
        edit.setSelection(result.length());
    }

    public void dotBTN(View v){
        updateText(".");
    }

    public void plusminusBTN(View v){
        updateText("-");

    }

    public void backspaceBTN(View v){

        int cursorPos = edit.getSelectionStart();
        int textLen = edit.getText().length();
        if(cursorPos!=0 && textLen!=0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) edit.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            edit.setText(selection);
            edit.setSelection(cursorPos - 1);
        }
    }
}