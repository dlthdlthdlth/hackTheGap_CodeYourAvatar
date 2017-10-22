package thesohyproject.codeyouravatar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Remember the user's name
        String usersName = Main2Activity.EXTRA_NAME;
        TextView textView = (TextView) findViewById(R.id.usersName);
        textView.setText(usersName);


        // Remember the choice of user's clothing choices
        Intent intent = getIntent();
        int choiceOfClothing = intent.getIntExtra(Main2Activity.EXTRA_CASE, -1);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        switch (choiceOfClothing) {
            case 1:
                relativeLayout.getChildAt(1).setVisibility(View.VISIBLE);
                relativeLayout.getChildAt(2).setVisibility(View.INVISIBLE);
                break;
            case 2:
                relativeLayout.getChildAt(1).setVisibility(View.INVISIBLE);
                relativeLayout.getChildAt(2).setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }

        // change the image according to the user's click. If a wrong answer selected, don't do anything
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_main3);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.radioButton_dress_main3:
                        relativeLayout.getChildAt(3).setVisibility(View.VISIBLE);
                        relativeLayout.getChildAt(4).setVisibility(View.INVISIBLE);
                        break;
                    case R.id.radioButton_pants_main3:
                        relativeLayout.getChildAt(3).setVisibility(View.INVISIBLE);
                        relativeLayout.getChildAt(4).setVisibility(View.VISIBLE);
                        break;
                    default:
                        relativeLayout.getChildAt(3).setVisibility(View.INVISIBLE);
                        relativeLayout.getChildAt(4).setVisibility(View.INVISIBLE);
                        break;

                }
            }


        });

    }


}