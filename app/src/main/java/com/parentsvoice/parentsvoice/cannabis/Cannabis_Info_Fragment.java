package com.parentsvoice.parentsvoice.cannabis;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parentsvoice.parentsvoice.R;

/**
 * Created by georgecook on 12/05/16.
 */
public class Cannabis_Info_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflatedView = inflater.inflate(R.layout.cannabis_info_fragment, container, false);

        TextView spiceWeb = (TextView) inflatedView.findViewById(R.id.spice);

        final SpannableStringBuilder spiceString = new SpannableStringBuilder( getString(R.string.spice) );
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold
        // Span to set text color to some RGB value
        final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.rgb(62, 131, 255));
        spiceString.setSpan(fcs, 70, 74, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spiceString.setSpan(bss, 70, 74, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spiceWeb.setText(spiceString);

        spiceWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri webPage = Uri.parse("http://www.drugwise.org.uk/synthetic-cannabinoids/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
                startActivity(intent);


            }
        });


        return inflatedView;
    }

}
