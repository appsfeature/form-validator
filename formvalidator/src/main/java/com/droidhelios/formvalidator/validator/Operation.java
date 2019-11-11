package com.droidhelios.formvalidator.validator;

import android.text.TextUtils;

import com.droidhelios.formvalidator.messages.Message;
import com.droidhelios.formvalidator.regx.RegEx;
import com.droidhelios.formvalidator.type.FieldType;

public class Operation {

    static String getRegExCode(FieldType fieldType, String regExCode) {
        if (!TextUtils.isEmpty(regExCode)) {
            return regExCode;
        }
        switch (fieldType) {
            case NAME:
                return RegEx.NAME_REGEX;
            case AGE:
                return RegEx.AGE_REGEX;
            case EMAIL:
                return RegEx.EMAIL_REGEX;
            case PHONE:
                return RegEx.PHONE_REGEX;
            case MOBILE:
                return RegEx.MOBILE_REGEX;
            case GST:
                return RegEx.GST_REGEX;
            case PIN_CODE:
                return RegEx.PIN_CODE_REGEX;
            case IFSC_CODE:
                return RegEx.IFSC_CODE_REGEX;
            case ALPHA_NUM:
                return RegEx.ALPHA_NUM_REGEX;
            case DATE:
                return RegEx.DATE_REGEX;
            default:
                return RegEx.DEFAULT_REGEX;
        }
    }

    static String getErrorMessage(FieldType fieldType, String errorMessage) {
        if (!TextUtils.isEmpty(errorMessage)) {
            return errorMessage;
        }
        switch (fieldType) {
            case NAME:
                return Message.NAME_MSG;
            case AGE:
                return Message.AGE_MSG;
            case EMAIL:
                return Message.EMAIL_MSG;
            case PHONE:
                return Message.PHONE_MSG;
            case MOBILE:
                return Message.MOBILE_MSG;
            case GST:
                return Message.GST_MSG;
            case PIN_CODE:
                return Message.PIN_CODE_MSG;
            case IFSC_CODE:
                return Message.IFSC_CODE_MSG;
            case ALPHA_NUM:
                return Message.ALPHA_NUM_MSG;
            case DATE:
                return Message.DATE_MSG;
            default:
                return Message.EMPTY;
        }
    }
}
