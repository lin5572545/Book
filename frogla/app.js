//app.js
var app = getApp()
App({
  data:{
    users: [   
    ]
    
  },
  onLaunch: function () {
   
    //调用API从本地缓存中获取数据
    var _this = this
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs);
    wx.login({
      success: res => {
        console.log('qwerty')
        wx.request({
          url: _this.getHeader()+'/SheQu/getOpenid', //接口地址
          data: { code: res.code },
          header: {
            'content-type': 'application/json' //默认值
          },
          success: function (res) {
            _this.globalData.openid = res.data.openid;
            console.log("openid:" + _this.globalData.openid)
          },fail:function(res){
            console.log("error:" + res)
          }
        })
      }
      , fail(err) {
        console.log('wx失败' + err)
      }
    })
    //把快递信息存进缓存
    // var totalExpresses = this.data.expresses;
    // wx.setStorage({
    //   key:"expresses",
    //   data:totalExpresses
    // });

  
  },
  getUserInfo: function (cb) {
    var that = this
    if (this.globalData.userInfo) {
      typeof cb == "function" && cb(this.globalData.userInfo)
    } else {
      //调用登录接口
      wx.login({
        success: function () {
          wx.getUserInfo({
            success: function (res) {
              that.globalData.userInfo = res.userInfo
              typeof cb == "function" && cb(that.globalData.userInfo)
            }
          })
        }
      })
    }
  },
  globalData:{
    userInfo:null,
    messages :[],
    openid:'',
    uid:'',
    protocol: "http://",
    // host: "47.106.168.136",
    // port: "8888",
    host: "localhost",
    port: 8080,
    openid: '',//用户唯一标志ids
  },
  /**
* 封装请求头
*/
  getHeader() {
    var protocol = this.globalData.protocol
    var host = this.globalData.host
    var port = this.globalData.port
    var header = protocol + host + ':' + port
    console.log('header:' + header)
    return header;
  },
  fliteremoji: function (str) {
    str = str.replace(/\uD83C[\uDF00-\uDFFF]|\uD83D[\uDC00-\uDE4F]/g, "")
  },
  showToast(title, duration, icon) {
    wx.showToast({
      title: title ? title : '网络繁忙，请扫后重试！',
      duration: duration || 1000,
      icon: icon || 'none'
    })
  }
})