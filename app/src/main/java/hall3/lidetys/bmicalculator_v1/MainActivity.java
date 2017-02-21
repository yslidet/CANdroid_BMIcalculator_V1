package hall3.lidetys.bmicalculator_v1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare variable
    EditText hEdit;
    EditText wEdit;
    Button btnCal;
    TextView txtBMI;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //give the value to variable
        hEdit = (EditText) findViewById(R.id.edit_h);
        wEdit = (EditText) findViewById(R.id.edit_w);
        btnCal = (Button) findViewById(R.id.btn_cal);
        txtBMI = (TextView) findViewById(R.id.txt_bmi);
        img = (ImageView) findViewById(R.id.img);


    }

    //1. CalculateBMI
    public void calculateBMI1 (View view){

        //calculateBMI -> need variable -> double resultBMI;
        double resultBMI = 0.0;
        double weight = 0.0;
        double height = 0.0;

        //get value from UI
        weight = Double.valueOf(wEdit.getText().toString());    //<< IMPORTANT: to get value from EditText
        height = Double.valueOf(hEdit.getText().toString());    //<< IMPORTANT: to get value from EditText

        //calculate
        height = height/100;                //convert cm to m
        resultBMI = weight / (height*height);

        //show at txtBMI
        txtBMI.setText(String.valueOf(resultBMI));

        //show image
        img.setImageResource(R.drawable.sir);

        //add pop up
        Toast.makeText(getApplicationContext(), "Like a BAWS", Toast.LENGTH_LONG).show();
    }

    /* 2. Add condition => Pop up => Image
    Underweight = <18.5
    Normal weight = 18.5–24.9
    Overweight = 25–29.9
    Obesity = BMI of 30 or greater
     */
    public void calculateBMI2 (View view){

        //calculateBMI -> need variable -> double resultBMI;
        double resultBMI = 0.0;
        double weight = 0.0;
        double height = 0.0;

        //get value from UI
        weight = Double.valueOf(wEdit.getText().toString());    //<< IMPORTANT: to get value from EditText
        height = Double.valueOf(hEdit.getText().toString());    //<< IMPORTANT: to get value from EditText

        //check the input
        if (weight<=0 || height<=0){             //    "||" means "or"
            resultBMI = 0;                      // so that it would message "invalid input" >> look below
        }
        else{
            //calculate
            height = height/100;                //convert cm to m
            resultBMI = weight / (height*height);
        }


        if (resultBMI < 18.5 && resultBMI > 0) {     //normal

            txtBMI.setText(String.valueOf(resultBMI));    //show at txtBMI
            img.setImageResource(R.drawable.under);        //show image
            Toast.makeText(getApplicationContext(), "Food! I need FOOD!!", Toast.LENGTH_LONG).show( );  //add pop up
        }
        else if (resultBMI >= 18.5 && resultBMI < 25){
            txtBMI.setText(String.valueOf(resultBMI));    //show at txtBMI
            img.setImageResource(R.drawable.normal);        //show image
            Toast.makeText(getApplicationContext(), "Oh Yeah! I am HAWT", Toast.LENGTH_LONG).show( );  //add pop up
        }

        else if (resultBMI >= 25 && resultBMI < 30){
            txtBMI.setText(String.valueOf(resultBMI));    //show at txtBMI
            img.setImageResource(R.drawable.over);        //show image
            Toast.makeText(getApplicationContext(), "I gotta EXERCISE (to eat more. heheh)", Toast.LENGTH_LONG).show( );  //add pop up
        }

        else if (resultBMI >= 30) {
            txtBMI.setText(String.valueOf(resultBMI));    //show at txtBMI
            img.setImageResource(R.drawable.toomuch);        //show image
            Toast.makeText(getApplicationContext(), "I can do this", Toast.LENGTH_LONG).show( );  //add pop up
        }

        else{
            txtBMI.setText("MEH!!");    //show at txtBMI
            img.setImageResource(R.drawable.robot);        //show image
            Toast.makeText(getApplicationContext(), "Check if you put weight and height correctly", Toast.LENGTH_LONG).show( );  //add pop up
        }

    }



}
