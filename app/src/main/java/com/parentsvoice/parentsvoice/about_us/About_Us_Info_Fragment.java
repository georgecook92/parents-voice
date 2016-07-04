package com.parentsvoice.parentsvoice.about_us;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parentsvoice.parentsvoice.R;

import org.w3c.dom.Text;

/**
 * Created by georgecook on 21/06/16.
 */
public class About_Us_Info_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflatedView = inflater.inflate(R.layout.about_info_fragment, container, false);

        SharedPreferences prefs = getActivity().getSharedPreferences("count", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        final int count = prefs.getInt("counter", 0);


        //layouts for buttons
        final LinearLayout initQuestionlayout = (LinearLayout) inflatedView.findViewById(R.id.question_application);
        final LinearLayout rateApplicationlayout = (LinearLayout) inflatedView.findViewById(R.id.rate_application);
        final LinearLayout feedbackApplicationlayout = (LinearLayout) inflatedView.findViewById(R.id.feedback_application);

        if (count < 3) {
            initQuestionlayout.setVisibility(View.GONE);
        }


        //buttons for initial question
        Button question_no_button = (Button) inflatedView.findViewById(R.id.question_no);
        Button question_yes_button = (Button) inflatedView.findViewById(R.id.question_yes);

        //buttons for feedback questions (clicked no initially)
        Button feedback_no_button = (Button) inflatedView.findViewById(R.id.feedback_no);
        Button feedback_yes_button = (Button) inflatedView.findViewById(R.id.feedback_yes);

        //buttons for appstore
        Button rating_no_button = (Button) inflatedView.findViewById(R.id.rating_no);
        Button rating_yes_button = (Button) inflatedView.findViewById(R.id.rating_yes);



        //init question handlers
        question_yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initQuestionlayout.setVisibility(View.GONE);
                rateApplicationlayout.setVisibility(View.VISIBLE);
            }
        });

        question_no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initQuestionlayout.setVisibility(View.GONE);
                feedbackApplicationlayout.setVisibility(View.VISIBLE);
                editor.putInt("counter", 0);
                editor.commit();
            }
        });



        //feedback handlers

        feedback_yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback For Parents Voice Android Application");

                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        feedback_no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackApplicationlayout.setVisibility(View.GONE);
                editor.putInt("counter", 0);
                editor.commit();
            }
        });


        //app store handlers

        rating_yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateApplicationlayout.setVisibility(View.GONE);
                Uri uri = Uri.parse("market://details?id=" + getActivity().getPackageName());
                Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
                myAppLinkToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(myAppLinkToMarket);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), " unable to find market app", Toast.LENGTH_LONG).show();
                }

            }
        });

        rating_no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateApplicationlayout.setVisibility(View.GONE);
                editor.putInt("counter", 0);
                editor.commit();
            }
        });



        return inflatedView;
    }

}
