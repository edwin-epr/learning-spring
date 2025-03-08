package org.edwinepr.springwebscopes.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
@Data
public class LoginCountService {

    private int counter;

    public void incrementCounter() {
        counter++;
    }
}
