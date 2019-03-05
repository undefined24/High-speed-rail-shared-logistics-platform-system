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

3/5

Q：

+ 支付部分如何处理？钱如何转账？
+ 前端主页要修改图片，文字内容，去掉顺丰之类的内容。做成有个人特色的页面。



测试部分：

Bug:

+ 寄件管理页面 修改物品后点击**下面的1**，会出现404

已完成：

+ 用户登陆+管理者登陆
+ 管理员 按钮调整了颜色
  + 员工管理测试正常
  + 寄件管理 1bug
  + 用户管理测试正常
  + 注销正常
+ 用户个人中心无误
+ 寄件没问题
+ **收件 测试有问题 每一次都弹无适合我的用品**
  + 这里我修改成先进行前端检验 再用你的getList函数。这样逻辑更好。