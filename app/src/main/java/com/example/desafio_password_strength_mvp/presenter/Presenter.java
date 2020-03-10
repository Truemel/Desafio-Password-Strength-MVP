package com.example.desafio_password_strength_mvp.presenter;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.example.desafio_password_strength_mvp.presenter.interfaces.IPresenterView;
import com.example.desafio_password_strength_mvp.model.Verifier;

public class Presenter implements TextWatcher {

    private IPresenterView view;

    private final int WEAK_COLOR = 0xFFFF0000;
    private final int MEDIUM_COLOR = 0xFF00FFFF;
    private final int STRONG_COLOR = 0xFF00FF00;
    private final int VERY_STRONG_COLOR = 0xFFFF1155;
    /*
    private final String WEAK_MESSAGE = "WEAK";
    private final String MEDIUM_MESSAGE = "MEDIUM";
    private final String STRONG_MESSAGE = "STRONG";
    private final String VERY_STRONG_MESSAGE = "VERY STRONG";
    */

    public Presenter(IPresenterView view){
        this.view = view;
    }

    private void securityLevelResultEvaluation(String text){
        int securityLevel = Verifier.howSecurePassword(text.toString());
        switch (securityLevel) {
            case Verifier.WEAK: {
                view.weak(WEAK_COLOR);
                break;
            }
            case Verifier.MEDIUM: {
                view.medium(MEDIUM_COLOR);
                break;
            }
            case Verifier.STRONG: {
                view.strong(STRONG_COLOR);
                break;
            }
            case Verifier.VERY_STRONG: {
                view.veryStrong(VERY_STRONG_COLOR);
                break;
            } default:
                Log.d("WHAT", "How did this happen?!");
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        securityLevelResultEvaluation(s.toString());
    }
}
