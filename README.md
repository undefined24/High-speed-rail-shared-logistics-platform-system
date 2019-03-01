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

3/1

Q：

+ 寄件表单里面的姓名和用户注册里的真实姓名js要改

  + 出现bug，在1.js写的函数无法在html中调用，而插入为html的script标签没问题。
  + 现我暂时写在html中，但是这也导致在名字报错后，马上点击注册会马上post成功，而不会被前端所拒绝。
  + 解决方案：应将识别真实姓名的函数放回js文件并添加的表单查验中去

+ **前端的物流查询记录排版已上传**，完成查询功能(已完成，接件订单显示待测试)
+  可将user_center页面中寄件收件表单删除
+  user_center要在寄件订单每条信息旁边加一个确认收货的按钮，格式跟管理员员工管理的删除一样
+  接件页面新增的高铁到达点需要改样式和js，接件时间需要做js选择器，可选时间为未来。
+  接见查询后需要新的页面  ！！！

+  管理员修改寄件为完成时增加了记录的完成时间（待测试）
