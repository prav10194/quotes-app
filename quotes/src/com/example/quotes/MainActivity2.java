package com.example.quotes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.appengers.quotes.R;
import com.example.quotes.SimpleGestureFilter.SimpleGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity implements SimpleGestureListener{
    private SimpleGestureFilter detector;
    
	  SQLiteDatabase db;		
	  TextView t1,t2,t4;
	  TextView t5;
	  Cursor c;
	  int n=0;
	  String number,quote,name,episode;
	  String filename;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout2);
		  t1=(TextView)findViewById(R.id.quote);
	 	  t2=(TextView)findViewById(R.id.name);
	 	  //t4=(TextView)findViewById(R.id.episode);
	 	 t5=(TextView)findViewById(R.id.number);
		 db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		   //create new table if not already exist
		 db.execSQL("create table if not exists newtable2(number varchar, name varchar, quote varchar, filename varchar)");
		 db.execSQL("insert into newtable2 values(1,'','Who are you George Costanza? I am opposite of every guy you met','quotes1')");
		 db.execSQL("insert into newtable2 values(2,'-George Costanza','It is not you, it is me','quotes2')");
		 db.execSQL("insert into newtable2 values(3,'-George Costanza','Wine better than Pepsi?','quotes3')");
		 db.execSQL("insert into newtable2 values(4,'-George Costanza','Why are you so funny all the time?','quotes4')");
		 db.execSQL("insert into newtable2 values(5,'-George Costanza','Pretending to be an architect','quotes5')");
		 db.execSQL("insert into newtable2 values(6,'-George Costanza','George Answering machine','quotes6')");
		 db.execSQL("insert into newtable2 values(7,'-George Costanza','Sweet fancy moses!','quotes7')");
		 db.execSQL("insert into newtable2 values(8,'','These pretzels are making me thirsty! [Compilation]','quotes8')");
		 db.execSQL("insert into newtable2 values(9,'-George Costanza','You are killing independent George','quotes9')");
		 db.execSQL("insert into newtable2 values(10,'-Frank Costanza','The rooster, chicken and hen problem','quotes10')");
		 db.execSQL("insert into newtable2 values(11,'','Newman and Kramer court story','quotes11')");
		 db.execSQL("insert into newtable2 values(12,'','We are not gay! Not that there is anything wrong in it','quotes12')");
		 db.execSQL("insert into newtable2 values(13,'-George Costanza','The Roomate Switch','quotes13')");
		 db.execSQL("insert into newtable2 values(14,'-Jerry Seinfeld','The concept of Reservation','quotes14')");
		 db.execSQL("insert into newtable2 values(15,'-George Costanza','Elaine Dancing','quotes15')");
		 db.execSQL("insert into newtable2 values(16,'-Jerry Seinfeld','The Anti-Dentite','quotes16')");
		 db.execSQL("insert into newtable2 values(17,'-Jerry Seinfeld','The telemarketer','quotes17')");
		 db.execSQL("insert into newtable2 values(18,'-Kramer','The Vandelay Industries!','quotes18')");
		 db.execSQL("insert into newtable2 values(19,'-George Costanza','Yada yada yada!','quotes19')");
		 db.execSQL("insert into newtable2 values(20,'-Jerry Seinfeld','The Junior Mints','quotes20')");
		 	
		  
		 // Detect touched area 
         detector = new SimpleGestureFilter(this,this);
         c=db.rawQuery("select * from newtable2", null);
	      c.moveToFirst();
	      number=c.getString(0);
	      name=c.getString(1);
	 	 quote=c.getString(2);
	 	 filename=c.getString(3);
	 	//episode=c.getString(3);
	 	 
	 	 t1.setText(quote);
	 	 t2.setText(name);
	 	//t4.setText(episode);
	 	 t5.setText(number+"- 20");
	 	Toast.makeText(this, "Swipe left or right to view the previous or next quote", Toast.LENGTH_LONG).show();
	 	
	

	 
		
		ImageView share=(ImageView)findViewById(R.id.share);
		share.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent shareIntent =   
						 new Intent(android.content.Intent.ACTION_SEND);  
						  
						//set the type  
						shareIntent.setType("text/plain");  
						  
						//add a subject  
						shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,   
						 "Seinfeld quote: ");  
						  
						//build the body of the message to be shared  
						String shareMessage = quote+" \n"+name;  
						  
						//add the message  
						shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,   
						 shareMessage);  
						  
						//start the chooser for sharing  
						startActivity(Intent.createChooser(shareIntent,   
						 "Share the quote via"));  
			}
	});
	 	
	 	ImageView quote10=(ImageView)findViewById(R.id.quote10);
		quote10.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				onSwipe(SimpleGestureFilter.SWIPE_DOWN);
			}
	});
		
		//Implementing the audio buttons
		
		
		ImageButton ringtone_button =(ImageButton)findViewById(R.id.button1);
		ringtone_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				File sound1;
	            File directoryTest = new File(
	                    Environment.getExternalStorageDirectory(), "raw2sd");
	                try {
	                    //coping sound file to sd
	                    //defining specific directory
	                    File soundDir = new File(directoryTest, "ORG");
	                    //making directories
	                    soundDir.mkdirs();
	                    FileOutputStream sound = new FileOutputStream(
	                            soundDir.getPath() + "/"+filename+".mp3");
	                 
	                    
	                    
	                sound1=new File(soundDir.getPath());
	               int resID=getResources().getIdentifier(filename, "raw", getPackageName());
	                    InputStream is = getResources().openRawResource(resID);
	          
	                    
	                    int a = is.available();
	                    byte[] buf = new byte[a];
	                    is.read(buf, 0, a);
	                    sound.write(buf);
	                    sound.flush();
	                    sound.close();
	                    Toast.makeText(getApplicationContext(), "File saved in raw2sd/ORG"+filename,
	                    		   Toast.LENGTH_LONG).show();
	                    
	                    File k = new File(sound1, filename+".mp3"); // path is a file to /sdcard/media/ringtone
	                    
	           

	                    ContentValues values = new ContentValues();
	                    values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
	                    values.put(MediaStore.MediaColumns.TITLE, filename);
	                    values.put(MediaStore.MediaColumns.SIZE, 215454);
	                    values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp3");
	                    values.put(MediaStore.Audio.Media.ARTIST, "Seinfeld");
	                    //values.put(MediaStore.Audio.Media.DURATION, 230);
	                    values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
	                    values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
	                    values.put(MediaStore.Audio.Media.IS_ALARM, false);
	                    values.put(MediaStore.Audio.Media.IS_MUSIC, false);

	                    //Insert it into the database
	                    Uri uri = MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath());
	                    getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + k.getAbsolutePath() + "\"", null);
	                    Uri newUri = getContentResolver().insert(uri, values);

	                    RingtoneManager.setActualDefaultRingtoneUri(MainActivity2.this,
	                            RingtoneManager.TYPE_RINGTONE, newUri);
	                    
	                    Toast.makeText(getApplicationContext(), "Sound is set as ringtone",
	                    		   Toast.LENGTH_LONG).show();
	                    

	                } catch (FileNotFoundException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                    
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                    
	                }
				
	                
	                
	                
	                
	               
	                

			
			}
	});
		
		ImageButton share_button=(ImageButton)findViewById(R.id.button2);
		share_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				File sound1;
	            File directoryTest = new File(
	                    Environment.getExternalStorageDirectory(), "raw2sd");
	                try {
	                    //coping sound file to sd
	                    //defining specific directory
	                    File soundDir = new File(directoryTest, "ORG");
	                    //making directories
	                    soundDir.mkdirs();
	                    FileOutputStream sound = new FileOutputStream(
	                            soundDir.getPath() + "/"+filename+".mp3");
	                 
	                    
	                    
	                sound1=new File(soundDir.getPath());
	               int resID=getResources().getIdentifier(filename, "raw", getPackageName());
	                    InputStream is = getResources().openRawResource(resID);
	          
	                    
	                    int a = is.available();
	                    byte[] buf = new byte[a];
	                    is.read(buf, 0, a);
	                    sound.write(buf);
	                    sound.flush();
	                    sound.close();
	                    Toast.makeText(getApplicationContext(), "File saved in raw2sd/ORG",
	                    		   Toast.LENGTH_LONG).show();
	                    
	                    String sharePath = Environment.getExternalStorageDirectory().getPath()
	        		            + "/raw2sd/ORG/"+filename+".mp3";
	        		    Uri uri = Uri.parse(sharePath);
	        		    Intent share = new Intent(Intent.ACTION_SEND);
	        		    share.setType("audio/*");
	        		    share.putExtra(Intent.EXTRA_STREAM, uri);
	        		    startActivity(Intent.createChooser(share, "Share Sound File"));
	               
	                } catch (FileNotFoundException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                    
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                    
	                }
				
	                
	                
	                
	                
	               
	                

			
			}
	});
		

		ImageButton play_button=(ImageButton)findViewById(R.id.button4);
		play_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				MediaPlayer mPlayer2;
				int resID=getResources().getIdentifier(filename, "raw", getPackageName());
	               
				mPlayer2= MediaPlayer.create(MainActivity2.this, resID);
				        mPlayer2.start();
			
			}
	});
		
		
		
		
		
		
		
		
		
		
		
		
	
	}	
	
	public void change()
	{
		 Cursor c=db.rawQuery("select * from newtable2", null);
		 
	      c.moveToNext();
		
			
		 
	      String number=c.getString(0);
	      String name=c.getString(1);
	 	 String quote=c.getString(2);
	 	filename=c.getString(3);
	 	// String episode=c.getString(3);
	 	 
		 t1.setText(quote);
	 	 t2.setText(name);
	 	 //t4.setText(episode);
	 	 t5.setText(number);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
	
		
		
		switch(item.getItemId()){	
			
		
			
		case R.id.help:
			Intent shareIntent =   
			 new Intent(android.content.Intent.ACTION_SEND);  
			  
			//set the type  
			shareIntent.setType("text/plain");  
			  
			//add a subject  
			shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,   
			 "Seinfeld Quotes App: ");  
			  
			//build the body of the message to be shared  
			String shareMessage = "https://play.google.com/store/apps/details?id=com.appengers.quotes";
			  
			//add the message  
			shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,   
			 shareMessage);  
			  
			//start the chooser for sharing  
			startActivity(Intent.createChooser(shareIntent,   
			 "Share the app via"));  
			break;
