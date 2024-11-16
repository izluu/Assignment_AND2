package izisluu.fpoly.assignment_and2.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import izisluu.fpoly.assignment_and2.R;
import izisluu.fpoly.assignment_and2.Model.User;

public class LoginActivity extends AppCompatActivity {
    private TextView txtRegister;
    private EditText edtUsername,edtPassword;
    private Button btnLogin;
    private ArrayList<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtRegister= findViewById(R.id.txtRegister);
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        btnLogin = findViewById(R.id.btnLogin);
        users = new ArrayList<>();
        users.add(new User("admin","123","admin"));
        txtRegister.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
        Login();

    }
    public void isValid(){
        if (edtUsername.getText().toString().isEmpty()||edtPassword.getText().toString().isEmpty()){
            Toast.makeText(this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
        }
        for (User user: users) {
            if(edtUsername.getText().toString().equals(user.getUsername())&&edtPassword.getText().toString().equals(user.getPasswword())){
                startActivity(new Intent(LoginActivity.this, TrangChuActivity.class));
            }
            else{
                Toast.makeText(this,"Tài khoản hoặc mật khẩu không đúng",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void Login(){
        btnLogin.setOnClickListener(view -> {
            isValid();
        });
    }

}