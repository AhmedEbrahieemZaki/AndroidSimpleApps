package com.example.anew;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11;
    TextView tv;
    int btn[];
    int player=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= new int[]{0,0,0,0,0,0,0,0,0};
        addListenerButton();
        intView();
    }
    private void changeText(View v, int i){
        Button Selected = (Button) v;
        if (btn[i]==0){
            if (player==1){
                Selected.setText("X");
                Selected.setTextSize(5);
                player = 2;
            }
            else if (player ==2){
                Selected.setText("O");
                Selected.setTextSize(5);
                player=1;
            }
            tv.setText("Player :"+player);
        }
    }
    private void checkWin(int i , View v){
        changeText(v,i);
        if (btn[i] ==0){
            btn[i]=player;
        }
        if (btn[0]==player&&btn[1]==player&&btn[2]==player
                || btn[3]==player&&btn[4]==player&&btn[5]==player
                ||btn[6]==player&&btn[7]==player&&btn[8]==player
                ||btn[1]==player&&btn[4]==player&&btn[7]==player
                ||btn[2]==player&&btn[5]==player&&btn[8]==player
                ||btn[3]==player&&btn[6]==player&&btn[9]==player
                ||btn[7]==player&&btn[5]==player&&btn[3]==player
                ||btn[1]==player&&btn[5]==player&&btn[9]==player)
            showAlert();
        }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("you win")
                .setMessage(" RE PLAY?" )
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        recreate();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                checkWin(0,v);
                break;
            case R.id.btn2:
                checkWin(1,v);
                break;
            case R.id.btn3:
                checkWin(2,v);
                break;
            case R.id.btn4:
                checkWin(3,v);
                break;
            case R.id.btn5:
                checkWin(4,v);
                break;
            case R.id.btn6:
                checkWin(5,v);
                break;
            case R.id.btn7:
                checkWin(6,v);
                break;
            case R.id.btn8:
                checkWin(7,v);
                break;
            case R.id.btn9:
                checkWin(8,v);
                break;
            case R.id.btn10:
                recreate();
                break;
            case R.id.btn11:
                finish();
                break;
        }}
    private void addListenerButton () {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);

    }
    private void intView(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        tv = findViewById(R.id.tv);

    }
}