package serviceImpl;

import dao.AllInfoDao;
import daoImpl.AllInfoDaoImpl;
import service.AllInfoService;

public class AllInfoServiceImpl implements AllInfoService {
    private AllInfoDao allInfoDao = new AllInfoDaoImpl();
    @Override
    public String AllInfoUsingUserName(String userName) {
        return allInfoDao.AllInfoUsingUserName(userName);
    }

    @Override
    public String AllInfoUsingBookName(String bookName) {
        return allInfoDao.AllInfoUsingBookName(bookName);
    }
}
