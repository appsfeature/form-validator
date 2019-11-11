package com.sample.formvalidator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.droidhelios.formvalidator.FormValidator;
import com.droidhelios.formvalidator.model.FormField;
import com.droidhelios.formvalidator.type.FieldType;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge, etEmail;
    private FormValidator formValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etEmail = findViewById(R.id.et_email);

        formValidator = FormValidator.Builder(this)
                .setEditTextFormFields(new FormField(etName, FieldType.NAME)
                        , new FormField(etAge, FieldType.AGE), new FormField(etEmail, FieldType.EMAIL))
                .enableTextChangeDetection(true)
                .initialize();

    }

    public void onSubmitClicked(View view) {
        if (formValidator.isValid()) {
            Toast.makeText(this, "Successfully verified all fields.", Toast.LENGTH_SHORT).show();
        }
    }
}
