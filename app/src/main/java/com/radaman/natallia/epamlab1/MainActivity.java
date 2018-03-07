package com.radaman.natallia.epamlab1;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Natallia Radaman
 * @since 07-03-2018
 */

public class MainActivity extends AppCompatActivity {

    TextView question;
    TextView dayCounter;
    Button buttonHowMuch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView)findViewById(R.id.question_holiday);
        dayCounter = (TextView)findViewById(R.id.day_counter);
        buttonHowMuch = (Button)findViewById(R.id.button_howMuch);

        buttonHowMuch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.setVisibility(View.INVISIBLE);
                dayCounter.setVisibility(View.VISIBLE);
                Date dateOfEvent = dateOfEvent();
                int countOfDays = dayCount(dateOfEvent);
                if (countOfDays > 0) {
                    dayCounter.setText(String.valueOf(dayCount(dateOfEvent)));
                } else if (countOfDays == 0) {
                    dayCounter.setText("Праздники начинаются сегодня, пора отдыхать!");
                } else {
                    dayCounter.setText("К сожалению праздники уже прошли");
                }

            }
        });

    }

    /**
     * Function for the date parsing
     * @return null or date of Event
     */
    @Nullable
    public Date dateOfEvent() {
        String date1May = "01.05.2018";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfEvent = null;
        try {
            dateOfEvent = format.parse(date1May);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateOfEvent;
    }

    /**
     * Function for counting the number of days left before the event
     * @param dateOfEvent - Date format
     */
    public int dayCount(Date dateOfEvent) {
        Date dateNow  = new Date();
        long timeDifference = dateOfEvent.getTime() - dateNow.getTime();
        System.out.println(String.valueOf(timeDifference));
        int numberOfDays = (int)(timeDifference/(24*60*60*1000));
        return numberOfDays;
    }

}
