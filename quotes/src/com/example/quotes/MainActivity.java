package com.example.quotes;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.appengers.quotes.R;
import com.example.quotes.SimpleGestureFilter.SimpleGestureListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SimpleGestureListener{
    private SimpleGestureFilter detector;
    
	  SQLiteDatabase db;		
	  TextView t1,t2,t4;
	  TextView t5;
	  Cursor c;
	  int n=0;
	  String number,quote,name,episode;
	  private InterstitialAd interAd;
	  
	  public void displayInterstitial()
		{
			if(interAd.isLoaded())
			{
				interAd.show();
			}
		}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout1);
		
		interAd= new InterstitialAd(this);
		interAd.setAdUnitId("ca-app-pub-2026106398422810/6145094080");
		//AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        interAd.loadAd(adRequest);
        
        interAd.setAdListener(new AdListener() {
			public void onAdLoaded() {
				// Call displayInterstitial() function
				displayInterstitial();
			}
		});
		
		
		
		  t1=(TextView)findViewById(R.id.quote);
	 	  t2=(TextView)findViewById(R.id.name);
	 	  //t4=(TextView)findViewById(R.id.episode);
	 	 t5=(TextView)findViewById(R.id.number);
		 db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		   //create new table if not already exist
		 db.execSQL("create table if not exists mytable8(number varchar, name varchar, quote varchar)");
		 db.execSQL("insert into mytable8 values(1,'-Jerry Seinfeld','I was the best man at the wedding. If I am the best man, why is she marrying him?')");
		 db.execSQL("insert into mytable8 values(2,'-Jerry Seinfeld','It is amazing that the amount of news that happens in the world every day always just exactly fits the newspaper.')");
		 db.execSQL("insert into mytable8 values(3,'-George Costanza','It is not a lie,if you believe it')");
		 db.execSQL("insert into mytable8 values(4,'-Cosmo Kramer','Hoochie mama')");
		 db.execSQL("insert into mytable8 values(5,'-Elaine Benes','Maybe the dingos ate your baby')");
		 db.execSQL("insert into mytable8 values(6,'-Frank Costanza','Serenity Now')");
		db.execSQL("insert into mytable8 values(7,'-Frank Costanza','You know you are getting old when you get that one candle on the cake. It is like see if you can blow this out.')");
		db.execSQL("insert into mytable8 values(8,'-Jerry Seinfeld','That is the true spirit of Christmas; people being helped by people other than me')");
		db.execSQL("insert into mytable8 values(9,'-Jerry Seinfeld','To the idiotmobile')");
		db.execSQL("insert into mytable8 values(10,'-Jerry Seinfeld','Now they show you how detergents take out bloodstains, a pretty violent image there. I think if you have got a T-shirt with a bloodstain all over it, maybe laundry is not your biggest problem.Maybe you should get rid of the body before you do the wash.')");
		db.execSQL("insert into mytable8 values(11,'-Jerry Seinfeld','The big advantage of a book is it is very easy to rewind. Close it and you are right back at the beginning. ')");
		db.execSQL("insert into mytable8 values(12,'-Jerry Seinfeld','Sometimes the road less traveled is less traveled for a reason')");
		db.execSQL("insert into mytable8 values(13,'-George Costanza',' Hi, my name is George, I am unemployed and I live with my parents.')");
		db.execSQL("insert into mytable8 values(14,'-George Costanza','You know I always wanted to pretend I was an architect')");
		db.execSQL("insert into mytable8 values(15,'-Newman','Just remember, when you control the mail, you control... information.')");
		db.execSQL("insert into mytable8 values(16,'–George Costanza','I do not think I have ever been to an appointment in my life where I wanted the other guy to show up.')");
		db.execSQL("insert into mytable8 values(17,'–Newman','Ah, look, I? I am sorry to bother you, but I am a US postal worker and my mail truck was just ambushed by a band of backwoods mail-hating survivalists.')");
		db.execSQL("insert into mytable8 values(18,'-Jerry Seinfeld','Ask not what I can do for you. Ask what you can do for me')");
		db.execSQL("insert into mytable8 values(19,'–George Costanza','Now you listen to me: I want details and I want them right now. I do not have a job , I have no place to go… you are not in the mood: well you get in the mood mister')");
		db.execSQL("insert into mytable8 values(20,'–George Costanza','Hi it is George, I have got nothing to say')");
		db.execSQL("insert into mytable8 values(21,'–George Costanza','But, but I am disturbed…I am depressed…I am inadequate: I got it all')");
		db.execSQL("insert into mytable8 values(22,'–George Costanza','Now you listen to me: I want details and I want them right now. I do not have a job , I have no place to go… you are not in the mood: well you get in the mood mister')");
		db.execSQL("insert into mytable8 values(23,'–George Costanza','Yeah, I am a great quitter: it is one of the few things I do well… I come from a long line of quitters. My father was a quitter, my grandfather was a quitter… I was raised to give up')");
		db.execSQL("insert into mytable8 values(24,'–George Costanza','This woman hates me so much, I am starting to like her.”')");
		db.execSQL("insert into mytable8 values(25,'-Cosmo Kramer','I need the secure packaging of Jockeys. My boys need a house!')");
		db.execSQL("insert into mytable8 values(26,'–George Costanza','The sea was angry that day, my friends, like an old man trying to send back soup in a deli...')");
		db.execSQL("insert into mytable8 values(27,'–George Costanza','I spend so much time trying to get their clothes off, I never thought of taking mine off.')");
		db.execSQL("insert into mytable8 values(28,'–George Costanza','I lie every second of the day. My whole life is a sham.')");
		db.execSQL("insert into mytable8 values(29,'–Jerry Seinfeld','You, my friend, have crossed the line between man and bum.')");
		db.execSQL("insert into mytable8 values(30,'–George Costanza','You should have seen her face. It was the exact same look my father gave me when I told him I wanted to be a ventriloquist.')");
		db.execSQL("insert into mytable8 values(31,'–Jerry Seinfeld','Did you know that the original title for War and Peace was War, What Is It Good For?')");
		db.execSQL("insert into mytable8 values(32,'–Cosmo Kramer','If I had a son, I would name him Isosceles. Isosceles Kramer.')");
		db.execSQL("insert into mytable8 values(33,'–Jerry Seinfeld','A two-year-old is kind of like having a blender, but you do not have a top for it.')");
		db.execSQL("insert into mytable8 values(34,'–Cosmo Kramer','If I had a son, I would name him Isosceles. Isosceles Kramer.')");
		db.execSQL("insert into mytable8 values(35,'–Jerry Seinfeld','The IRS! They are like the Mafia, they can take anything they want!')");
		db.execSQL("insert into mytable8 values(36,'–Jerry Seinfeld','Make no mistake about why these babies are here - they are here to replace us.')");
		db.execSQL("insert into mytable8 values(37,'–Jerry Seinfeld','You have to motivate yourself with challenges. That is how you know you are still alive.')");
		db.execSQL("insert into mytable8 values(38,'','Elaine: You know what your problem is? Your standards are too high. Jerry: I went out with you. Elaine: That is because my standards are too low.')");
		db.execSQL("insert into mytable8 values(39,'','Jerry: You can not keep avoiding her. George Costanza: Why not? If she can not find me, she can not break up with me.')");
		db.execSQL("insert into mytable8 values(40,'–George Costanza','George is gettin upset!')");
		db.execSQL("insert into mytable8 values(41,'–George Costanza','Ahh, what is the point? When I like them, they do not like me, when they like me I do not like them. Why can not I act with the ones I like the way I do with the ones I don not like?')");
		db.execSQL("insert into mytable8 values(42,'–George Costanza','I can not die with dignity. I have no dignity. I want to be the one person who does not die with dignity. I have lived my whole life in shame! Why should I die with dignity?')");
		db.execSQL("insert into mytable8 values(43,'–Elaine Benes','I am not a lesbian! I hate men, but I am not a lesbian')");
		db.execSQL("insert into mytable8 values(44,'–Elaine Benes','Yada yada yada')");
		db.execSQL("insert into mytable8 values(45,'–George Costanza','I am much more comfortable criticizing people behind their backs.')");
		db.execSQL("insert into mytable8 values(46,'–George Costanza','I hate asking for change. They always make a face. It is like asking them to donate a kidney.')");
		db.execSQL("insert into mytable8 values(47,'–George Costanza','Every instinct I have, in every aspect of life, be it something to wear, something to eat - it has all been wrong.')");
		db.execSQL("insert into mytable8 values(48,'–Jerry Seinfeld','I can not go to a bad movie by myself. What, am I gonna make sarcastic remarks to strangers?')");
		db.execSQL("insert into mytable8 values(49,'–Jerry Seinfeld','Look to the cookie, Elaine')");
		db.execSQL("insert into mytable8 values(50,'–Cosmo Kramer','The carpet sweeper is the biggest scam perpetrated on the American public since one-hour martinizing.')");
		db.execSQL("insert into mytable8 values(51,'–Jerry Seinfeld','Men do not care what is on TV. They only care what else is on TV.')");
		db.execSQL("insert into mytable8 values(52,'–Jerry Seinfeld','I do not want to hear the specials. If they are so special, put them on the menu.')");
		db.execSQL("insert into mytable8 values(53,'–Jerry Seinfeld','A bookstore is one of the only pieces of evidence we have that people are still thinking.')");
		db.execSQL("insert into mytable8 values(54,'–Jerry Seinfeld','Funny is the world I live in. You are funny, I am interested. You are not funny, I am not interested.')");
		db.execSQL("insert into mytable8 values(55,'–Jerry Seinfeld','When someone does a small task beautifully, their whole environment is affected by it.')");
		db.execSQL("insert into mytable8 values(56,'–Jerry Seinfeld','I like definitive things.')");
		db.execSQL("insert into mytable8 values(57,'–Jerry Seinfeld','My theory is 98 percent of all human endeavor is killing time.')");
		db.execSQL("insert into mytable8 values(58,'–Jerry Seinfeld','When I jumped off a roof in Cannes in a bee costume, I looked ridiculous. But this is my business, I have to humiliate myself.')");
		db.execSQL("insert into mytable8 values(59,'–Jerry Seinfeld','Once you start doing only what you have already proven you can do, you are on the road to death.')");
		db.execSQL("insert into mytable8 values(60,'–Jerry Seinfeld','Well, Howard Stern has been doing his impression of me for years. It does not really bother me.')");
		db.execSQL("insert into mytable8 values(61,'–Jerry Seinfeld','I think of myself more as a sportsman than I do an artist.')");
		db.execSQL("insert into mytable8 values(62,'–Jerry Seinfeld','Once you start doing only what you have already proven you can do, you are on the road to death.')");
		db.execSQL("insert into mytable8 values(63,'–Jerry Seinfeld','Taking in a baseball game on TV is also a big treat.')");
		db.execSQL("insert into mytable8 values(64,'–Jerry Seinfeld','It takes up enough of my time and interest just working on comedy. I just enjoy it and love doing it.')");
		db.execSQL("insert into mytable8 values(65,'–Elaine Benes','Here is a toast to those who wish us well, and those who do not, can go to hell.')");
		db.execSQL("insert into mytable8 values(66,'–Jerry Seinfeld','Taking in a baseball game on TV is also a big treat.')");
		db.execSQL("insert into mytable8 values(67,'–Jerry Seinfeld','Forty is when you actually begin even deserving to be on stage telling people what you think.')");
		db.execSQL("insert into mytable8 values(68,'','Mr. Peterman: Elaine, can you keep a secret? Elaine: No sir, I can not')");
		db.execSQL("insert into mytable8 values(69,'','George Costanza: What kind of a person are you? Jerry: I think I am pretty much like you, only successful.')");
		db.execSQL("insert into mytable8 values(70,'','Ronnie: I have been living a lie. George Costanza: You have been living a lie? I have been living... like twenty.')");
		db.execSQL("insert into mytable8 values(71,'–George Costanza','Jerry, just remember, it is not a lie if you believe it.')");
		db.execSQL("insert into mytable8 values(72,'–Jerry Seinfeld','Men like a ref decision because they just want to get back to the game.')");
		db.execSQL("insert into mytable8 values(73,'–Jerry Seinfeld','If you go to a bad movie, it is two hours. If you are in a bad movie, it is two years.')");
		db.execSQL("insert into mytable8 values(74,'–Jerry Seinfeld','You know, crankiness is at the essence of all comedy.')");
		db.execSQL("insert into mytable8 values(75,'–Jerry Seinfeld','People who read the tabloids deserve to be lied to.')");
		db.execSQL("insert into mytable8 values(76,'–Jerry Seinfeld','Forty is when you actually begin even deserving to be on stage telling people what you think.')");
		db.execSQL("insert into mytable8 values(77,'–George Costanza','I hate asking for change. They always make a face. It is like asking them to donate a kidney.')");
		
		db.execSQL("insert into mytable8 values(78,'–George Costanza','I hate asking for change. They always make a face. It is like asking them to donate a kidney.')");
		db.execSQL("insert into mytable8 values(79,'–Jerry Seinfeld','If you know what happened in the Mets game do not tell me, I taped it. Hello? ')");
		db.execSQL("insert into mytable8 values(80,'','Jerry: Elaine, breaking up is like knocking over a Coke machine. You can not do it in one push; you gotta rock it back and forth a few times and thenit goes over.')");

