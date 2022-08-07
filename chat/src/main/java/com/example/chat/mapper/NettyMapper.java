package com.example.chat.mapper;//package com.example.chat.mapper;
//
//import com.example.chat.common.Friend;
//import com.example.chat.common.Message;
//import com.example.chat.common.User;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Mapper
//public interface NettyMapper {
//
//
//    int addFriend(String fromCode,String toCode);
//
//    /**
//     获取所有好友
//     */
//    @Select("select toCode from friend_relation where fromCode = #{fromCode}")
//    List<Friend> getAllFriend(String fromCode);
//
//    /**
//     获取所有聊天信息
//     */
//    List<Message> getAllMessage(String fromCode,String toCode);
//
//    /**
//     插入聊天信息
//     */
//    boolean AddMessage(Message message);
//
//    /**
//     获取登录信息
//     */
//    User findPassword(User user);
//}
