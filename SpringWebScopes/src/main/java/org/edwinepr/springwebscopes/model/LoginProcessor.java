package org.edwinepr.springwebscopes.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Data
public class LoginProcessor {
    private String username;
    private String password;

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();

        return "Marianne".equals(username) && "password".equals(password);
    }
}
