package chat.mapper;

import chat.model.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface FriendMapper {

//    int addFriend(String fromCode,String toCode);
    /**
     * 获取当前用户所有好友
     * @param fromCode
     * @return
     */
    @Select({"select * from friend_relation WHERE fromCode = #{fromCode}"})
    Set<Friend> getAllFriend(String fromCode);
}
