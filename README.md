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

3/6

Q：

+ 支付部分如何处理？钱如何转账？
+ 前端主页要修改图片，文字内容，去掉顺丰之类的内容。做成有个人特色的页面。
+ 实名认证。身份证上传，接单的时候的车票上传？

支付api  寄件插入cost 5元

身份证认证、头像
