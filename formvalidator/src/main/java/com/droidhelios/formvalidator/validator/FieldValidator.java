package com.droidhelios.formvalidator.validator;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

import com.droidhelios.formvalidator.model.FormField;

public class FieldValidator {

    public FieldValidator(final Context context, final FormField formField) {
        formField.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Validator.validate(context, formField);
            }
        });
    }
}
