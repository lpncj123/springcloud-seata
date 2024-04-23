package cn.lp.springdubboorder.mapper;


import cn.lp.springdubboorder.modal.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


public interface UserMapper extends Mapper<User>, MySqlMapper<User> {

}
