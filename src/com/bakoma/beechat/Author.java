package com.bakoma.beechat;

import com.bakoma.beechat.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * This simple Activity serves as a short information 
 * window, containing informations about the author, 
 * version, application name and graphics contributions. 
 */

public class Author extends Activity {
   
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       
       // Prepare TextView to render the text with informations
       TextView tv = new TextView(this);
       tv.setText(R.string.info);
       setContentView(tv);
       setContentView(R.layout.author);
       
       // Initialize the button to perform going back - finish Activity
       Button backButton = (Button) findViewById(R.id.button_back);
       backButton.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {
               finish();
           }
       });
   }
};