package app.model.data;

import java.util.ArrayList;
import java.util.List;

public class UserFileAccess {
    public List<User> Users;

    public UserFileAccess() {
        Users = new ArrayList<User>();
    }

    public List<User> getUsers() {
        return Users;
    }
}
