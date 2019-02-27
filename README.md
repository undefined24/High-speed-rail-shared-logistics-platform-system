# High-speed-rail-shared-logistics-platform-system
高铁共享物流平台系统
2019-1-31 打卡 钟腾

back-end 为后端文件夹 前端文件另外拉取分支，完成后再合并到master

整合时html文件改为jsp格式放在WebContent->WEB-INF->pages文件夹下，其他文件如index.js在WebContent文件夹下创建js文件夹分别归类

resources->mapper 保存读写数据库的文件
src->controller 控制器文件
​     ->dao mapper接口文件
​     ->service 封装dao中的接口
​     ->vo 对象类

db.properties 连接数据库
index.jsp 首页

## 前端文件夹

-> platform



### 问题汇总与解决

2/28

Q：

+ 注册页面 后台返回注册成功异常
+ 前端的物流查询记录排版