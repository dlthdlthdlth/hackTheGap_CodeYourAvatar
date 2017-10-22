package thesohyproject.codeyouravatar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // link with editText_enterName_main; make it go to the next page
    public void toNextPage(View view) {
        EditText enterName = (EditText) findViewById(R.id.editText_enterName_main);
        Intent intent = new Intent(this, Main2Activity.class);
        String usersName = enterName.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, usersName);
        startActivity(intent);
    }


}