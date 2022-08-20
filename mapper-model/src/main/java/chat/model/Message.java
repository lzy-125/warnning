package chat.model;
import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Message {

    @Expose
    private String content;     //发送的消息

    @Expose
    private String sendTime;    //消息时间

    @Expose
    private String fromCode;    //消息发送方

    @Expose
    private String toCode;       //消息接收方

    @Expose
    private String type;         //消息类型 在线或离线

//    @Expose
//    private Boolean state;      // 消息状态 在线或离线 1为私聊 0为群聊
}
