package baltamon.mx.localstoragepractice.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import baltamon.mx.localstoragepractice.MainActivity;
import baltamon.mx.localstoragepractice.R;
import baltamon.mx.localstoragepractice.models.UserModel;
import baltamon.mx.localstoragepractice.persistence.UserSession;

/**
 * Created by Baltazar Rodriguez on 01/02/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText userName;
    private EditText userEmail;
    private EditText userPhone;
    private EditText userPassword;
    private EditText repeatPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbarConfiguration();
    }

    private void toolbarConfiguration() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register into LocalStorage");

        //ENABLE BACK ARROW
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        startVariables();
    }

    public void startVariables(){
        userName = (EditText)findViewById(R.id.etUserName);
        userEmail = (EditText) findViewById(R.id.etEmailAddress);
        userPhone = (EditText) findViewById(R.id.etPhoneNumer);
        userPassword = (EditText) findViewById(R.id.etPassword);
        repeatPassword = (EditText) findViewById(R.id.etRepeatPassword);

        Button button_register = (Button) findViewById(R.id.btnRegister);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields()){
                    saveUserData();
                }
            }
        });
    }

    public void saveUserData(){
        UserSession userSession =  new UserSession(this);
        if (!userSession.isLogged()){
            UserModel userModel = new UserModel();
            userModel.setUserName(userName.getText().toString());
            userModel.setUserEmail(userEmail.getText().toString());
            userModel.setUserPhone(userPhone.getText().toString());
            userModel.setUserPassword(userPassword.getText().toString());

            userSession.saveUserData(userModel);

            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "User already logged", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validateFields(){

        if (userName.getText().toString().equals("")){
            userName.setError("Null value");
            return false;
        } else if (userEmail.getText().toString().equals("")){
            userEmail.setError("Null value");
            return false;
        } else if (userPhone.getText().toString().equals("")){
            userPhone.setError("Null value");
            return false;
        } else if (userPassword.getText().toString().equals("")){
            userPassword.setError("Null value");
            return false;
        } else if (!userPassword.getText().toString().equals(repeatPassword.getText().toString())){
            repeatPassword.setError("The values are not the same");
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //ON BACK ARROW PRESSED
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LoginRegisterActivity.class));
        finish();
    }
}
