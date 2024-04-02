package org.example.chattest.chatRoomUser;


public class ChatRoomUserDTO {
    public ChatRoomUserDTO(String id, String roomId, String userId) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
    }

    public String id;
    public String roomId;
    public String userId;
}
