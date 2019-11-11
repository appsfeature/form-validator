package com.droidhelios.formvalidator.model;

import android.widget.EditText;

import com.droidhelios.formvalidator.type.FieldType;

public class FormField {

    private EditText editText;
    private FieldType fieldType;
    private String errorMessage;
    private boolean active = true;
    private String regExCode;

    public FormField(EditText editText, FieldType fieldType) {
        this.editText = editText;
        this.fieldType = fieldType;
    }

    public FormField(EditText editText, FieldType fieldType, boolean active) {
        this.editText = editText;
        this.fieldType = fieldType;
        this.active = active;
    }

    public FormField(EditText editText, FieldType fieldType, String errorMessage) {
        this.editText = editText;
        this.fieldType = fieldType;
        this.errorMessage = errorMessage;
    }

    public FormField(EditText editText, FieldType fieldType, String errorMessage, boolean active) {
        this.editText = editText;
        this.fieldType = fieldType;
        this.errorMessage = errorMessage;
        this.active = active;
    }

    public FormField(EditText editText, FieldType fieldType, String errorMessage, String regExCode) {
        this.editText = editText;
        this.fieldType = fieldType;
        this.errorMessage = errorMessage;
        this.regExCode = regExCode;
    }

    public FormField(EditText editText, FieldType fieldType, String errorMessage, boolean active, String regExCode) {
        this.editText = editText;
        this.fieldType = fieldType;
        this.errorMessage = errorMessage;
        this.active = active;
        this.regExCode = regExCode;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRegExCode() {
        return regExCode;
    }

    public void setRegExCode(String regExCode) {
        this.regExCode = regExCode;
    }
}
