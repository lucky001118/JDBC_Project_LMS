package serviceImpl;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import exceptions.UserException;
import model.Users;
import service.UserService;

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
        users.setRegistrationDate(new Date());
        users.setMembershipStartDate(new Date());

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        // Add 1 year to the current date
        calendar.add(Calendar.YEAR, 1);
        Date nextYearDate = calendar.getTime();

        users.setMembershipEndDate(nextYearDate);
        return userDao.registerUser(users);
    }

    @Override
    public void deleteUser(Integer userId) throws UserException {
        userDao.deleteUser(userId);
    }

    @Override
    public String updateUser(Users users) throws UserException {
        users.setRegistrationDate(new Date());
        users.setMembershipStartDate(new Date());

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        // Add 1 year to the current date
        calendar.add(Calendar.YEAR, 1);
        Date nextYearDate = calendar.getTime();

        users.setMembershipEndDate(nextYearDate);
        return userDao.updateUser(users);
    }
}
