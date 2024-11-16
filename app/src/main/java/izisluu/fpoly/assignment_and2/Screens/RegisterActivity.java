package izisluu.fpoly.assignment_and2.Screens;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import izisluu.fpoly.assignment_and2.R;
import izisluu.fpoly.assignment_and2.Model.User;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtUsername,edtPassword,edtRePassword,edtName;
    private Button btnRegister;
    private ArrayList<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        edtRePassword = findViewById(R.id.edtRePassword);
        btnRegister = findViewById(R.id.btnRegister);
        edtName = findViewById(R.id.edtName);
        users = new ArrayList<>();
        click();

    }
    public Boolean isValid() {
        if (edtUsername.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()
        || edtRePassword.getText().toString().isEmpty() || edtName.getText().toString().isEmpty()) {
            return false;
        }
        return true;

    }
    public void click(){
        btnRegister.setOnClickListener(v -> {
            if (isValid()){
                users.add(new User(edtUsername.getText().toString(),edtPassword.getText().toString(),edtName.getText().toString()));
                finish();
            }else {
                Toast.makeText(this,"Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            }
        });
    }
}