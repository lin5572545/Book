// pages/second_level/notice/notice.js
var app = getApp()
var uid;
Page({
  data: {
    userInfo: {},
    messages: {},
  },
  onLoad: function () {
    var that = this
    console.log('notices.js----->openid:' + app.globalData.openid)
    uid = app.globalData.uid
    console.log("uid:" + app.globalData.uid)
    if (app.globalData.uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    } else {
      wx.request({
        url: app.getHeader() + '/SheQu/findMyGoods',
        method: 'GET',
        header: {
          'content-type': 'application/json;charset=UTF-8' // 默认值
        },
        data: { "uid": app.globalData.uid},
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
      url: '../second_level/secondhand/goodspay/goodspay?id=' + e.currentTarget.dataset.aid
    })
  },
})