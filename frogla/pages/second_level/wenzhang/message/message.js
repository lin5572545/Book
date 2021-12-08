// pages/second_level/notice/message/message.js
var app = getApp()
var Parser = require('../../../../lib/dom-parser')
Page({
  data:{
    
  },
  onLoad:function(options){
    var that = this
    // console.log(options); 
    // var notice_messages = app.data.messages;
    // var i;
    
    // console.log(notice_messages);
    // //页面初始化 options为页面跳转所带来的参数
    // for(i = 0;i < notice_messages.length;i++){
    //   if(notice_messages[i].id == options.id){
    //     this.setData({
    //       current_message:notice_messages[i]
    //     })
    //   }
    // } 
    console.log(options.content)
    var url = app.getHeader() + '/SheQu/word/' + options.content
    wx.request({
      url: url, // 拼接接口地址
      method: 'get',
      success(res) {
        if (res) {
          //console.log(res)  // 打印查看是否请求到接口数据
          var xml = res.data
          var XMLParser = new Parser.DOMParser()
          var doc = XMLParser.parseFromString(xml)
          var a = doc.getElementsByTagName('content')['0'];
          console.log(a)
          console.log("xml内容："+a.firstChild.nodeValue); 
          res = a.firstChild.nodeValue
          console.log("img:"+options.img)
          that.setData({
            res: res,
            time: options.time,
            author: options.author,
            title: options.title,
            img: app.getHeader() +'/SheQu/img/'+options.img
          })
        } else {
          console.log('没有数据')
        }
      }
    })
  },
  onReady:function(){
    // 页面渲染完成
  },
  onShow:function(){
    // 页面显示
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  }
})