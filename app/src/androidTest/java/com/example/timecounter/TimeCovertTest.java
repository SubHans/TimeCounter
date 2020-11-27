package com.example.timecounter;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TimeCovertTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void btn(){
        onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void btnBerkalikali(){
        for (int i=0; i<100 ;i++) {
            onView(withId(R.id.button)).perform(click());
        }
    }

    @Test
    public void setJam(){
        onView(withId(R.id.txtJam)).perform(replaceText("1"));
        onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void setMenit(){
        onView(withId(R.id.txtMenit)).perform(replaceText("1"));
        onView(withId(R.id.button)).perform(click());
    }
    @Test
    public void setDetik(){
        onView(withId(R.id.txtDetik)).perform(replaceText("1"));
        onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void setJamDanMenit(){
        onView(withId(R.id.txtJam)).perform(replaceText("1"));
        onView(withId(R.id.txtMenit)).perform(replaceText("1"));
        onView(withId(R.id.button)).perform(click());
    }
    @Test
    public void setJamDanDetik(){
        onView(withId(R.id.txtJam)).perform(replaceText("1"));
        onView(withId(R.id.txtDetik)).perform(replaceText("1"));
        onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void setMenitDanDetik(){
        onView(withId(R.id.txtMenit)).perform(replaceText("1"));
        onView(withId(R.id.txtDetik)).perform(replaceText("1"));
        onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void setWaktuDiMulai0(){
        onView(withId(R.id.txtJam)).perform(replaceText("001"));
        onView(withId(R.id.txtMenit)).perform(replaceText("001"));
        onView(withId(R.id.txtDetik)).perform(replaceText("002"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("3662 Detik")));

    }

    @Test
    public void tesPerhitunganJamKeDetik(){
        onView(withId(R.id.txtJam)).perform(replaceText("1"));
        onView(withId(R.id.txtMenit)).perform(replaceText("0"));
        onView(withId(R.id.txtDetik)).perform(replaceText("0"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("3600 Detik")));
    }

    @Test
    public void tesPerhitunganMenitKeDetik(){
        onView(withId(R.id.txtJam)).perform(replaceText("0"));
        onView(withId(R.id.txtMenit)).perform(replaceText("1"));
        onView(withId(R.id.txtDetik)).perform(replaceText("0"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("60 Detik")));
    }

    @Test
    public void tesPerhitunganDetikKeDetik(){
        onView(withId(R.id.txtJam)).perform(replaceText("0"));
        onView(withId(R.id.txtMenit)).perform(replaceText("0"));
        onView(withId(R.id.txtDetik)).perform(replaceText("1"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("1 Detik")));
    }

    @Test
    public void tesPerhitunganJamDanMenitKeDetik(){
        onView(withId(R.id.txtJam)).perform(replaceText("1"));
        onView(withId(R.id.txtMenit)).perform(replaceText("1"));
        onView(withId(R.id.txtDetik)).perform(replaceText("0"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("3660 Detik")));
    }
    @Test
    public void tesPerhitunganJamDanDetikKeDetik(){
        onView(withId(R.id.txtJam)).perform(replaceText("1"));
        onView(withId(R.id.txtMenit)).perform(replaceText("0"));
        onView(withId(R.id.txtDetik)).perform(replaceText("10"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("3610 Detik")));
    }

    @Test
    public void tesPerhitunganMenitDanDetikKeDetik(){
        onView(withId(R.id.txtJam)).perform(replaceText("0"));
        onView(withId(R.id.txtMenit)).perform(replaceText("1"));
        onView(withId(R.id.txtDetik)).perform(replaceText("10"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("70 Detik")));
    }
    @Test
    public void tesPerhitunganWaktuKeDetik(){
        onView(withId(R.id.txtJam)).perform(replaceText("1"));
        onView(withId(R.id.txtMenit)).perform(replaceText("1"));
        onView(withId(R.id.txtDetik)).perform(replaceText("10"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("3670 Detik")));
    }

    @Test
    public void setDetik1Milliar(){
        onView(withId(R.id.txtJam)).perform(replaceText("0"));
        onView(withId(R.id.txtMenit)).perform(replaceText("0"));
        onView(withId(R.id.txtDetik)).perform(replaceText("1000000000"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("1000000000 Detik")));//1 milliar
    }


    //// Menemukan Bug atau error yang di dapat
    @Test
    public void setIsianBerupaString(){
        onView(withId(R.id.txtJam)).perform(replaceText("ht"));
        onView(withId(R.id.txtMenit)).perform(replaceText("df"));
        onView(withId(R.id.txtDetik)).perform(replaceText("re"));
        onView(withId(R.id.button)).perform(click());
    }
    @Test
    public void setIsianBerupaFloat(){
        onView(withId(R.id.txtJam)).perform(replaceText("1.7"));
        onView(withId(R.id.txtMenit)).perform(replaceText("2.5"));
        onView(withId(R.id.txtDetik)).perform(replaceText("4.4"));
        onView(withId(R.id.button)).perform(click());
    }
    @Test
    public void setIsianBerupaSimbol(){
        onView(withId(R.id.txtJam)).perform(replaceText("#"));
        onView(withId(R.id.txtMenit)).perform(replaceText("%"));
        onView(withId(R.id.txtDetik)).perform(replaceText("!"));
        onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void setJam1Milliar(){
        onView(withId(R.id.txtJam)).perform(replaceText("1000000000"));
        onView(withId(R.id.txtMenit)).perform(replaceText("0"));
        onView(withId(R.id.txtDetik)).perform(replaceText("0"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("3600000000000 Detik")));//tiga ratus enam puluh milliar
    }
    @Test
    public void setMenit1Milliar(){
        onView(withId(R.id.txtJam)).perform(replaceText("0"));
        onView(withId(R.id.txtMenit)).perform(replaceText("1000000000"));
        onView(withId(R.id.txtDetik)).perform(replaceText("0"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.texthasil)).check(matches(withText("60000000000 Detik")));//enam puluh milliar
    }
}
