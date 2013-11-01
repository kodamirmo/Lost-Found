package com.pawhub.lostandfound;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.*;
import com.facebook.model.*;

public class LoginScreen extends Activity implements OnClickListener{
        
        private ImageButton btnLogin;
        private ImageButton btnLoginFacebook;
        private TextView register;
        
        private UiLifecycleHelper uiHelper;
        private Session.StatusCallback callback = new Session.StatusCallback() {

                @Override
                public void call(Session session, SessionState state,
                                Exception exception) {
                        
                        Log.i("TAG", "!SESION: "+ session.getState());
                        
                        
                        if (session.isOpened()) {
                                
                                Request.newMeRequest(session, new Request.GraphUserCallback() {

                                        @Override
                                        public void onCompleted(GraphUser user,
                                                        Response response) {
                                                
                                                Log.i("TAG","Response " + response);
                                                Log.i("TAG","User " + user);
                                                
                                                
                                                if (user != null) {
                                                        String id=user.getId();
                                                        String name=user.getName();
                                                        
                                                        //ConfigData.setUserId(getBaseContext(), id);
                                                        //ConfigData.setUserName(getBaseContext(), name);
                                                        
                                                        Log.i("TAG","Sesion iniciada");
                                                        simpleLogin();
                                                }else{
                                                        Log.i("TAG","No se puede iniciar sesion, usuario null");
                                                }
                                        }
                                }).executeAsync();
                        }
                        else{
                                Log.i("TAG","No se puede iniciar sesion, no sesion abierta");
                                //initFacebookSession();
                        }
                }
        };
        
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login_screen);
                
                uiHelper = new UiLifecycleHelper(this, callback);
                uiHelper.onCreate(savedInstanceState);               
                
                initViews();
        }
        
        private void initViews(){
                TextView appTitle = (TextView) findViewById(R.id.login_app_tittle);
                
                SpannableString text = new SpannableString("" + appTitle.getText());
                text.setSpan(new ForegroundColorSpan(Color.rgb(99, 194, 208)), 0, 4, 0);
                text.setSpan(new ForegroundColorSpan(Color.rgb(255, 255, 255)), 5, 7, 1);
                text.setSpan(new ForegroundColorSpan(Color.rgb(255, 212, 0)), 7,
                                text.length(), 2);
                appTitle.setText(text, BufferType.SPANNABLE);

                TextView appsubTitle = (TextView) findViewById(R.id.login_app_subtittle);
                appsubTitle.setTypeface(null, Typeface.BOLD);
                
                btnLoginFacebook=(ImageButton)findViewById(R.id.loginFbBtn);
                btnLogin=(ImageButton)findViewById(R.id.loginBtn);
                register = (TextView) findViewById(R.id.register);
                
                btnLogin.setOnClickListener(this);
                btnLoginFacebook.setOnClickListener(this);
                register.setOnClickListener(this);
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
         super.onSaveInstanceState(outState);
         uiHelper.onSaveInstanceState(outState);
        }
        
        private void initFacebookSession(){
                
                Session.openActiveSession(this, true,callback);
        }

        public void simpleLogin(){
                Intent home=new Intent(this,Home.class);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(home);
                this.finish();
        }
        
        public void registerUser() {
        	Intent registerIntent =new Intent(this,RegisterActivity.class);
            startActivity(registerIntent);
		}
        
        @Override
        public void onClick(View v) {
                if(v==btnLoginFacebook)
                	initFacebookSession();
                else if(v==btnLogin)
                    simpleLogin();
                else if(v==register)
                	registerUser();
                
        }
        
        

		@Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                Session.getActiveSession().onActivityResult(this, requestCode,
                                resultCode, data);
        }
}