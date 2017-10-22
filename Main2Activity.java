package thesohyproject.codeyouravatar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.transition.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static final String EXTRA_CASE = "";
    public static String EXTRA_NAME = "";

    RadioGroup radioGroup;
    RelativeLayout relativeLayout;
    int choiceOfClothing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        // Set the entered name of the user to the next page
        Intent intent = getIntent();
        String usersName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.usersName);
        textView.setText(usersName);
        EXTRA_NAME = usersName;


        // change the image according to the user's click. If a wrong answer selected, don't do anything
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_main2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    // choiceOfClothing = 1
                    case R.id.radioButton_dress_main3:
                        relativeLayout.getChildAt(1).setVisibility(View.VISIBLE);
                        relativeLayout.getChildAt(2).setVisibility(View.INVISIBLE);
                        choiceOfClothing = 1;
                        break;
                    // choiceOfClothing = 2
                    case R.id.radioButton_pants_main3:
                        relativeLayout.getChildAt(1).setVisibility(View.INVISIBLE);
                        relativeLayout.getChildAt(2).setVisibility(View.VISIBLE);
                        choiceOfClothing = 2;
                        break;
                    // choiceOfClothing = 3
                    default:
                        relativeLayout.getChildAt(1).setVisibility(View.INVISIBLE);
                        relativeLayout.getChildAt(2).setVisibility(View.INVISIBLE);
                        choiceOfClothing = 3;
                        break;

                }
            }

        });

    }

    public void toNextPage(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra(EXTRA_CASE, choiceOfClothing);
        startActivity(intent);

    }


}