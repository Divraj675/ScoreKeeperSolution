package ca.davidpellegrini.scorekeepersolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener ,RadioGroup.OnCheckedChangeListener  {

    private TextView teamA_textview , teamB_textview , teamA_score_textview , teamB_score_textview;
    private Button  increase_TeamA_Button3 , increase_TeamB_Button,decrease_TeamB_Button,decrease_TeamA_Button;
    private RadioButton radiotwopoints , radiofourpoints , radiosixpoints ;
    private RadioGroup radioGroup;
    private int ScoreValue = 0;
    private int ScoreValue2 = 0;
    private String strScore = "";
    private int changeVal = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamA_textview =(TextView) findViewById(R.id. teamA_textview);
        teamB_textview = (TextView) findViewById(R.id. teamB_textview);
        teamA_score_textview =(TextView) findViewById(R.id.teamA_score_textview);
        teamB_score_textview =(TextView) findViewById(R.id.teamB_score_textview);
        increase_TeamA_Button3 = (Button) findViewById(R.id.increase_TeamA_Button3);
        increase_TeamB_Button = (Button) findViewById(R.id.increase_TeamB_Button);
        decrease_TeamB_Button =(Button) findViewById(R.id.decrease_TeamB_Button);
        decrease_TeamA_Button = (Button) findViewById(R.id.decrease_TeamA_Button);


        radiotwopoints = (RadioButton) findViewById(R.id.radiotwopoints);
        radiofourpoints = (RadioButton) findViewById(R.id.radiofourpoints);
        radiosixpoints = (RadioButton) findViewById(R.id.radiosixpoints);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);


        increase_TeamA_Button3.setOnClickListener(this);
        increase_TeamB_Button.setOnClickListener(this);
        decrease_TeamB_Button .setOnClickListener(this);
        decrease_TeamA_Button.setOnClickListener(this);



        radioGroup.setOnCheckedChangeListener(this);




    }

    public boolean onCreateOptionsMenu( Menu menu){
        getMenuInflater().inflate(
                R.menu.activity_scorekeeper, menu
        );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(
                        getApplicationContext(), SettingsActivity.class
                ));
                return  true;
            case R.id.menu_about:
                Toast.makeText(this, R.string.about_summary, Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


    public void onClick(View v) {
        Log.w("onclick", "onclick" +  changeVal);
        switch (v.getId()) {

            case R.id.increase_TeamA_Button3:
                strScore = teamA_score_textview.getText().toString();
                ScoreValue = Integer.parseInt(strScore);
                ScoreValue += changeVal;
                teamA_score_textview.setText(Integer.toString(ScoreValue ));
                break;

            case R.id.increase_TeamB_Button:
                strScore = teamB_score_textview.getText().toString();
                ScoreValue = Integer.parseInt(strScore);
                ScoreValue += changeVal;
                teamB_score_textview.setText(Integer.toString(ScoreValue ));
                break;

            case R.id.decrease_TeamB_Button:
                strScore = teamB_score_textview.getText().toString();
                ScoreValue = Integer.parseInt(strScore);
                Math.max(0,ScoreValue);
                ScoreValue -= changeVal;
                teamB_score_textview.setText(Integer.toString(ScoreValue ));
                break;

            case R.id.decrease_TeamA_Button:
                strScore = teamA_score_textview.getText().toString();
                ScoreValue = Integer.parseInt(strScore);
                Math.max(0, ScoreValue);
                ScoreValue -= changeVal;
                teamA_score_textview.setText(Integer.toString(ScoreValue ));
                break;






        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedID){
        switch (checkedID){
            case R.id.radiotwopoints:

                changeVal = 2;
                break ;
            case R.id.radiofourpoints:
                changeVal = 4;
                break;
            case R.id.radiosixpoints:
                changeVal = 6;
                break;

        }
    }


        }



