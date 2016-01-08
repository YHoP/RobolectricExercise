package com.ypeng.robolectricexercise.login;

import com.ypeng.robolectricexercise.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginView view;
    @Mock
    private LoginService service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void showErrorMessage_UsernameIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showUsernameError(R.string.username_error);
    }

    @Test
    public void showErrorMessage_PasswordIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("test");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showPasswordError(R.string.password_error);
    }

    @Test
    public void startMainActivity_UsernameAndPasswordAreCorrect() throws Exception {
        when(view.getUsername()).thenReturn("test");
        when(view.getPassword()).thenReturn("123");
        when(service.login("test", "123")).thenReturn(true);
        presenter.onLoginClicked();

        verify(view).startMainActivity();
    }

    @Test
    public void showLoginError_UsernameAndPasswordAreInvalid() throws Exception {
        when(view.getUsername()).thenReturn("test");
        when(view.getPassword()).thenReturn("123");
        when(service.login("test", "123")).thenReturn(false);
        presenter.onLoginClicked();

        verify(view).showLoginError(R.string.login_failed);
    }
}