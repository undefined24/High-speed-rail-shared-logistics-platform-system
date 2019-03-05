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
+ 收件部分，利用api信息来修改一下匹配查找。
+ 实名认证。身份证上传，接单的时候的车票上传？
+ 我的寄件和接件账单号id和物品id重复，是否删除，我的寄件换成接单用户的id？
+ 车次的api能否得到发车时间？是做成选择器让用户选择还是匹配还是删去时间选择？



测试部分：

Bug:

+ **确认送达应放在寄件那里，要调整位置**(已调整，待测试)
+ 接件选择日期如果不选会变成1899年
+ 前端页面显示接件统一称为接件 如图需要修改：![image-20190306001942582](/Users/zhongteng/Library/Application Support/typora-user-images/image-20190306001942582.png)
+ js提示字改成红色
+ sender起始站点css js需要修改



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