db.execSQL("insert into mytable8 values(81,'–Kramer','Yo Yo Ma.')");
db.execSQL("insert into mytable8 values(82,'–Kramer','The cat - mrrreeeooowww - is out of the bag!')");
db.execSQL("insert into mytable8 values(83,'–Gary Fogel','Good for you, Jack!')");
db.execSQL("insert into mytable8 values(84,'–Elaine Benes','We do not know how long this will last. They are a very festive people.')");
		db.execSQL("insert into mytable8 values(85,'–George Costanza','I am speechless. I have no speech.')");
		db.execSQL("insert into mytable8 values(86,'','Elaine: Ugh, I hate people. Jerry: Yeah, they are the worst.')");
		db.execSQL("insert into mytable8 values(87,'-Frank Costanza','George, festivus is your heritage!')");
db.execSQL("insert into mytable8 values(88,'–Frank Costanza','I have been performing feats of strength all morning.')");
db.execSQL("insert into mytable8 values(89,'–Kramer','I am on the Mexican, whoa oh oh, radio.')");
db.execSQL("insert into mytable8 values(90,'','Jerry: George Costanza... Is getting *married*! Elaine: Get out!')");
db.execSQL("insert into mytable8 values(91,'–Jerry Seinfeld','Let us watch them slice this fat bastard up.')");
db.execSQL("insert into mytable8 values(92,'–Babu Bhatt','You very bad man, Jerry. Very bad man.')");
db.execSQL("insert into mytable8 values(93,'','Elaine: Why does everything have to be so... jokey with you? Jerry: I am a comedian.')");
db.execSQL("insert into mytable8 values(94,'','Elaine: Where is Kramer? Jerry: Who knows? it is like asking where is Waldo.')");
db.execSQL("insert into mytable8 values(95,'','Jerry: I can feel his blood in my body, borrowing things from my blood.')");
db.execSQL("insert into mytable8 values(96,'','George: Divorce is always hard. Especially on the kids. Course I am the result of my parents having stayed together so ya never know.')");
db.execSQL("insert into mytable8 values(97,'','Jerry: A house in the Hamptons? George: Yeah. I figured since I was lying about my income for a couple of years, I could afford a fake house in the Hamptons.')");
db.execSQL("insert into mytable8 values(98,'','Jerry: She is one of those low-talkers. You can not hear a word she’s saying! You’re always going ‘excuse me’, what was that?')");
db.execSQL("insert into mytable8 values(99,'','Kramer: Moles — Freckles ugly cousin.')");
db.execSQL("insert into mytable8 values(100,'','Kramer: You know what they say You do not sell the steak, you sell the sizzle.')");
db.execSQL("insert into mytable8 values(101,'','Jerry: You will be stunned. Elaine: Stunned by soup? Jerry: You can not eat this soup standing up. Your knees buckle.')");

