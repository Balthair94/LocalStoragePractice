package baltamon.mx.localstoragepractice.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import baltamon.mx.localstoragepractice.R;

/**
 * Created by Baltazar Rodriguez on 01/02/2017.
 */

public class LoginRegisterActivity extends AppCompatActivity {

    private Button mButtonLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        toolbarConfiguration();

        variablesDeclaration();
    }

    private void variablesDeclaration() {
        mButtonLogin = (Button) findViewById(R.id.btnLogin);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginRegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void toolbarConfiguration() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Welcome to LocalStorage");
    }
}
