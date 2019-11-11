package com.droidhelios.formvalidator;

import android.content.Context;

import com.droidhelios.formvalidator.model.FormField;
import com.droidhelios.formvalidator.validator.FieldValidator;
import com.droidhelios.formvalidator.validator.Validator;

public class FormValidator {


    private final Validator validator;
    private final Context context;
    private FormField[] formFields;
    private boolean enableTextChangeDetection = false;

    private FormValidator(Context context) {
        this.context = context;
        validator = new Validator(context);
    }

    public static FormValidator Builder(Context context) {
        return new FormValidator(context);
    }

    public FormValidator enableTextChangeDetection(boolean enableTextChangeDetection) {
        this.enableTextChangeDetection = enableTextChangeDetection;
        return this;
    }

    public FormValidator setEditTextFormFields(FormField... formFields) {
        this.formFields = formFields;
        return this;
    }

    public FormValidator initialize() {
        for (FormField formField : formFields) {
            if(enableTextChangeDetection){
                new FieldValidator(context, formField);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean allValid = true;
        for (FormField formField : formFields) {
            allValid = validator.validate(formField);
            if (!allValid) break;
        }
        return allValid;
    }
}