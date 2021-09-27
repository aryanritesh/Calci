package blehblu.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
 private Button Ac,del,percent,divide,multi,minus,add,equal,dot,pi,zero,one,two,three,four,five,six,seven,eight,nine;
 private TextView result,history;
 private String number= null;
 double num1=0;
 double num2=0;
 String status=null;
 boolean operator=false;
 DecimalFormat formatter=new DecimalFormat("#######.####");
 String old, current;
 boolean dott =true;
 boolean acStatus=true;
 boolean equalStatus=false;
 boolean addStatus=true;
 boolean minusStatus= true;
 boolean multiStatus=true;
 boolean divStatus=true;
 boolean percentStatus=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ac=findViewById(R.id.ac);
        del=findViewById(R.id.del);
        percent=findViewById(R.id.percent);
        divide=findViewById(R.id.div);
        multi=findViewById(R.id.multi);
        minus=findViewById(R.id.minus);
        add=findViewById(R.id.add);
        equal=findViewById(R.id.equal);
        dot=findViewById(R.id.dot);
        pi=findViewById(R.id.pi);
        zero=findViewById(R.id.zero);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);

        result=findViewById(R.id.result);
        history=findViewById(R.id.texViewHistory);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              numClick("0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("9");
            }
        });

        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numClick("3.1415");
            }
        });

        Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             number=null;
             status=null;
             result.setText("0");
             history.setText("");
             num1=0;
             num2=0;
             dott=true;
             acStatus=true;
             equal.setClickable(true);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(acStatus){
                    result.setText("0");
                }
                else{
                number=number.substring(0,number.length()-1);
                if(number.length()==0){
                    del.setClickable(false);
                }
                else if(number.contains(".")){
                    dott=false;
                }

                else{
                    dott=true;
                }
                result.setText(number);
                if(number.length()==0){
                result.setText("0");
                }
                }
                status="del";
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal.setClickable(true);
                old=history.getText().toString();
                current=result.getText().toString();
                history.setText(old+current+"+");
                add.setClickable(false);
                minus.setClickable(true);
                multi.setClickable(true);
                divide.setClickable(true);
                del.setClickable(false);
                addStatus=true;
                if (minusStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"+");
                }
                if (divStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"+");
                }
                if (multiStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"+");
                }
                if (percentStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"+");
                }
                if(operator){
                    if (status == "multiplication") {
                        mul();
                    }
                    else if(status=="division"){
                        div();
                    }
                    else if(status=="subtraction"){
                        minus();
                    }
                    else if (status == "percent") {
                        percent();
                    }
                    else {
                        add();
                    }
                    }
                status="sum";
                operator=false;
                number=null;
                addStatus=true;
                }

        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal.setClickable(true);
                add.setClickable(true);
                minus.setClickable(false);
                multi.setClickable(true);
                divide.setClickable(true);
                del.setClickable(false);
                old=history.getText().toString();
                current=result.getText().toString();
                history.setText(old+current+"-");
                if (addStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"-");
                }
                if (multiStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"-");
                }
                if (divStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"-");
                }
                if (percentStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"-");
                }
                if(operator){

                    if(status=="multiplication"){
                        mul();
                    }
                    else if(status=="division"){
                        div();
                    }
                    else if(status=="sum"){
                        add();
                    }
                    else if (status == "percent") {
                        percent();
                    }
                    else{
                        minus();
                    }

                }
                status="subtraction";
                operator=false;
                number=null;
                minusStatus=true;

            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal.setClickable(true);
                add.setClickable(true);
                old=history.getText().toString();
                current=result.getText().toString();
                history.setText(old+current+"x");
                minus.setClickable(true);
                multi.setClickable(false);
                divide.setClickable(true);
                del.setClickable(false);
                if (addStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"x");
                }
                if (minusStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"x");
                }
                if (divStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"x");
                }
                if (percentStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"x");
                }
             if(operator){
                 if(status=="sum"){
                     add();
                 }
                 else if(status=="division"){
                     div();
                 }
                 else if(status=="subtraction"){
                     minus();
                 }
                 else if (status == "percent") {
                     percent();
                 }
                 else{
                     mul();
                 }
             }
             status="multiplication";
             operator=false;
             number=null;
             multiStatus=true;
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal.setClickable(true);
                add.setClickable(true);
                old=history.getText().toString();
                current=result.getText().toString();
                history.setText(old+current+"/");
                minus.setClickable(true);
                multi.setClickable(true);
                divide.setClickable(false);
                del.setClickable(false);
                if (addStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"/");
                }
                if (minusStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"/");
                }
                if (multiStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"/");
                }
                if (percentStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"/");
                }
                if(operator){
                    if(status=="multiplication"){
                        mul();
                    }
                    else if(status=="sum"){
                        add();
                    }
                    else if(status=="subtraction"){
                        minus();
                    }
                    else if (status == "percent") {
                        percent();
                    }
                    else{
                        div();
                    }
                }
                 status="division";
                operator=false;
                number=null;
                divStatus=true;
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                old=history.getText().toString();
                current=result.getText().toString();
                history.setText(old+current+"%");
                equal.setClickable(true);
                add.setClickable(true);
                minus.setClickable(true);
                multi.setClickable(true);
                divide.setClickable(true);
                del.setClickable(false);
                if (addStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"%");
                }
                if (addStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"%");
                }
                if (multiStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"%");
                }
                if (divStatus) {
                    history.setText("");
                    current=result.getText().toString();
                    history.setText(current+"%");
                }
                if(status=="sum"){
                    add();
                }
                else if(status=="subtraction"){
                    minus();
                }
                else if(status=="multiplication"){
                    mul();
                }
                else if(status=="division"){
                    div();
                }
                else{
                    percent();
                }
                status="percent";
                operator=false;
                number=null;
                percentStatus=true;

            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add.setClickable(true);
                minus.setClickable(true);
                multi.setClickable(true);
                divide.setClickable(true);
                if (dott) {
                    if (number == null) {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                }
                    result.setText(number);
                dott=false;
                }

        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                old=history.getText().toString();
                current=result.getText().toString();
                history.setText(old+current+"");
                history.setText("");
                del.setClickable(false);
                equal.setClickable(false);
                add.setClickable(true);
                minus.setClickable(true);
                multi.setClickable(true);
                divide.setClickable(true);
                if(operator){
                    if(status=="sum"){
                        add();
                    }
                    else if(status=="subtraction"){
                        minus();
                    }
                    else if(status=="multiplication"){
                        mul();
                    }
                    else if(status=="division"){
                        div();
                    }
                    else if (status == "percent") {
                        percent();
                    }
                    else{
                        num1=Double.parseDouble(result.getText().toString());

                    }
                }
                 operator=false;
                equalStatus=true;
            }
        });

    }
    public void numClick(String view){
        if(number==null){
            number=view;
        }
        else if(equalStatus){
            num1=0;
            num2=0;
            number=view;

        }
        else{
            number=number+view;
        }
        result.setText(number);
        operator=true;
        acStatus=false;
        del.setClickable(true);
        equal.setClickable(true);
        equalStatus=false;
        add.setClickable(true);
        minus.setClickable(true);
        multi.setClickable(true);
        divide.setClickable(true);
    }
    public void add(){
        num2= Double.parseDouble(result.getText().toString());
        num1=num1+num2;
        result.setText(formatter.format(num1));
        dott=true;
    }

    public void minus(){
        if(num1==0){
            num1=Double.parseDouble(result.getText().toString());

        }
        else{
            num2=Double.parseDouble(result.getText().toString());
            num1=num1-num2;
        }
        result.setText(formatter.format(num1));
        dott=true;
    }

    public void mul(){
        if(num1==0){
            num1=1;
            num2=Double.parseDouble(result.getText().toString());
            num1=num1 * num2;
        }
        else{
            num2=Double.parseDouble(result.getText().toString());
            num1=num1 * num2;
        }
        result.setText(formatter.format(num1));
        dott=true;
    }

    public void div(){

        if(num1==0){
            num2=Double.parseDouble(result.getText().toString());
            num1=num2/1;
        }
        else{
            num2=Double.parseDouble(result.getText().toString());
            num1=num1/num2;
        }
        result.setText(formatter.format(num1));
        dott=true;
    }

    public void percent(){
        num2=Double.parseDouble(result.getText().toString());
        num1=num2/100;
        result.setText(formatter.format(num1));
        dott=true;
    }
}