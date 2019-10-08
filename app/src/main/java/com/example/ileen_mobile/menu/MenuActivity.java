package com.example.ileen_mobile.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ileen_mobile.R;
import com.example.ileen_mobile.login.PlayActivity;
import com.example.ileen_mobile.menu.fragments.MenuFragment2;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void handlerBack(View view) {
        Intent intent =  new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

    public void handlerMenu1(View view) {
        Fragment MenuFragment1=getSupportFragmentManager().findFragmentByTag("MENU1_FRAGMENT");

        if(MenuFragment1!=null && MenuFragment1.isVisible()){

        }
        else {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_left);
            fragmentTransaction.replace(R.id.frameLayout,new MenuFragment2(),"MENU_FRAGMENT");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void handlerMenu2(View view) {
        Fragment MenuFragment2=getSupportFragmentManager().findFragmentByTag("MENU2_FRAGMENT");

        if(MenuFragment2!=null && MenuFragment2.isVisible()){

        }
        else {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_left);
            fragmentTransaction.replace(R.id.frameLayout,new MenuFragment2(),"MENU2_FRAGMENT");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
