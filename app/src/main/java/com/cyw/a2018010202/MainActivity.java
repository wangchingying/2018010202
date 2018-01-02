package com.cyw.a2018010202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //抓到button3
        bt3=(Button)findViewById(R.id.button3);
        //new一個Mylistener
/*        Mylistener listener=new Mylistener();
        //將這個listener放入bt3的onclickListner中,當按鈕一按,就會執行下面所寫的override method
        bt3.setOnClickListener(listener);
 */
        //用匿名類別寫法,就不用宣告很多東西占用記憶體,因為按鈕只用一次<==複習一下匿名類別
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "test3", Toast.LENGTH_SHORT).show();
            }
        });
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

/*
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
