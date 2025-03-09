package org.edwinepr.webdemo.model;

import lombok.Data;
import org.edwinepr.webdemo.services.LoggedUserManagementService;
import org.edwinepr.webdemo.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Data
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    public boolean login() {

        loginCountService.incrementCounter();

        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;

        if ("Marianne".equals(username) && "pa55word".equals(password)) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }

        return loginResult;
    }
}