db.execSQL("insert into mytable8 values(102,'','George: She is got a little Marissa Tomei thing going on. Jerry: Ah, too bad you have got a little George Costanza thing going on.')");
db.execSQL("insert into mytable8 values(103,'','Jerry: Elaine, breaking up is like knocking over a Coke machine. You can not do it in one push; you gotta rock it back and forth a few times and thenit goes over.')");

		  
		 // Detect touched area 
         detector = new SimpleGestureFilter(this,this);
         c=db.rawQuery("select * from mytable8", null);
	      c.moveToFirst();
	      number=c.getString(0);
	      name=c.getString(1);
	 	 quote=c.getString(2);
	 	//episode=c.getString(3);
	 	 
	 	 t1.setText(quote);
	 	 t2.setText(name);
	 	//t4.setText(episode);
	 	 t5.setText(number+"- 103");
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
	
	}	
	
	public void change()
	{
		 Cursor c=db.rawQuery("select * from mytable8", null);
		 
	      c.moveToNext();
		
			
		 
	      String number=c.getString(0);
	      String name=c.getString(1);
	 	 String quote=c.getString(2);
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
      
 	 Cursor c=db.rawQuery("select * from mytable8", null);
	 c.moveToPosition(n);
		 
      switch (direction) {
      
      case SimpleGestureFilter.SWIPE_LEFT :
      if(n==103)
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
      int randomInt = randomGenerator.nextInt(103);
      n=randomInt;
      c.moveToPosition(n);
                                                     break;
      case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
                                                     break;
      
      }

      number=c.getString(0);
      name=c.getString(1);
 	 quote=c.getString(2);
 	// episode=c.getString(3);
 	 
	 t1.setText(quote);
 	 t2.setText(name);
 	 //t4.setText(episode);
 	 t5.setText(number+" - 103");
     }
      
     @Override
     public void onDoubleTap() {
    		android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
			clipboard.setText(quote+" \n"+name);
            Toast.makeText(getApplicationContext(), "Text Copied To Clipboard", Toast.LENGTH_SHORT).show();
	
      
     }
          
  }
	

