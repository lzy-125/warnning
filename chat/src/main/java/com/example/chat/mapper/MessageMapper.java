package com.example.chat.mapper;

import com.example.chat.common.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    /**
     * 获取本人和当前好友的所有聊天信息
     * @param fromCode
     * @param toCode
     * @return
     */
    @Select({"select * from message WHERE fromCode = #{fromCode} AND toCode = #{toCode}"})
    List<Message> getAllMessage(String fromCode, String toCode);

    /**
     * 插入单条聊天信息
     * @param message
     */
    @Insert("insert into message (fromCode,toCode,content,sendTime,online) values (#{fromCode},#{toCode},#{content},#{sendTime},#{online}")
    void insertMessage(Message message);
}
