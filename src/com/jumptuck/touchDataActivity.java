package com.jumptuck;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jumptuck.touchData.R;

public class touchDataActivity extends Activity {
	TextView textView;
	TextView decoded;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textView = (TextView) findViewById(R.id.textView1);
        decoded = (TextView) findViewById(R.id.decodedMessage);
    }
    
    public void clearClicked(View v){
    	textView.setText("");
    	decoded.setText("");
    	//textView.setText(Character.toString(binToChar("")));
    }
    
    public void zeroClicked(View v){
    	String oldText = textView.getText().toString();
    	if (oldText.length() == 7){
    		String oldDecoded = decoded.getText().toString();
    		decoded.setText(oldDecoded + Character.toString(binToChar(oldText + "0")));
    		textView.setText("");
    	}
    	else textView.setText(oldText + "0");
    }
    
    public void oneClicked(View v){
    	String oldText = textView.getText().toString();
    	if (oldText.length() == 7){
    		String oldDecoded = decoded.getText().toString();
    		decoded.setText(oldDecoded + Character.toString(binToChar(oldText + "1")));
    		textView.setText("");
    	}
    	else textView.setText(oldText + "1");
    }
    
    public char binToChar(String s){
    	char letter;
    	int count = 0;
    	
    	//Big-endian
    	if (s.charAt(0)==49) count += 128;
    	if (s.charAt(1)==49) count += 64;
    	if (s.charAt(2)==49) count += 32;
    	if (s.charAt(3)==49) count += 16;
    	if (s.charAt(4)==49) count += 8;
    	if (s.charAt(5)==49) count += 4;
    	if (s.charAt(6)==49) count += 2;
    	if (s.charAt(7)==49) count += 1;
    	letter = (char)count;
    	return letter;
    }
}