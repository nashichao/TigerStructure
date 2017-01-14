package com.practice.tiger.tigerstructure.acitivity;


import com.practice.tiger.tigerstructure.R;
import com.practice.tiger.tigerstructure.base.BaseActivity;
import com.practice.tiger.tigerstructure.db.BaseDaoFactory;
import com.practice.tiger.tigerstructure.db.IBaseDao;
import com.practice.tiger.tigerstructure.db.UserDao;
import com.practice.tiger.tigerstructure.model.User;

public class DataBaseActivity extends BaseActivity {

    IBaseDao<User> baseDao;

    @Override
    protected void setRootContentView() {
        setContentView(R.layout.activity_data_base);
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void initViewsData() {
        baseDao = BaseDaoFactory.getInstance().getDataHelper(UserDao.class, User.class);
    }
}
