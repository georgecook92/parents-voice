package com.parentsvoice.parentsvoice.gang_affiliation;

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
public class Gang_Agencies_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflatedView = inflater.inflate(R.layout.gang_agencies_fragment, container, false);


        /* Four front project */

        TextView four_project_text = (TextView) inflatedView.findViewById(R.id.four_project_text);
        four_project_text.setText(Html.fromHtml(getString(R.string.four_front_project_web)));

        TextView four_project_number = (TextView) inflatedView.findViewById(R.id.four_project_id);
        four_project_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("07908077917");
            }
        });


        /* Safeguarding children */

        TextView chscb_email = (TextView) inflatedView.findViewById(R.id.chscb_email);
        chscb_email.setText(Html.fromHtml(getString(R.string.chscb_email)));

        TextView chscb_number = (TextView) inflatedView.findViewById(R.id.chscb_number);
        chscb_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("02083565500");
            }
        });


        /*godwin lawson*/

        TextView glEmail = (TextView) inflatedView.findViewById(R.id.godwin_lawson_email);
        glEmail.setText(Html.fromHtml(getString(R.string.godwin_lawson_email)));

        TextView glNumber = (TextView) inflatedView.findViewById(R.id.godwin_lawson_number);
        glNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("02037517285");
            }
        });

        /* Family lives  */

        TextView flWeb = (TextView) inflatedView.findViewById(R.id.family_lives_web);
        flWeb.setText(Html.fromHtml(getString(R.string.family_lives_web)));

        TextView flNumber = (TextView) inflatedView.findViewById(R.id.family_lives_number);
        flNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("08088002222");
            }
        });

        /* gangs line  */

        TextView gangLineWeb = (TextView) inflatedView.findViewById(R.id.gangs_line_web);
        gangLineWeb.setText(Html.fromHtml(getString(R.string.gangs_line_web)));

        TextView ganglineNumber = (TextView) inflatedView.findViewById(R.id.gangs_line_number);
        ganglineNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("08000329538");
            }
        });

        /* nspcc  */

        TextView nspccWeb = (TextView) inflatedView.findViewById(R.id.nspcc_web);
        nspccWeb.setText(Html.fromHtml(getString(R.string.nspcc_web)));

        TextView nspccEmail = (TextView) inflatedView.findViewById(R.id.nspcc_email);
        nspccEmail.setText(Html.fromHtml(getString(R.string.nspcc_email)));

        TextView nspccNumber = (TextView) inflatedView.findViewById(R.id.nspcc_number);
        nspccNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("08088005000");
            }
        });



        /* crib */

        TextView crib_web = (TextView) inflatedView.findViewById(R.id.crib_web);
        crib_web.setText(Html.fromHtml(getString(R.string.crib_web)));

        TextView crib_email = (TextView) inflatedView.findViewById(R.id.crib_email);
        crib_email.setText(Html.fromHtml(getString(R.string.crib_email)));

        TextView crib_number = (TextView) inflatedView.findViewById(R.id.crib_number);
        crib_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("07813901751");
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
