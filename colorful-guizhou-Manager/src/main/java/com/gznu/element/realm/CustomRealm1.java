package com.gznu.element.realm;



import java.util.Collection;

import com.gznu.element.dao.user.MangerDao;
import com.gznu.element.entity.manger.MangerInfo;
import com.gznu.element.entity.manger.MangerPrincipals;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomRealm1 extends AuthorizingRealm{
    private static final Logger logger = LoggerFactory.getLogger(CustomRealm1.class);
    @Autowired
    MangerDao mangerDao;

    @Override
    public String getName(){
        return "customRealm1";
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
        //从 principals获取主身份信息
        //将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），

				/*MangerPrincipals userPrincipal=(MangerPrincipals) principals.getPrimaryPrincipal();
				String username =  userPrincipal.getUsername();
				//根据身份信息获取权限信息
				//从数据库获取到权限数据
				List<Permission> permissionList = null;
				try {
					permissionList = PD.findPermissionListByUserId(username);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				System.out.println("从数据库获取用户菜单失败");
				}
				//单独定一个集合对象
				List<String> permissions = new ArrayList<String>();
				if(permissionList!=null){
					for(Permission sysPermission:permissionList){
						//将数据库中的权限标签 符放入集合
						permissions.add(sysPermission.getPercode());
					}
				}
				//查到权限数据，返回授权信息(要包括 上边的permissions)
				SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
				//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
				simpleAuthorizationInfo.addStringPermissions(permissions);

				return simpleAuthorizationInfo;*/

    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从token中 获取用户身份信息
        String username = (String) token.getPrincipal();
        MangerPrincipals userPrincipal = new MangerPrincipals();
        int length = username.length();
        try {
            String LoginMode = username.substring(length - 3, length);
            username = username.substring(0, length - 3);
            userPrincipal.setLoginMode(LoginMode);
        } catch (IndexOutOfBoundsException e) {
            logger.error("解析用户名错误，e={}", e);
            // new RuntimeException(e);
            e.printStackTrace();
        }
        //拿username从数据库中查询
		/*DefaultWebSecurityManager securityManager =  (DefaultWebSecurityManager) ((DefaultSessionManager) ((DefaultWebSecurityManager) SecurityUtils.getSecurityManager()).getSessionManager()).getSessionDAO()
		.getActiveSessions();
			        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
				        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
				        Subject subject = SecurityUtils.getSubject();
				        Session session1 = subject.getSession();
				        String sessionId=(String) session1.getId();

				        for(Session session:sessions){
				            //清除该用户以前登录时保存的sessio
				        	System.out.println(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
				        	if(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)!=null)
				        		if(session.getId().equals(sessionId)){
				        			sessionManager.getSessionDAO().delete(session);
					                break;
				        	}
				        	MangerPrincipals userPrincipals=(MangerPrincipals) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
				        	if(userPrincipals!=null)
				            if(username.equals(userPrincipals.getUsername())&&!session.getId().equals(sessionId)&&userPrincipals.getLoginMode().equals(userPrincipal.getLoginMode())) {
			                sessionManager.getSessionDAO().delete(session);
				                break;
				            }
			        }*/
        Collection<Session> list = ((DefaultSessionManager) ((DefaultSecurityManager) SecurityUtils
                .getSecurityManager()).getSessionManager()).getSessionDAO().getActiveSessions();
        Subject subject = SecurityUtils.getSubject();
        Session session1 = subject.getSession();
        String sessionId = (String) session1.getId();
        for (Session session : list) {
            Subject s = new Subject.Builder().session(session).buildSubject();

            if (s.isAuthenticated()) {
                MangerPrincipals mangerPrincipals = (MangerPrincipals) s.getPrincipal();
                if (username.equals(mangerPrincipals.getManagerName()) && !session.getId().equals(sessionId)
                        && mangerPrincipals.getLoginMode().equals(userPrincipal.getLoginMode())) {
                    session.stop();
                    break;
                }
            }
        }
        MangerInfo mangerInfo = null;
        try {
            mangerInfo = mangerDao.selectMangerPrincipalById(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mangerInfo == null) {
            return null;
        }
        // 获取从数据库查询出来的用户密码
        String password = mangerInfo.getManagerPassword();

        userPrincipal.setManagerName(mangerInfo.getManagerName());
        // 返回认证信息由父类AuthenticatingRealm进行认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userPrincipal, password,
                getName());
        return simpleAuthenticationInfo;
    }
}
