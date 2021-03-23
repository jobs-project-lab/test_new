package com.example.test;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class freeJobs extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.free_jobs_fragment, container, false);
       /* Users user = new Users();

        EditText em = (EditText) view.findViewById(R.id.email);
        EditText pass = (EditText) view.findViewById(R.id.password);
        EditText conf = (EditText) view.findViewById(R.id.confirm);
        TextView message = (TextView) view.findViewById(R.id.messageLabel);
        Button register = (Button) view.findViewById(R.id.register);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkEmail);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = em.getText().toString();
                String password = pass.getText().toString();
                if(email.matches("") || password.matches("")){
                    message.setText("يرجى عدم ترك حقول فارغة");
                    message.setTextColor(Color.RED);
                    message.setVisibility(View.VISIBLE);
                }else{
                    user.setEmail(email);
                    user.setPassword(password);
                    user.registerFreeJobsAccount(view.getContext(),message);
                }
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    conf.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    conf.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });*/
        return view;
    }
}