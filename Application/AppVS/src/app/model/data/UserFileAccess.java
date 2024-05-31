package app.model.data;

import java.util.ArrayList;


import app.model.dao.UserDAO;

public class UserFileAccess {
    public ArrayList<User> Users;

    public UserFileAccess() {
        Users = new ArrayList<User>();
        setList();
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public void addUser(User user) {
        UserDAO u =  new UserDAO();
        this.Users.add(user);
        u.create(user);
    }

    public void deleteUser(User user) {
        UserDAO u =  new UserDAO();
        this.Users.remove(user);
        u.delete(user, user.getLogin());
    }

    public void updateUser(User user, String login, String role) {
        UserDAO u =  new UserDAO();
        u.update(user, login, role);
    }

    public void loadUsers() {
        UserDAO u =  new UserDAO();
        this.Users = u.findAll();
    }

    public User getUser(String login) {
        for (User user : Users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    
    public void setList() {
        UserDAO u =  new UserDAO();
        this.Users = u.findAll();
    }
}
