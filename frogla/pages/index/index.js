//index.js
//获取应用实例
var app = getApp()
Page({ 
  data: {
    imgUrls: [
      '../../images/slider_1.jpeg',
      '../../images/slider_2.jpeg',
      '../../images/slider_3.jpeg'
    ],
    indicatorDots: true,
    autoplay: true,
    interval: 5000,
    duration: 1000
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  goods: function() {
    wx.navigateTo({
      url: '../second_level/secondhand/goods'
    })
  },
  notice: function() {
    wx.navigateTo({
      url: '../second_level/wenzhang/wenzhang'
    })
  },
  repairs: function() {
    wx.navigateTo({
      url: '../second_level/repairs/repairs'
    })
  },
  onLoad: function () {
    console.log('onLoad')
    
  },
  tapName: function(event) {
    console.log(event)
  }
})