//		case R.id.gesture:
//			Intent i2=new Intent("android.intent.action.GESTURE");
//			startActivity(i2);
//			break;
			
		case R.id.exit:
		//	String newUA= "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
		//	 ourBrow.getSettings().setUserAgentString(newUA);
			System.exit(0);
			break;
	}
	return false;
	}
	
	
	
	public boolean dispatchTouchEvent(MotionEvent me){
        // Call onTouchEvent of SimpleGestureFilter class
         this.detector.onTouchEvent(me);
       return super.dispatchTouchEvent(me);
    }
    @Override
     public void onSwipe(int direction) {
      String str = "";
      
 	 Cursor c=db.rawQuery("select * from newtable2", null);
	 c.moveToPosition(n);
		 
      switch (direction) {
      
      case SimpleGestureFilter.SWIPE_LEFT :
      if(n==20)
    	  Toast.makeText(this, "Can't go to next quote", Toast.LENGTH_SHORT).show();
      else
      {
      n++;
      c.moveToPosition(n);
      }


     break;
      case SimpleGestureFilter.SWIPE_RIGHT :
      if(n==0)
    	  Toast.makeText(this, "Can't go to previous quote", Toast.LENGTH_SHORT).show();
      else
      {
      n--;
      c.moveToPosition(n);
      }
    	  
      break;
      case SimpleGestureFilter.SWIPE_DOWN :
      Random randomGenerator = new Random();
      int randomInt = randomGenerator.nextInt(20);
      n=randomInt;
      c.moveToPosition(n);
                                                     break;
      case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
                                                     break;
      
      }

      number=c.getString(0);
      name=c.getString(1);
 	 quote=c.getString(2);
 	filename=c.getString(3);
 	
 	// episode=c.getString(3);
 	 
	 t1.setText(quote);
 	 t2.setText(name);
 	 //t4.setText(episode);
 	 t5.setText(number+" - 20");
     }
      
     @Override
     public void onDoubleTap() {
    		android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
			clipboard.setText(quote+" \n"+name);
            Toast.makeText(getApplicationContext(), "Text Copied To Clipboard", Toast.LENGTH_SHORT).show();
	
      
     }
          
  }
	

