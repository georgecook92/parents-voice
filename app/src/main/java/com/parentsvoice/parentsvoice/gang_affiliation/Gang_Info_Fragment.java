package com.parentsvoice.parentsvoice.gang_affiliation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.parentsvoice.parentsvoice.R;

/**
 * Created by georgecook on 12/05/16.
 */
public class Gang_Info_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflatedView = inflater.inflate(R.layout.gang_info_fragment, container, false);

        TextView gangTitle = (TextView) inflatedView.findViewById(R.id.gang_title);
        final SpannableStringBuilder gangTitleString = new SpannableStringBuilder( getString(R.string.gang_title) );
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold
        gangTitleString.setSpan(bss, 0, 14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        gangTitle.setText(gangTitleString);

        return inflatedView;
    }


}
