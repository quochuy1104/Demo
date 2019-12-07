package com.example.admin.demo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.demo.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    EditText editUsername, editPassWord,editPhone;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = (Button) findViewById(R.id.btnRegister);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassWord= (EditText) findViewById(R.id.editPassword);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog((SignUp.this));
                mDialog.setMessage("Xin chờ");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                      if(dataSnapshot.child(editPhone.getText().toString()).exists()){
                            mDialog.dismiss();;
                            Toast.makeText(SignUp.this,"SĐT này đã đăng kí ",Toast.LENGTH_SHORT);
                        }
                      else{
                            mDialog.dismiss();
                            User user = new User(editUsername.getText().toString(),editPassWord.getText().toString());
                            table_user.child(editPhone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this,"Đăng kí thành công, vui lòng đăng nhập",Toast.LENGTH_SHORT);
                            finish();
                      }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }});
    }
}
