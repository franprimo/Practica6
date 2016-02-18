package com.example.franprimo.practica6;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

/**
 * Created by FranPrimo on 18/2/16.
 */
public class MainTests extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;

    public MainTests() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception{
        activity = getActivity();
    }

    public void testPreconditions() {
        assertNotNull(activity);
    }

    public void testNum1(){
        final EditText num1 = (EditText) activity.findViewById(R.id.numero1);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                num1.requestFocus();
            }
        });

        getInstrumentation().sendStringSync("-2");

        int numero1 = Integer.parseInt(num1.getText().toString());
        assertTrue("Numero 1 no es positivo", numero1 >= 0);
    }

    public void testNum2(){
        final EditText num2 = (EditText) activity.findViewById(R.id.numero2);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                num2.requestFocus();
            }
        });

        getInstrumentation().sendStringSync("2");
        int numero2 = Integer.parseInt(num2.getText().toString());
        assertTrue("Numero 2 no es positivo", numero2 >= 0);
    }

}
