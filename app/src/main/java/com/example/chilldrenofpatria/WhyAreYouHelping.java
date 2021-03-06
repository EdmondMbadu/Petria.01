package com.example.chilldrenofpatria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WhyAreYouHelping extends AppCompatActivity  implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_why_are_you_helping);

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("HP: "+sch1.health+"  SS: "+ sch1.spellSlot+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollWhYAreYouHelping);
        String text="“Why are you helping me?” you ask.\n" +
                "Silence fills the room as she looks at you.\n" +
                "“I’m helping you so that, if you’re willing, you can help me in gratitude for saving your family’s life,” she says.\n" +
                "“Help you with what?” you wonder.\n" +
                "“That is a discussion I will be more than happy to have with you. Unfortunately, now is not the time for it. We do not have all night. In fact I think now is a good time to start.”\n";

        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonWhYAreYouHelpingContinue= findViewById(R.id.button_whyAreYouHelpingContinue);

        buttonWhYAreYouHelpingContinue.setOnClickListener(this);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book1, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.goback:
                intent= new Intent(this, Book1Activity.class).putExtra("from", "WhyAreYouHelping");
                startActivity(intent);
                break;
        }



        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.button_whyAreYouHelpingContinue:
                intent = new Intent(this, WhoAreYouContinue.class).putExtra("from", "WhyAreYouHelping");
                startActivity(intent);
                break;

        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "WhyAreYouHelping");
        startActivity(intent);


    }

}
