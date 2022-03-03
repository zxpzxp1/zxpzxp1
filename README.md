1.执行db目录下的建表脚本，创建Mysqld的数据库bbs,建议使用Mysql版本5.7以上
否则error attempting to get column 'update_time' 会出现0000-00-00 00:00:00错误
nested exception is java.sql.SQLException: Zero date value prohibited
2.测试为了方便去掉了用户名和密码验证
3.启动http://127.0.0.1:1000/doc.html接口测试工具
4.用户信息菜单->会员注册接口：Post  点击调试菜单  /api/user/register 
输入参数
{
	"email": "1@1.com",
	"password": "1",
	"username": "1"
}
5.用户信息菜单->登录接口：Post  点击调试菜单 /api/user/login
{
   "username":"1",
   "password":"1"
} 得到返回token "eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSCijKz0pNLtENDXYNUtJRSq0oULIyNDMxMzY1NzK30FEqLU4t8kxRsjKCMP0Sc1OBugyVagFObRgeQQAAAA.W-6UvrqQoEB0mmX5qklmLgzHwAENm1XS_GcJnyZSRgbodDUQ-76xgc9NeIAZHvIeav57mCCe94DqCjrQT1cPSQ"
6.获取用户信息 点击调试菜单 /api/user/auth/getUserInfo 
token=eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSCijKz0pNLtENDXYNUtJRSq0oULIyNDMxMzY1NzK30FEqLU4t8kxRsjKCMP0Sc1OBugyVagFObRgeQQAAAA.W-6UvrqQoEB0mmX5qklmLgzHwAENm1XS_GcJnyZSRgbodDUQ-76xgc9NeIAZHvIeav57mCCe94DqCjrQT1cPSQ
7.添加留言信息 点击调试菜单 /api/message/add 
{
	"childMsg": "",
	"msg": "111111111111",
	"userId": "1"
}
7.添加子留言信息 点击调试菜单 /api/message/addChild
输入参数 id=1 msg=childMsg userId=1 
点击发送写入t_message表child_msg json字段，格式为JSONARRAY

