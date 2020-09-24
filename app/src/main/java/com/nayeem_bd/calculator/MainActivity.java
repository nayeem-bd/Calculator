package com.nayeem_bd.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button zeroButton,oneButton,twoButton,threeButton,fourButton,fiveButton,
            sixButton,sevenButton,eightButton,nineButton,dotButton,minusButton,addButton,
            multiplyButton,divideButton,ansButton,backButton,clearButton,startBracketButton,closeBracketButton;
    private EditText inputEditText;
    private TextView answerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding view
        findAllView();

        // set listener
        setListener();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zeroButtonId:
                appendInput('0');
                break;
            case R.id.oneButtonId:
                appendInput('1');
                break;
            case R.id.twoButtonId:
                appendInput('2');
                break;
            case R.id.threeButtonId:
                appendInput('3');
                break;
            case R.id.fourButtonId:
                appendInput('4');
                break;
            case R.id.fiveButtonId:
                appendInput('5');
                break;
            case R.id.sixButtonId:
                appendInput('6');
                break;
            case R.id.sevenButtonId:
                appendInput('7');
                break;
            case R.id.eightButtonId:
                appendInput('8');
                break;
            case R.id.nineButtonId:
                appendInput('9');
                break;
            case R.id.dotButtonId:
                appendInput('.');
                break;
            case R.id.minusButtonId:
                appendInput('-');
                break;
            case R.id.addButtonId:
                appendInput('+');
                break;
            case R.id.multiplyButtonId:
                appendInput('*');
                break;
            case R.id.devideButtonId:
                appendInput('/');
                break;
            case R.id.ansButtonId:
                calculation();
                break;
            case R.id.backButtonId:
                backspaceInput();
                break;
            case R.id.clearButtonId:
                clearInput();
                break;
            case R.id.startBracketButtonId:
                appendInput('(');
                break;
            case R.id.closeBracketButtonId:
                appendInput(')');
                break;
        }
    }

    public void findAllView(){
        zeroButton = findViewById(R.id.zeroButtonId);
        oneButton = findViewById(R.id.oneButtonId);
        twoButton = findViewById(R.id.twoButtonId);
        threeButton = findViewById(R.id.threeButtonId);
        fourButton = findViewById(R.id.fourButtonId);
        fiveButton = findViewById(R.id.fiveButtonId);
        sixButton = findViewById(R.id.sixButtonId);
        sevenButton = findViewById(R.id.sevenButtonId);
        eightButton = findViewById(R.id.eightButtonId);
        nineButton = findViewById(R.id.nineButtonId);
        dotButton = findViewById(R.id.dotButtonId);
        minusButton = findViewById(R.id.minusButtonId);
        addButton = findViewById(R.id.addButtonId);
        multiplyButton = findViewById(R.id.multiplyButtonId);
        divideButton = findViewById(R.id.devideButtonId);
        ansButton = findViewById(R.id.ansButtonId);
        backButton = findViewById(R.id.backButtonId);
        clearButton = findViewById(R.id.clearButtonId);
        startBracketButton = findViewById(R.id.startBracketButtonId);
        closeBracketButton = findViewById(R.id.closeBracketButtonId);
        inputEditText = findViewById(R.id.inputEditTextId);
        answerTextView = findViewById(R.id.ansTextViewId);
    }

    public void setListener() {
        zeroButton.setOnClickListener(this);
        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        dotButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        ansButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        startBracketButton.setOnClickListener(this);
        closeBracketButton.setOnClickListener(this);
    }

    public void appendInput(Character ch){
        String text = inputEditText.getText().toString();
        text+=ch;
        inputEditText.setText(text);
        answerTextView.setText(ansfind());
    }
    public void backspaceInput(){
        String text = inputEditText.getText().toString();
        if(!text.isEmpty()){
            StringBuffer newText = new StringBuffer(text);
            newText.deleteCharAt(newText.length()-1);
            inputEditText.setText(newText);
        }

    }
    public void clearInput(){
        String text = inputEditText.getText().toString();
        if(!text.isEmpty()){
            StringBuffer newText = new StringBuffer(text);
            newText.delete(0,newText.length());
            inputEditText.setText(newText);
        }
    }

    public void calculation(){
        inputEditText.setText(ansfind());
        answerTextView.setText("");
    }

    public String ansfind(){
        String text = inputEditText.getText().toString();
        Expression expression = new Expression(text);
        expression.setPrecision(4);
        BigDecimal result;
        try {
            result = expression.eval();
        }catch (Exception e){
            return "";
        }
        return result.toString();
    }
}