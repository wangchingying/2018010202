package com.cyw.a2018010202;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt3,bt4,bt6;
    ToggleButton tb1;
    TextView tv1;
    Switch sw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //抓到button3
        bt3=(Button)findViewById(R.id.button3);
        bt4=(Button)findViewById(R.id.button4);
        tb1=(ToggleButton)findViewById(R.id.toggleButton);
        tv1=(TextView)findViewById(R.id.textView);
        sw1=(Switch)findViewById(R.id.switch1);
        bt6=(Button)findViewById(R.id.button6);
//第一種方法
        //new一個Mylistener
/*        Mylistener listener=new Mylistener();
        //將這個listener放入bt3的onclickListner中,當按鈕一按,就會執行下面所寫的override method
        bt3.setOnClickListener(listener);
*/

//第二種方法
        //用匿名類別寫法,就不用宣告很多東西占用記憶體,因為按鈕只用一次<==複習一下匿名類別
        //打到new View....按enter就會自動
/*        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "test3", Toast.LENGTH_SHORT).show();
            }
        });
 */
//跳到有懸浮按紐那頁  課本7-4
bt6.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent it=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(it);
    }
});
    tb1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (tb1.isChecked()) {
                Toast.makeText(MainActivity.this, "開關開啟中", Toast.LENGTH_SHORT).show();
                tv1.setText(tb1.getText().toString());
            } else {
                Toast.makeText(MainActivity.this, "開關關閉中", Toast.LENGTH_SHORT).show();
                tv1.setText(tb1.getText().toString());
            }
        }

    });
        //第三種方法, 在onCreate直接執行View.OnClickListener介面,然後實作
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

        //Switch
        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw1.isChecked())
                {
                    Toast.makeText(MainActivity.this, "switch on", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "switch off", Toast.LENGTH_SHORT).show();
                }
            }
        });
}

    //這個按紐檢查tb1(toggle button)目前是開啟還是關閉
    public void clickcheck(View v) {
        if (tb1.isChecked()) {
            Toast.makeText(MainActivity.this, "目前開啟中", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "目前關閉中", Toast.LENGTH_SHORT).show();
        }
    }


    public void click1(View v) //兩個按鈕onclick都叫click1, 但id不同, 可用switch來控制執行內容, 老師不喜歡
    {
        switch (v.getId())//V.getID()是int
        {
            case R.id.button://R.id.button是int, 怎麼看?
                Toast.makeText(MainActivity.this, "test1", Toast.LENGTH_SHORT).show();
                //Toast用來debug很好用,只有兩個值, short 跟long, 控制出現時間長短
                break;
            case R.id.button2:
                Toast.makeText(MainActivity.this, "test2", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //第三種方法的實作
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button3:
                Toast.makeText(MainActivity.this, "Test3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Toast.makeText(MainActivity.this, "Test4", Toast.LENGTH_SHORT).show();
                break;
        }
    }




/*第一種方法
    //業界正常用法,用程式直接執行第三個按鈕, 不在onclick設定變數
    //自訂類別Mylistener執行介面, 然後override onClick method
    class Mylistener implements View.OnClickListener
    {
        //直接打onClick 然後選擇想要的, 就會出現@Overrid......,不用自己打
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "test3", Toast.LENGTH_SHORT).show();

        }

    }
*/
}
