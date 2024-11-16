package izisluu.fpoly.assignment_and2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import izisluu.fpoly.assignment_and2.R;

public class AccountFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        Button editPasswordButton = view.findViewById(R.id.edit_password_button);

        editPasswordButton.setOnClickListener(v -> {
            LayoutInflater dialogInflater = LayoutInflater.from(getContext());
            View dialogView = dialogInflater.inflate(R.layout.dialog_edit_account, null);

            EditText editName = dialogView.findViewById(R.id.editName);
            EditText editPass = dialogView.findViewById(R.id.editPass);
            EditText editRePass = dialogView.findViewById(R.id.editRePass);

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Cập nhật thông tin")
                    .setView(dialogView)
                    .setPositiveButton("Lưu", (dialog, which) -> {
                        String name = editName.getText().toString().trim();
                        String password = editPass.getText().toString().trim();
                        String rePassword = editRePass.getText().toString().trim();

                        if (name.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                            Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        } else if (!password.equals(rePassword)) {
                            Toast.makeText(getContext(), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                        } else {
                            updateAccountInfo(name, password);
                        }
                    })
                    .setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());

            builder.create().show();
        });

        return view;
    }

    private void updateAccountInfo(String name, String password) {
        Toast.makeText(getContext(), "Cập nhật thành công: " + name, Toast.LENGTH_SHORT).show();
    }
}
