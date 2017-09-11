package info.xiaomo.server.command;

import info.xiaomo.gameCore.base.common.AttributeUtil;
import info.xiaomo.gameCore.base.concurrent.command.AbstractCommand;
import info.xiaomo.gameCore.network.SessionKey;
import info.xiaomo.server.server.UserSession;
import info.xiaomo.server.system.user.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogoutCommand extends AbstractCommand {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogoutCommand.class);
	
	private UserSession userSession;
	
	
	public LogoutCommand(UserSession userSession) {
		this.userSession = userSession;
	}


	@Override
	public void doAction() {
		
		Boolean logoutHandled =  AttributeUtil.get(userSession.getChannel(), SessionKey.LOGOUT_HANDLED);
		if(Boolean.TRUE.equals(logoutHandled)) {
			LOGGER.error("网络连接断开的时候玩家已经处理过下线事件[顶号]->{}", userSession.getUser().toString());
			return;
		}
		AttributeUtil.set(userSession.getChannel(), SessionKey.LOGOUT_HANDLED, true);
		//登出
		UserManager.getInstance().logout(userSession);
		LOGGER.error("网络连接断开，处理玩家下线逻辑->{}", userSession.getUser().toString());
	}

	
}
