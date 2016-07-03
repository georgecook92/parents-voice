package com.parentsvoice.parentsvoice.domestic_violence;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parentsvoice.parentsvoice.R;

/**
 * Created by georgecook on 12/05/16.
 */
public class Domestic_Violence_Agencies_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflatedView = inflater.inflate(R.layout.violence_agencies_fragment, container, false);

        /* Mens advice */

        TextView mens_advice_email = (TextView) inflatedView.findViewById(R.id.mens_advice_email);
        mens_advice_email.setText(Html.fromHtml(getString(R.string.mens_advice_email)));

        TextView mens_advice_number = (TextView) inflatedView.findViewById(R.id.mens_advice_number);
        mens_advice_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("08088010327");
            }
        });

                /* domestic violence agency */

        TextView dvh_number = (TextView) inflatedView.findViewById(R.id.domestic_violence_helpline_number);
        dvh_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("08082000247");
            }
        });


        /* Safeguarding children */


        TextView chscb_email = (TextView) inflatedView.findViewById(R.id.chscb_email_abuse);
        chscb_email.setText(Html.fromHtml(getString(R.string.chscb_email)));

        TextView chscb_number = (TextView) inflatedView.findViewById(R.id.chscb_number_abuse);
        chscb_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("02083565500");
            }
        });

        /* Daymer */

        TextView daymer_email = (TextView) inflatedView.findViewById(R.id.daymer_email);
        daymer_email.setText(Html.fromHtml(getString(R.string.daymer_email)));

        TextView daymer_number = (TextView) inflatedView.findViewById(R.id.daymer_number);
        daymer_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("02072758440");
            }
        });


        /* Broken rainbow */

        TextView br_email = (TextView) inflatedView.findViewById(R.id.broken_rainbow_email);
        br_email.setText(Html.fromHtml(getString(R.string.broken_rainbow_email)));

        TextView br_number = (TextView) inflatedView.findViewById(R.id.broken_rainbow_number);
        br_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("08009995428");
            }
        });

        /* childline */

        TextView childline_number = (TextView) inflatedView.findViewById(R.id.childline_number);
        childline_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("08001111");
            }
        });


        /* mosac */

        TextView mosac_email = (TextView) inflatedView.findViewById(R.id.mosac_email);
        mosac_email.setText(Html.fromHtml(getString(R.string.mosac_email)));

        TextView mosac_number = (TextView) inflatedView.findViewById(R.id.mosac_number);
        mosac_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("08009801958");
            }
        });



        return inflatedView;
    }

    private void call(String number) {

        String uri = "tel:" + number.trim();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);

    }

}
