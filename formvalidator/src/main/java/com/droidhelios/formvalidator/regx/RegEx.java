package com.droidhelios.formvalidator.regx;

public interface RegEx {

    String DEFAULT_REGEX = "";
    String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String PHONE_REGEX = "^[4-9][0-9]{9}$";
    String MOBILE_REGEX = "^[4-9][0-9]{9}$";
    //    String GST_REGEX = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$";
    String GST_REGEX = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[0-9A-Z]{1}[0-9A-Z]{1}[0-9A-Z]{1}$";

    String PIN_CODE_REGEX = "^[0-9]{6}$";
    String IFSC_CODE_REGEX = "^[A-Za-z]{4}[0-9]{7}$";

    String PHONE_REGEX_2 = "^[0-9][0-9]{6,10}$";

//    String AGE_REGEX = "^[7-9][0-9]{9}$";
    String AGE_REGEX = "^[0-9]{2,3}$";
    String NAME_REGEX = "[a-zA-Z ]{1,100}";
    String PRODUCT_REGEX = "^[a-zA-Z0-9 ]+$";
    String ALPHA_NUM_REGEX = "^[a-zA-Z0-9 ]+$";
    //dd-MM-yyyy,dd/MM/yyyy
    String DATE_REGEX = "^(((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))[-/]?[0-9]{4}|02[-/]?29[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$";
    //MM-dd-yyyy,MM/dd/yyyy
    String DATE1_REGEX = "^(((0[1-9]|[12][0-9]|30)[-/]?(0[13-9]|1[012])|31[-/]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]?02)[-/]?[0-9]{4}|29[-/]?02[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$";

    //Support exp 2300,23:00,4 am ,4am ,4pm ,4 pm,04:30pm ,04:30 pm ,4:30pm ,4:30 pm,04.30pm,04.30 pm,4.30pm,4.30 pm ,23:59 ,0000 ,00:00
    String TIME_REGEX = "";

}
