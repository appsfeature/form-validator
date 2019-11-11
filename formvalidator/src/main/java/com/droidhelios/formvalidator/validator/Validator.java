package com.droidhelios.formvalidator.validator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.content.ContextCompat;

import com.droidhelios.formvalidator.R;
import com.droidhelios.formvalidator.messages.Message;
import com.droidhelios.formvalidator.model.FormField;

import java.util.regex.Pattern;

public class Validator {

    private final Context context;

    public Validator(Context context) {
        this.context = context;
    }

    public boolean validate(FormField formField) {
        return isValid(context, formField.getEditText()
                , Operation.getRegExCode(formField.getFieldType(), formField.getRegExCode())
                , Operation.getErrorMessage(formField.getFieldType(),formField.getErrorMessage())
                , formField.isActive());
    }

    public static boolean validate(Context context, FormField formField) {
        return isValid(context, formField.getEditText()
                , Operation.getRegExCode(formField.getFieldType(), formField.getRegExCode())
                , Operation.getErrorMessage(formField.getFieldType(),formField.getErrorMessage())
                , formField.isActive());
    }

    public static boolean isPassword(Context context, EditText editText, EditText editText2) {
        return hasTextMatched(context, editText, editText2);
    }

    public static boolean isEmpty(Context context, EditText editText) {
        return hasText(context, editText);
    }

//    public static boolean isEmpty(Context context, String editText) {
//        return isEmpty(context, editText, Message.EMPTY);
//    }
//
//    public static boolean isEmpty(Context context, String string, String errorMsg) {
//        if (TextUtils.isEmpty(string)) {
//            Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show();
//            return false;
//        } else {
//            return true;
//        }
//    }


    public static boolean isEmpty(Context context, EditText editText, String errorMsg) {
        return hasText(context, editText, errorMsg);
    }


    private static boolean isButton(Context context, Button button, String defaultValue) {
        String validText = button.getText().toString();
        if (TextUtils.isEmpty(validText) && validText.equals(defaultValue)) {
            return true;
        }
        return false;
    }


    // return true if the input field is valid, based on the parameter passed
    private static boolean isValid(Context context, EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if (required && !hasText(context, editText)) return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_fail);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                editText.setError(errMsg, drawable);
            }
            return false;
        }

        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    private static boolean hasText(Context context, EditText editText) {
        return hasText(context, editText, Message.EMPTY);
    }

    private static boolean hasText(Context context, EditText editText, String errorMessage) {

        String text = editText.getText().toString().trim();
        editText.setError(null);
        // length 0 means there is no text
        if (text.length() == 0) {

            SpannableString s = new SpannableString(errorMessage);
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            s.setSpan(new StyleSpan(Typeface.NORMAL), 0, s.length(), 0);
            s.setSpan(new RelativeSizeSpan(1.1f), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

//            editText.requestFocus();
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_fail);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                editText.setError(s, drawable);
            }
            return false;
        }
//        Drawable drawable=ContextCompat.getDrawable(context,R.drawable.ic_success);
//        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//        editText.setError("done",drawable);
        return true;
    }


    private static boolean hasTextMatched(Context context, EditText editText, EditText editText2) {

        String text = editText.getText().toString().trim();
        String text2 = editText2.getText().toString().trim();
        editText.setError(null);
        if (text.length() != 0 && text2.length() != 0 && text.equalsIgnoreCase(text2)) {
            return true;
        } else {
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_fail);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                // length 0 means there is no text
                if (text.length() == 0) {
                    editText.setError(getMessage("Invalid Password"), drawable);
                    return false;
                } else if (text2.length() == 0) {
                    editText2.setError(getMessage("Invalid Confirm Password"), drawable);
                    return false;
                } else {
                    editText2.setError(getMessage("Password doesn't match"), drawable);
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    private static SpannableString getMessage(String message) {
        SpannableString s = new SpannableString(message);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 0, s.length(), 0);
        s.setSpan(new RelativeSizeSpan(1.1f), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return s;
    }

    public static boolean isVariable(Context context, String mCustomerId) {
        if (!TextUtils.isEmpty(mCustomerId)) {
            return true;
        } else {
            return false;
        }
    }

}
