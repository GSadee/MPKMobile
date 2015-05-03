package com.pz.mpkmobile.validator;


import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.pz.mpkmobile.R;

public class EditTextValidator implements TextWatcher {

    private Context mContext;
    private EditText mEditText;

    public EditTextValidator(EditText editText, Context context) {
        mEditText = editText;
        mContext = context;
    }

    public void validate(EditText editText, String text) {
        if (text.length() < 1) {
            editText.setError(mContext.getString(R.string.field_required));
        }
    }

    @Override
    final public void afterTextChanged(Editable s) {
        String text = mEditText.getText().toString();
        validate(mEditText, text);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) { }
}