package org.edwinepr.webdemo.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.boot.web.reactive.function.client.WebClient;

@Route
public class LoginView extends FormLayout {

    private TextField username = new TextField("Username");
    private PasswordField password = new PasswordField("Password");
    private Button loginButton = new Button("Login");
    private Paragraph message = new Paragraph();

    public LoginView() {
        add(username, password, loginButton, message);

        loginButton.addClickListener(e -> {
            WebClient
        })
    }
}
