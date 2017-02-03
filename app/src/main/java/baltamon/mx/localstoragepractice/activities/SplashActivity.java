package baltamon.mx.localstoragepractice.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import baltamon.mx.localstoragepractice.MainActivity;
import baltamon.mx.localstoragepractice.R;
import baltamon.mx.localstoragepractice.persistence.UserSession;

/**
 * Created by Baltazar Rodriguez on 01/02/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                UserSession userSession = new UserSession(getApplicationContext());

                if (userSession.isLogged()){
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginRegisterActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 3000);

    }
}
