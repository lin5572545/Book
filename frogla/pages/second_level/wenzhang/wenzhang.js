// pages/second_level/notice/notice.js
var app = getApp()
var Parser = require('../../../lib/dom-parser')
Page({
  data:{
    userInfo: {}, 
    messages:{},
  },
  onLoad:function(){
    var that = this
    console.log('notices.js----->openid:' + app.globalData.openid)

    // // 页面初始化 options为页面跳转所带来的参数
    // console.log(app.globalData.userInfo);
    // console.log(app);
    // var notice_messages = app.data.messages;
    // var user_info = app.globalData.userInfo;
    // this.setData({
    //     userInfo:user_info,
    //     messages:notice_messages
    // });
    // console.log(app.users);
    // wx.request({
    //   url: 'http://192.168.31.247:8080/SheQu/word/Message.xml', // 拼接
    //   method: 'GET',
    //   header: { "Content-Type": "application/xml" },
    //   success(res) {
    //     if (res) {
    //       // 开始获取数据 eg: textBox(获取文字内容)
    //       var xml = res.data
    //       var XMLParser = new Parser.DOMParser()

    //       var doc = XMLParser.parseFromString(xml)

    //       var a = doc.getElementsByTagName('content')['0'];
    //       console.log("xml内容："+a.firstChild.nodeValue); 
    //     } else {
    //       console.log('没有数据')
    //     }
    //   }, fail() {
    //     console.log("评价请求失败!")
    //   }
    // })

    wx.request({
      url: app.getHeader()+'/SheQu/getAllMessage',
      method: 'GET',
      header: {
        'content-type': 'application/json;charset=UTF-8' // 默认值
      },
      success: function (res) {
        that.setData({
          list: res.data,
          gl: app.getHeader() +'/SheQu/img'
        })
      },
      fail() {
        console.log('xxsad')
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
  },
  // enterMessage:function(){
  //   wx.navigateTo({
  //     url: 'message/message'
  //   })
  // }
})