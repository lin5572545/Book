var app = getApp();
Page({
  data: {
    // tab 切换
    tabArr: {
      curHdIndex: 1,
      curBdIndex: 1
    },
    buildingArray: [],
    buildingIndex: 0,
    unitArray: [],
    unitIndex: 0,
    roomArray: [],
    roomIndex: 0
  },
  changeBuilding: function (e) {
    console.log('当前选择的buildingindex:' + e.detail.value)
    this.setData({
      buildingIndex: e.detail.value
    })
  },
  changeUnit: function (e) {
    console.log('当前选择的unitindex:' + e.detail.value)
    this.setData({
      unitIndex: e.detail.value
    })
  },
  changeRoom: function (e) {
    console.log('当前选择的unitindex:' + e.detail.value)
    this.setData({
      roomIndex: e.detail.value
    })
  },
  onLoad: function () {
    // 页面初始化 options为页面跳转所带来的参数
    console.log('onLoad');
    var that = this;
    //定义几幢、几单元的临时数组，用来操作
    var currentBuildingArray = [];
    var currentUnitArray = [];
    var currentRoomArray = [];
    //添加几幢的数组
    for (var i = 1; i <= 10; i++) {
      currentBuildingArray.push(i);
      that.setData({
        buildingArray: currentBuildingArray
      })
    }
    //添加几单元的数组
    for (var k = 1; k <= 10; k++) {
      currentUnitArray.push(k);
      that.setData({
        unitArray: currentUnitArray
      })
    }
    //添加房间号的数组
    for (var n = 1; n <= 30; n++) {
        currentRoomArray.push(n);

      that.setData({
        roomArray: currentRoomArray
      })
    }
  },
  RegisterInfo: function (e) {
    e.detail.value.roomId = e.detail.value.buildingNumber + e.detail.value.unitNumber + e.detail.value.roomNumber
    console.log(e.detail.value);
    var json = JSON.stringify(e.detail.value)
    console.log("RegisterInfojson:" + json)
    console.log("url:" + app.getHeader() + '/SheQu/RegisterUser')
    wx.request({
      url: app.getHeader() + '/SheQu/registerUser', // 拼接接口地址
      method: 'post',
      data: json,
      contentType: 'application/json',
      success(res) {
        console.log('res:' + res)
        if (res.data == "success") {
          wx.showToast({
            title: '注册成功',
            icon: 'success',
            duration: 2000
          })
        } else {
          wx.showToast({
            title: '注册失败',
            duration: 1000,
            icon: 'none'
          })
        }
      }
    })
  },
  UserLogin:function(e){
    var json = JSON.stringify(e.detail.value)
    console.log("userlogin:" + json)
    wx.request({
      url: app.getHeader() + '/SheQu/userLogin', // 拼接接口地址
      method: 'post',
      data: json,
      contentType: 'application/json',
      success(res) {
        console.log('res.data:' + res.data)
        app.globalData.uid = res.data
        if (res.data != "failure") {
          wx.showToast({
            title: '登录成功',
            icon: 'success',
            duration: 2000
          })
        } else {
          wx.showToast({
            title: '登录失败',
            duration: 1000,
            icon: 'none'
          })
        }
      }
    })
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
  //tab切换
  tab: function (e) {
    //var dataId = e.currentTarget.dataset.id;
    var dataId = e.currentTarget.id;
    var obj = {};
    obj.curHdIndex = dataId;
    obj.curBdIndex = dataId;
    this.setData({
      tabArr: obj
    })
    console.log(obj);
  },
  showok: function () {
    wx.showToast({
      title: '信息提交成功',
      icon: 'success',
      duration: 2000
    })
  }
})



