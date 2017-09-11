package info.xiaomo.server.db.mapper;

import info.xiaomo.gameCore.persist.jdbc.RowMapper;
import info.xiaomo.server.entify.User;
import info.xiaomo.server.system.user.constant.UserConst;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 玩家数据的 映射器
 *
 * @author 小莫
 *         2017年6月6日 下午9:30:20
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapping(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong(UserConst.ID));
        user.setLoginName(rs.getString(UserConst.LOGIN_NAME));
        user.setServerId(rs.getInt(UserConst.SERVER_ID));
        user.setPlatformId(rs.getInt(UserConst.PLATFORM_ID));
        user.setGmLevel(rs.getInt(UserConst.GM_LEVEL));
        user.setIdNumber(rs.getString(UserConst.ID_NUMBER));
        user.setRegisterTime(rs.getInt(UserConst.REGISTER_TIME));
        return user;
    }

    @Override
    public void release() {

    }

}
