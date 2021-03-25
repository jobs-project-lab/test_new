package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class verfy_phone extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verfy_phone);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        String phone = getIntent().getStringExtra("phone");
        TextView phone_text = (TextView)findViewById(R.id.phone_text);
        String text_phone = phone_text.getText().toString() +"\n" + phone;
        phone_text.setText(text_phone);
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                TextView status = (TextView)findViewById(R.id.code_status);
                status.setText("تم التأكيد بنجاح");
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                TextView status = (TextView)findViewById(R.id.code_status);
                status.setText(e.getLocalizedMessage());
            }
            @Override
            public void onCodeSent(@Nullable String verificationId,@Nullable PhoneAuthProvider.ForceResendingToken token){
                TextView status = (TextView)findViewById(R.id.code_status);
                status.setText("تم إرسال الرمز");
            }
        };
        String test = "R2Rra24fVm5xa2Mg";
        byte[] nonce = test.getBytes();
        SafetyNet.getClient(this).attest(nonce,"AIzaSyAaN42tO1Dtaa0VkB7EuqJw9O_mCBDV5yo").addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.AttestationResponse>() {
            @Override
            public void onSuccess(SafetyNetApi.AttestationResponse attestationResponse) {
                startPhoneNumberVerification(phone);
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
    private void startPhoneNumberVerification(String phoneNumber) {
        // [START start_phone_auth]
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
        // [END start_phone_auth]
    }
}