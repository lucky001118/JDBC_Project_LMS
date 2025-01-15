package model;

import exceptions.UserException;
import query.UserQuery;
import utility.ConnectionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPage {

    private String ResponseEmail;
    private String ResponsePassword;
    private String ResponseName;
    private String ResponseRole;
    private boolean isLogin;

    public String ResponseEmail() {
        return ResponseEmail;
    }

    public LoginPage setResponseEmail(String responseEmail) {
        ResponseEmail = responseEmail;
        return this;
    }

    public String ResponsePassword() {
        return ResponsePassword;
    }

    public LoginPage setResponsePassword(String responsePassword) {
        ResponsePassword = responsePassword;
        return this;
    }

    public String ResponseName() {
        return ResponseName;
    }

    public LoginPage setResponseName(String responseName) {
        ResponseName = responseName;
        return this;
    }

    public String ResponseRole() {
        return ResponseRole;
    }

    public LoginPage setResponseRole(String responseRole) {
        ResponseRole = responseRole;
        return this;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public LoginPage setLogin(boolean login) {
        isLogin = login;
        return this;
    }

    public LoginPage(){

    }

    public LoginPage(String responseEmail, String responsePassword, String responseName, String responseRole, boolean isLogin) {
        ResponseEmail = responseEmail;
        ResponsePassword = responsePassword;
        ResponseName = responseName;
        ResponseRole = responseRole;
        this.isLogin = isLogin;
    }
}
