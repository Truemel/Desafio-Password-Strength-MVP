package com.example.desafio_password_strength_mvp.presenter.interfaces;

public interface IPresenterView {
    public void weak(int color);
    public void medium(int color);
    public void strong(int color);
    public void veryStrong(int color);
}
