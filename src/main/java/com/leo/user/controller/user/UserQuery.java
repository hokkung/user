package com.leo.user.controller.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserQuery {
    @Getter
    @Setter
    private String firstName;

    public UserFilter createFilter() {
        UserFilter filter = new UserFilter();
        filter.setFirstName(this.firstName);

        return filter;
    }
}
