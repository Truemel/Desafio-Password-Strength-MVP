package com.example.desafio_password_strength_mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.desafio_password_strength_mvp.presenter.Presenter;
import com.example.desafio_password_strength_mvp.R;
import com.example.desafio_password_strength_mvp.presenter.interfaces.IPresenterView;

public class MainActivity extends AppCompatActivity implements IPresenterView {

    private EditText pass;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass = findViewById(R.id.pass);
        pass.addTextChangedListener(new Presenter(this));
        message = findViewById(R.id.message);
    }

    @Override
    public void weak(int color) {
        message.setText(R.string.weak);
        message.setBackgroundColor(color);
    }

    @Override
    public void medium(int color) {
        message.setText(R.string.medium);
        message.setBackgroundColor(color);
    }

    @Override
    public void strong(int color) {
        message.setText(R.string.strong);
        message.setBackgroundColor(color);
    }

    @Override
    public void veryStrong(int color) {
        message.setText(R.string.veryStrong);
        message.setBackgroundColor(color);
    }
}
