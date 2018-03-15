package com.example.feifei.testtopbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

         MyTopBar myTopBar = (MyTopBar)findViewById(R.id.mytopbar);
         myTopBar.setTopBarListener(new MyTopBar.TopBarListener() {
             @Override
             public void leftClick(View v) {
                 Toast.makeText(MainActivity.this,"这是左边的按键",Toast.LENGTH_SHORT).show();
             }

             @Override
             public void rigthClick(View v) {
                 Toast.makeText(MainActivity.this,"这是右边的按键",Toast.LENGTH_SHORT).show();
             }
         });
    }
}
