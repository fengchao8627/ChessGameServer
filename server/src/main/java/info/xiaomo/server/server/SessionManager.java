package info.xiaomo.server.server;

import info.xiaomo.server.entify.Role;
import info.xiaomo.server.entify.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class SessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    public static SessionManager getInstance() {
        return INSTANCE;
    }

    private SessionManager() {

    }

    private final ConcurrentMap<Long, UserSession> uidSessionMap = new ConcurrentHashMap<>();
    private final ConcurrentMap<Long, UserSession> ridSessionMap = new ConcurrentHashMap<>();

    public UserSession getSession(long uid) {
        return uidSessionMap.get(uid);
    }

    public UserSession getSessionByRoleId(long rid) {
        return ridSessionMap.get(rid);
    }

    public void register(UserSession userSession) {
        uidSessionMap.put(userSession.getUser().getId(), userSession);
    }

    public void unregister(UserSession userSession) {
        if (userSession != null) {
            User user = userSession.getUser();
            boolean remove = uidSessionMap.remove(user.getId(), userSession);
            unregisterPlayer(userSession, true);
            log.info("UserSession unregister, userId={}, remove={}", user.getId(), remove);
        }
    }

    public UserSession[] getSessionArray() {
        Collection<UserSession> values = uidSessionMap.values();
        return values.toArray(new UserSession[values.size()]);
    }

    public void registerPlayer(UserSession userSession) {
        Role role = userSession.getRole();
        if (role != null) {
            ridSessionMap.put(role.getId(), userSession);
        }
    }

    public void unregisterPlayer(UserSession userSession, boolean clearUid) {
        Role role = userSession.getRole();
        if (role != null) {
            ridSessionMap.remove(role.getId(), userSession);
        }
        if (clearUid) {
            userSession.clearAttribute();
        }
    }

    public boolean isOnline(long roleId) {
        return ridSessionMap.containsKey(roleId);
    }

    public UserSession[] sessionArray() {
        return ridSessionMap.values().toArray(new UserSession[0]);
    }
}
