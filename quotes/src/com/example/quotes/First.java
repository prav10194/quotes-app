package com.example.quotes;

import com.appengers.quotes.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class First extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.new1layout);
	
	ImageButton im1=(ImageButton)findViewById(R.id.imageButton1);
	im1.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			Intent myIntent = new Intent(First.this, MainActivity.class);
			First.this.startActivity(myIntent);

		}
});
	ImageButton im2=(ImageButton)findViewById(R.id.imageButton2);
	im2.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			Intent myIntent = new Intent(First.this, MainActivity2.class);
			First.this.startActivity(myIntent);

		}
});
	
	}

}
