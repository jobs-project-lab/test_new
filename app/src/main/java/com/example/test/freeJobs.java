package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

import static android.content.ContentValues.TAG;

public class freeJobs extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.free_jobs_fragment, container, false);
        EditText em = (EditText) view.findViewById(R.id.phone);
        EditText pass = (EditText) view.findViewById(R.id.password);
        EditText conf = (EditText) view.findViewById(R.id.confirm);
        TextView message = (TextView) view.findViewById(R.id.messageLabel);
        Button register = (Button) view.findViewById(R.id.register);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkEmail);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    conf.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    conf.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = em.getText().toString();
                String password = pass.getText().toString();
                String confirm = conf.getText().toString();
                if (email.matches("") || password.matches("")) {
                    message.setText("يرجى عدم ترك حقول فارغة");
                    message.setTextColor(Color.RED);
                    message.setVisibility(View.VISIBLE);
                } else {
                    if(password.matches(confirm)){
                        Intent intent = new Intent(v.getContext(),verfy_phone.class);
                        startActivity(intent);
                    }else{
                        message.setText("كلمتا المرور غير متطابقتين");
                        message.setTextColor(Color.RED);
                        message.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        return view;
    }
}