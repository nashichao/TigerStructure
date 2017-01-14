package com.practice.tiger.tigerstructure.model;


import com.practice.tiger.tigerstructure.db.annotion.DbFiled;
import com.practice.tiger.tigerstructure.db.annotion.DbTable;

/**
 * Author：NaShichao
 * Time：2017/1/10  上午11:50
 * Email：na.shichao@163.com
 * Description：
 */
@DbTable("tb_common_user")
public class User {
    @DbFiled("tb_name")
    public String name;

    @DbFiled("tb_password")
    public String password;
}
