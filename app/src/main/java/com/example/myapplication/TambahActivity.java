package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class TambahActivity extends AppCompatActivity {

    private EditText etDate, etAmount, etDescription;
    private RadioGroup rgCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etDate = findViewById(R.id.etDate);
        etAmount = findViewById(R.id.etAmount);
        etDescription = findViewById(R.id.etDescription);
        rgCategory = findViewById(R.id.rgCategory);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString();
                int amount = Integer.parseInt(etAmount.getText().toString());
                String description = etDescription.getText().toString();
                boolean isIncome = rgCategory.getCheckedRadioButtonId() == R.id.rbIncome;

                Transaction transaction = new Transaction(date, amount, description, isIncome);

                Intent resultIntent = new Intent();
                resultIntent.putExtra("newTransaction", transaction);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
