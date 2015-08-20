package com.lakhanpal.ankit.transitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;



public class MainActivity extends AppCompatActivity {

    ViewGroup MyLayput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyLayput = (ViewGroup)findViewById(R.id.mainRelativeLayout);
        MyLayput.setOnTouchListener(

                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent Event) {
                        MoveButton();
                        return true;
                    }
                }
        );
    }
    public void MoveButton(){   //take content and stick in bottom
        View mainButton=findViewById(R.id.mainButton);

        TransitionManager.beginDelayedTransition(MyLayput);
        //changing position and size
        RelativeLayout.LayoutParams positionRule=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,       //rules on how we position items
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        positionRule.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRule.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        //we cant do size variation because these rules are for layout only

        mainButton.setLayoutParams(positionRule);//appling the rules
        ViewGroup.LayoutParams sizeRules=mainButton.getLayoutParams();
        sizeRules.width=450;
        sizeRules.width=300;
        mainButton.setLayoutParams(sizeRules);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
