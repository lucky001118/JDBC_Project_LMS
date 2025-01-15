package dao;

import exceptions.UserException;
import model.Users;

import java.util.List;

public interface UserDao {
    //get all the users from the db
    public List<Users> getAllUsers() throws UserException;
    //get user using the user id
    public Users getUserByUserID(Integer userID) throws UserException;
    //register the user
    public String registerUser(Users users) throws UserException;
    //delete the existing user
    public void deleteUser(Integer userId) throws UserException;
    //update user's informations
    public String updateUser(Users users) throws UserException;
}
