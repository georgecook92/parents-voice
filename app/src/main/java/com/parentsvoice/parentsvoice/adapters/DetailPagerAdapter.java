package com.parentsvoice.parentsvoice.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.parentsvoice.parentsvoice.cannabis.Cannabis_Agencies_Fragment;
import com.parentsvoice.parentsvoice.cannabis.Cannabis_Info_Fragment;
import com.parentsvoice.parentsvoice.cannabis.Cannabis_Safeguard_Fragment;
import com.parentsvoice.parentsvoice.domestic_violence.Domestic_Violence_Agencies_Fragment;
import com.parentsvoice.parentsvoice.domestic_violence.Domestic_Violence_Info_Fragment;
import com.parentsvoice.parentsvoice.domestic_violence.Domestic_Violence_Safeguard_Fragment;
import com.parentsvoice.parentsvoice.gang_affiliation.Gang_Agencies_Fragment;
import com.parentsvoice.parentsvoice.gang_affiliation.Gang_Info_Fragment;
import com.parentsvoice.parentsvoice.gang_affiliation.Gang_Safeguard_Fragment;
import com.parentsvoice.parentsvoice.sexual_exploitation.Exploitation_Agencies_Fragment;
import com.parentsvoice.parentsvoice.sexual_exploitation.Exploitation_Info_Fragment;
import com.parentsvoice.parentsvoice.sexual_exploitation.Exploitation_Safeguard_Fragment;

/**
 * Created by georgecook on 12/05/16.
 */
public class DetailPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    String page;

    public DetailPagerAdapter(FragmentManager fm, int NumOfTabs, String page) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.page = page;
    }

    @Override
    public Fragment getItem(int position) {

        if (page.equals("Gang Affiliation")) {
            switch (position) {
                case 0:
                    Gang_Info_Fragment tab1 = new Gang_Info_Fragment();
                    return tab1;
                case 1:
                    Gang_Safeguard_Fragment tab2 = new Gang_Safeguard_Fragment();
                    return tab2;
                case 2:
                    Gang_Agencies_Fragment tab3 = new Gang_Agencies_Fragment();
                    return tab3;
                default:
                    return null;
            }

        }

        else if (page.equals("Domestic Violence")) {
            switch (position) {
                case 0:
                    Domestic_Violence_Info_Fragment tab1 = new Domestic_Violence_Info_Fragment();
                    return tab1;
                case 1:
                    Domestic_Violence_Safeguard_Fragment tab2 = new Domestic_Violence_Safeguard_Fragment();
                    return tab2;
                case 2:
                    Domestic_Violence_Agencies_Fragment tab3 = new Domestic_Violence_Agencies_Fragment();
                    return tab3;
                default:
                    return null;
            }
        }

        else if (page.equals("Sexual Exploitation")) {
            switch (position) {
                case 0:
                    Exploitation_Info_Fragment tab1 = new Exploitation_Info_Fragment();
                    return tab1;
                case 1:
                    Exploitation_Safeguard_Fragment tab2 = new Exploitation_Safeguard_Fragment();
                    return tab2;
                case 2:
                    Exploitation_Agencies_Fragment tab3 = new Exploitation_Agencies_Fragment();
                    return tab3;
                default:
                    return null;
            }
        }

        else if (page.equals("Cannabis & Mental Health")) {
            switch (position) {
                case 0:
                    Cannabis_Info_Fragment tab1 = new Cannabis_Info_Fragment();
                    return tab1;
                case 1:
                    Cannabis_Safeguard_Fragment tab2 = new Cannabis_Safeguard_Fragment();
                    return tab2;
                case 2:
                    Cannabis_Agencies_Fragment tab3 = new Cannabis_Agencies_Fragment();
                    return tab3;
                default:
                    return null;
            }
        }



        else return null;


    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
