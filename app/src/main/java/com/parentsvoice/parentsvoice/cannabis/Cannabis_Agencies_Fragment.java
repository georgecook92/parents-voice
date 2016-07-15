package com.parentsvoice.parentsvoice.cannabis;

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
public class Cannabis_Agencies_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflatedView = inflater.inflate(R.layout.cannabis_agencies_fragment, container, false);


        /* frank  */

        TextView frankNumber = (TextView) inflatedView.findViewById(R.id.frank_number);
        frankNumber.setText(Html.fromHtml(getString(R.string.frank_number)));
        frankNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("02076548400");
            }
        });

        /*  young misuse */

        TextView youngMisuseEmail = (TextView) inflatedView.findViewById(R.id.young_misuse_email);
        youngMisuseEmail.setText(Html.fromHtml(getString(R.string.young_misuse_email)));

        TextView youngMisuseNumber = (TextView) inflatedView.findViewById(R.id.young_misuse_number);
        youngMisuseNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("02083567377");
            }
        });

        /* lifeline  */

        TextView lifelineNumber = (TextView) inflatedView.findViewById(R.id.lifeline_number);
        lifelineNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("02089853757");
            }
        });


        /* hackney misuse  */

        TextView hackneyMisuseNumber = (TextView) inflatedView.findViewById(R.id.hackney_misuse_number);
        hackneyMisuseNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("02083564206");
            }
        });


        /* urban 75 */

        TextView urban75Web = (TextView) inflatedView.findViewById(R.id.urban_75_web);
        urban75Web.setText(Html.fromHtml(getString(R.string.urban_75_web)));

        TextView urban75Number = (TextView) inflatedView.findViewById(R.id.urban_75_number);
        urban75Number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("0800776600");
            }
        });


        /* mind */

        TextView mindWeb = (TextView) inflatedView.findViewById(R.id.mind_web);
        mindWeb.setText(Html.fromHtml(getString(R.string.mind_web)));


        /* young minds */

        TextView youngMindWeb = (TextView) inflatedView.findViewById(R.id.young_mind_web);
        youngMindWeb.setText(Html.fromHtml(getString(R.string.young_minds_web)));

        /* family action */

        TextView familyActionWeb = (TextView) inflatedView.findViewById(R.id.family_action_web);
        familyActionWeb.setText(Html.fromHtml(getString(R.string.family_action_web)));

        /* camhs */

        TextView camhsWeb = (TextView) inflatedView.findViewById(R.id.camhs_web);
        camhsWeb.setText(Html.fromHtml(getString(R.string.camhs_web)));


        return inflatedView;
    }

    private void call(String number) {

        String uri = "tel:" + number.trim();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);

    }
}
