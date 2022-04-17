# Book
基于java web ssm（Springboot+SpringMVC+Mybatis）+Mysql+微信小程序的图书捐赠管理系统设计与实现毕业设计论文

使用软件 idea mysql数据库 微信开发者工具 tomcat  Navicatpremium

该项目源于https://www.bilibili.com/video/BV1aD4y1X77R?p=2进行修改

登录不了看pom文件有没有报红，数据库配置是否正确。图片文件夹在tomcat配置里自己重新添加

使用教程 idea运行shequ文件 jdbc.properties中username和password改成自己的数据库用户名以及密码
<img width="935" alt="144386118-ca647489-d1a0-4613-bbcd-3aaec32b9f37" src="https://user-images.githubusercontent.com/85597324/145163152-fa5f3f79-720a-447e-9bdb-2861030905d0.png">

Navicatpremium软件 mysql 导入运行sql数据库文件

微信开发者工具 运行frogla文件




本图书捐赠管理系统的用户角色设计分析是分两部分的，根据不同用户的不同角色，对系统进行用例设计，为后续设计做铺垫。
本系统主要分为普通用户和管理员。普通用户主要是对微信小程序进行系统的使用。而管理员主要是对本图书捐赠管理系统的所有信息进行管理，主要包括用户这部分所涉及到的信息等进行管理。

小程序前端用户的主要功能有：
注册登录，普通用户可填写信息进行注册登录以享用功能。
文章查看，普通用户可查看发表的文章。
意见反馈，普通用户可对小程序的使用问题进行反馈。
图书查看，普通用户可看到所有捐赠图书信息，根据提供的图书编号进行查询。
图书收藏，普通用户可对捐赠图书进行收藏。
公告查看，普通用户可看到管理员发布的公告。

后台管理者主要功能有：
文章添加，管理员可根据投稿文章对小程序进行文章添加。
图书添加，管理员可根据捐赠人信息对小程序进行捐赠图书添加。
图书收藏，管理员可查询到用户收藏图书情况。
意见反馈，管理员可查询到用户意见反馈内容。






运行效果简介


4.1首页功能
图书捐赠管理系统小程序系统的主页有三部分组成，即首页，公告，我的。其中首页部分为本系统最主要的部门，提供了文章阅读、意见反馈以及图书查询功能。进入后显示的页面如下图所示。
![image](https://user-images.githubusercontent.com/85597324/145163998-cf4743d7-1161-41bb-b4f2-fdc0a761823a.png)


4.2文章功能
改功能主要实现文章阅读，文章由管理员进行审核发表后，用户可在改功能下进行选读文章。
 ![image](https://user-images.githubusercontent.com/85597324/145164011-4bd5a9fd-6669-4d51-8eae-b839b94b8629.png)


4.3图书功能
该功能为本系统主要模块，需要登录才可以使用，一共由四个功能模块组成，分别是图书列表、图书详细、图书搜索以及图书收藏。
图书列表由管理员进行审核发布捐赠图书相关信息，用户可在改功能下进行选择捐赠图书查看详细。
图书详细由用户点击详细查看功能进行图书详细查看捐赠图书的捐赠人简介、图书寄语以及捐书时间以及立即收藏功能。
图书收藏由用户点击立即收藏对喜欢的图书进行收藏。
图书搜索由用户输入图书编号对图书列表进行精确检索，搜索即转跳到对应图书编号的图书详细页面。
 
![image](https://user-images.githubusercontent.com/85597324/145164050-cb6e16b4-15fb-4481-a3fd-c027f3bfd716.png)
![image](https://user-images.githubusercontent.com/85597324/145164063-eadd439c-305b-4dae-9644-2db48e586469.png)
![image](https://user-images.githubusercontent.com/85597324/145164074-3f87e844-5b2a-4cbd-9ec6-90bb58a46df2.png)
![image](https://user-images.githubusercontent.com/85597324/145164086-acdecee0-ab7b-45ed-880f-16fb2241c6af.png)


4.4意见功能
该功能主要实现由用户对软件使用问题以及软件使用问题进行反馈，反馈内容可有文字以及图片，反馈后由管理员在后台进行查看处理。
 
![image](https://user-images.githubusercontent.com/85597324/145164110-2f192208-8aa2-4415-96eb-f1edceebe214.png)


4.5公告功能
公告由管理员进行发布，用户可随时查看公告内容。

 ![image](https://user-images.githubusercontent.com/85597324/145164125-79f0419c-e3b1-437c-835c-b6a378411968.png)


4.6我的功能
主要实现用户登录与注册功能以及我的图书收藏查看功能。
 ![image](https://user-images.githubusercontent.com/85597324/145164134-e7116098-11db-42f2-885c-335ffbbfefbe.png)

4.7注册功能
该功能主要由用户进行填写性别、选择性别、选择学舍房间号、手机号以及密码进行注册。
 ![image](https://user-images.githubusercontent.com/85597324/145164151-f35dc404-a71b-4b52-b5b4-2e606cd5e6eb.png)


4.8登录功能
该功能主要由用户输入注册时使用的手机号以及密码进行登录。
 ![image](https://user-images.githubusercontent.com/85597324/145164165-c8683ccd-9e20-4ac4-afa5-fe1abc9e3eef.png)


4.9收藏功能
改功能主要由用户对收藏的图书进行查看，以及查看图书详细功能。该功能需登录后才可以使用。


![image](https://user-images.githubusercontent.com/85597324/145163392-cae41d3f-fccb-49c5-8098-dafb495b78d0.png)



后台效果

![image](https://user-images.githubusercontent.com/85597324/145164268-c8691791-ee7e-4511-b1c1-2131a90682ba.png)
![image](https://user-images.githubusercontent.com/85597324/145164296-5a0e49a7-6a36-4cfc-b1d5-f59ebbdd81b6.png)
![image](https://user-images.githubusercontent.com/85597324/145164306-c9bd20bf-5e71-4ed4-a7d9-5625d4338102.png)
![image](https://user-images.githubusercontent.com/85597324/145164319-3a2de303-a29f-4f91-bb46-dc9486d618ac.png)

