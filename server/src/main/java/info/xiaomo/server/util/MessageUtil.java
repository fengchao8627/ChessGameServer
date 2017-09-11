package info.xiaomo.server.util;


import com.google.protobuf.AbstractMessage;
import info.xiaomo.server.server.UserSession;
import info.xiaomo.server.server.SessionManager;

import java.util.Collection;

public class MessageUtil {

    public static void sendMsg(AbstractMessage msg, long id) {
        UserSession userSession = SessionManager.getInstance().getSession(id);
        if (userSession == null) {
            return;
        }
        userSession.sendMessage(msg);
    }

    public static void sendMsg(UserSession userSession, AbstractMessage msg) {
        userSession.sendMessage(msg);
    }

    public static void sendMsgToRids(AbstractMessage msg, long... rids) {
        for (long rid : rids) {
            sendMsg(msg, rid);
        }
    }

    public static void sendMsgToRids(AbstractMessage msg, Collection<Long> rids) {
        for (Long rid : rids) {
            if (rid != null) {
                sendMsg(msg, rid);
            }
        }
    }

    public static void sendMsgToRids(AbstractMessage msg, Collection<Long> rids, Long exceptRoleId) {
        for (Long rid : rids) {
            if (rid != null && (!rid.equals(exceptRoleId))) {
                sendMsg(msg, rid);
            }
        }
    }


}
