# Form Validator 

This library allows you to validate huge forms containing various fields in android just by writing a single line, It saves you from the hassle of checking individual edit text boxes one by one then setting the error which puts a lot of bioler plate code.

## Setup Project

Add this to your project build.gradle

Project-level build.gradle (<project>/build.gradle):

``` gradle 
allprojects {
    repositories {
        google()
        jcenter() 
        maven { url 'https://jitpack.io' } 
    }
}
```

Add this to your project build.gradle

Module-level build.gradle (<module>/build.gradle): 

#### [![](https://jitpack.io/v/appsfeature/YTPlayer.svg)](https://jitpack.io/#appsfeature/YTPlayer)
```gradle  

dependencies {
    implementation 'com.github.appsfeature:form-validator:x.y'
} 
```

In your activity class:
#### Usage method
```java 
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
                                
```

#### Useful Links:
1. https://github.com/appsfeature/form-validator
