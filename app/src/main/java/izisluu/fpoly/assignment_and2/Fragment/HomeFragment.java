package izisluu.fpoly.assignment_and2.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import izisluu.fpoly.assignment_and2.Adapter.SanPhamAdapter;
import izisluu.fpoly.assignment_and2.Model.SanPham;
import izisluu.fpoly.assignment_and2.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<SanPham> productList = new ArrayList<>();
    private SanPhamAdapter adapter;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.RcvSP);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new SanPhamAdapter(productList, new SanPhamAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {
                Edit(position);
            }

            @Override
            public void onDeleteClick(int position) {
                SanPham product = productList.get(position);
                productList.remove(position);
                adapter.notifyItemRemoved(position);
                Toast.makeText(getActivity(), "Đã xóa sản phẩm: " + product.getTenSP(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);

        FloatingActionButton fabAdd = view.findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(v -> addDialog());

        add();
    }

    private void addDialog() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View dialogView = inflater.inflate(R.layout.dialog_add, null);

        EditText edttenSP = dialogView.findViewById(R.id.edtTenSP);
        EditText edtmaSP = dialogView.findViewById(R.id.edtMaSP);
        EditText edtGia = dialogView.findViewById(R.id.edtGia);
        EditText edtSL = dialogView.findViewById(R.id.edtSL);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Thêm sản phẩm mới")
                .setView(dialogView)
                .setPositiveButton("Thêm", (dialog, which) -> {
                    String productName = edttenSP.getText().toString().trim();
                    String productCode = edtmaSP.getText().toString().trim();
                    String productPrice = edtGia.getText().toString().trim();
                    String productQuantity = edtSL.getText().toString().trim();

                    if (productName.isEmpty() || productPrice.isEmpty() || productQuantity.isEmpty() || productCode.isEmpty()) {
                        Toast.makeText(getActivity(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    } else {
                        SanPham newProduct = new SanPham(productName, productCode, productPrice, productQuantity);
                        productList.add(newProduct);
                        adapter.notifyItemInserted(productList.size() - 1);
                        Toast.makeText(getActivity(), "Đã thêm sản phẩm: " + productName, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }

    private void Edit(int position) {
        SanPham product = productList.get(position);

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View dialogView = inflater.inflate(R.layout.dialog_add, null);

        EditText edttenSP = dialogView.findViewById(R.id.edtTenSP);
        EditText edtmaSP = dialogView.findViewById(R.id.edtMaSP);
        EditText edtGia = dialogView.findViewById(R.id.edtGia);
        EditText edtSL = dialogView.findViewById(R.id.edtSL);

        edttenSP.setText(product.getTenSP());
        edtmaSP.setText(product.getMaSP());
        edtGia.setText(product.getGia());
        edtSL.setText(product.getSoLuong());

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chỉnh sửa sản phẩm")
                .setView(dialogView)
                .setPositiveButton("Lưu", (dialog, which) -> {
                    String updatedName = edttenSP.getText().toString().trim();
                    String updatedCode = edtmaSP.getText().toString().trim();
                    String updatedPrice = edtGia.getText().toString().trim();
                    String updatedQuantity = edtSL.getText().toString().trim();

                    if (updatedName.isEmpty() || updatedPrice.isEmpty() || updatedQuantity.isEmpty() || updatedCode.isEmpty()) {
                        Toast.makeText(getActivity(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    } else {
                        product.setTenSP(updatedName);
                        product.setMaSP(updatedCode);
                        product.setGia(updatedPrice);
                        product.setSoLuong(updatedQuantity);
                        adapter.notifyItemChanged(position);
                        Toast.makeText(getActivity(), "Đã cập nhật sản phẩm: " + updatedName, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }

    private void add() {
        SanPham sampleProduct = new SanPham("Sản phẩm mẫu", "P0001", "30.000 VND", "20");
        productList.add(sampleProduct);
        adapter.notifyItemInserted(productList.size() - 1);
    }
}
