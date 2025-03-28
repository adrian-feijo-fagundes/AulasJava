package org.example.view;

import org.example.model.UserModel;

public class UserView {
    public String render(UserModel user) {
        return String.format(
                "{ \"name\": \"%s\", \"email\": \"%s\" }",
                user.getName(),
                user.getEmail()
        );
    }
}
