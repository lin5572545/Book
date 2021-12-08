// pages/second_level/notice/notice.js
var app = getApp()
var uid;
var Parser = require('../../../lib/dom-parser')
Page({
  data: {
    userInfo: {},
    messages: {},
  },
  onLoad: function () {
    var that = this
    console.log('notices.js----->openid:' + app.globalData.openid)


    uid = app.globalData.uid
    console.log("uid:" + uid)
    if (uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    }else{
      wx.request({
        url: app.getHeader() + '/SheQu/findAllGoods',
        method: 'GET',
        header: {
          'content-type': 'application/json;charset=UTF-8' // 默认值
        },
        success: function (res) {
          that.setData({
            list: res.data,
            gl: app.getHeader() + '/SheQu/img'
          })
        },
        fail() {
          console.log('xxsad')
        }
      })
    }
  },
  onReady: function () { 
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  bookTap: function (e) {
    console.log("bookTap:" + e.currentTarget.dataset.aid)
    wx.navigateTo({
      url: 'goodspay/goodspay?id=' + e.currentTarget.dataset.aid
    })
  },
  search: function (e) {
    // 拿到输入框的值
    //var value  = e.detail.value
    // console.log(value);
      wx.navigateTo({
        url: `goodspay/goodspay?id=`+e.detail.value
      })
  }
})




