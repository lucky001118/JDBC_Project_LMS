package serviceImpl;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import exceptions.UserException;
import model.Users;
import service.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// all the user's related bussines information writes here
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<Users> getAllUsers() throws UserException {
        return userDao.getAllUsers();
    }

    @Override
    public Users getUserByUserID(Integer userID) throws UserException {
        return userDao.getUserByUserID(userID);
    }

    @Override
    public String registerUser(Users users) throws UserException {
        // Get the current date
        LocalDate date = LocalDate.now();

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the date to string
        String currentDate = date.format(formatter);

        users.setRegistrationDate(currentDate);
        users.setMembershipStartDate(currentDate);
        users.setMembershipEndDate(currentDate);
        return userDao.registerUser(users);
    }

    @Override
    public void deleteUser(Integer userId) throws UserException {
        userDao.deleteUser(userId);
    }

    @Override
    public String updateUser(Users users) throws UserException {
        return userDao.updateUser(users);
    }
}
