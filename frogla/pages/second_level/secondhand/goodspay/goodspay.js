var app = getApp()
var id;
var uid;
Page({
  data: {
  },
  onLoad: function (options) {
    id = options.id;
    var that = this;
    wx.request({
      url: app.getHeader() + '/SheQu/findGoodsById',
      method: 'GET',
      header: {
        'content-type': 'application/json;charset=UTF-8' // 默认值
      },
      data:{"id":id},
      success: function (res) {
        that.setData({
          data: res.data,
          gl: app.getHeader() + '/SheQu/img'
        })
      },
      fail() {
        console.log('xxsad')
      }
    })
  },
  buyGoods:function(e){
    console.log("buyGoods------>")
    uid = app.globalData.uid
    console.log("app.globalData.uid:" + app.globalData.uid)
    if (app.globalData.uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    }else{
      wx.request({
        url: app.getHeader() + '/SheQu/insertBuyGoods', // 拼接接口地址
        method: 'post',
        data: { "goods_id": id, "uid": app.globalData.uid },
        contentType: 'application/json',
        success(res) {
          console.log('res:' + res.data)
          if (res.data == "success") {
            wx.showToast({
              title: '收藏成功',
              icon: 'success',
              duration: 2000
            })
          } else {
            wx.showToast({
              title: '收藏失败',
              duration: 1000,
              icon: 'none'
            })
          }
        }
      })
    }
  }
})