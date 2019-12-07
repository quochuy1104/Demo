package com.example.admin.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.demo.Common.Common;
import com.example.admin.demo.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    EditText editPhone, editPassWord;
    Button btnSingIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnSingIn = (Button) findViewById(R.id.btnLogin);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editPassWord= (EditText) findViewById(R.id.editPassword);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog((SignIn.this));
                mDialog.setMessage("Xin chờ");
                mDialog.show();
                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            mDialog.dismiss();
                            if(dataSnapshot.child(editPhone.getText().toString()).exists()){
                            User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                            if(user.getPassword().equals(editPassWord.getText().toString())){
                                Intent homeIntent = new Intent(SignIn.this,Home.class);
                                Common.currentUser= user;
                                startActivity(homeIntent);
                                finish();
                            }
                            else{
                                Toast.makeText(SignIn.this,"Nhập sai mật khẩu",Toast.LENGTH_SHORT).show();

                            }}
                            else{
                                Toast.makeText(SignIn.this,"Không tìm thấy SĐT này",Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            }});
    }
}
