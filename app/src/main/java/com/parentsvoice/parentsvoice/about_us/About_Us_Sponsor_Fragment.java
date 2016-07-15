package com.parentsvoice.parentsvoice.about_us;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.parentsvoice.parentsvoice.R;

/**
 * Created by georgecook on 21/06/16.
 */
public class About_Us_Sponsor_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflatedView = inflater.inflate(R.layout.about_sponsor_fragment, container, false);

        ImageView crib_image = (ImageView) inflatedView.findViewById(R.id.crib_image_view);
        ImageView nhs_image = (ImageView) inflatedView.findViewById(R.id.nhs_image_view);
        ImageView abc_image = (ImageView) inflatedView.findViewById(R.id.abc_image_view);

        crib_image.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.crib_image, 90, 90));

        nhs_image.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.nhs_image, 90, 90));

        abc_image.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.abc_logo, 90, 90));


        crib_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("http://thecrib.org.uk/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
                startActivity(intent);
            }
        });


        return inflatedView;
    }


    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

}
