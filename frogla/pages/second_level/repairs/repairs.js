var app = getApp()
var total = [];
var tempFilePaths;
var uid;
Page({
  data:{
    imageUrl: [],
    _num:3,
    suggestsList:[],
    
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
    console.log("repaire.js的uid:" + app.globalData.uid)
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
  bindFormSubmit: function(e) {
    console.log(e.detail.value.textarea)
  },
  chooseImg: function(){
    var that = this;
    wx.chooseImage({
      count: 3, 
      sizeType: ['original', 'compressed'], 
      sourceType: ['album', 'camera'],
      success: function (res) {
        tempFilePaths = res.tempFilePaths
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        that.uploadFile2(tempFilePaths, 0);
        var uploadedImageLists = that.data.imageUrl;
        var totalImages = uploadedImageLists.concat(res.tempFilePaths);
        var aNum = 0;
        if (totalImages.length >= 3) {
          totalImages.length = 3;
          aNum = 1;
        }
        console.log(totalImages)
        that.setData({
          num: 0,
          addNum: aNum,
          imageUrl: totalImages
        })
      }
    })
  },
  uploadFile2: function (file, i) {//递归调用
    var that = this;
    wx.uploadFile({
      url: app.getHeader() +'/SheQu/uploadWxImg', //仅为
      filePath: file[i],
      name: 'img',
      success: function (res) {
        var obj = new Object();
        obj.ind = i + 1;
        var data = res.data;
        console.info(data);
        obj.src = data;
        console.info("--------------*****-------------------");
        console.info(obj);
        if (!((i + 1) == file.length)) {
          total.push(obj);
          that.uploadFile2(file, i + 1);
        } else {
          total.push(obj);
          that.setData({ perImgSrc: total });
        }
      }
    })
  },
  removeImage: function(e){
    var that = this;
    var currentImageLists = that.data.imageUrl; 
    currentImageLists.splice(e.target.dataset.index,1);
    that.setData({
        imageUrl:currentImageLists
    })
    if(currentImageLists.length < 3 && currentImageLists.length >= 1) {
       that.setData({
            addNum: 0
       })
    } else if(currentImageLists.length == 0) {
       that.setData({
            addNum: 1,
            num: 1
       })
    }
  },
  preImage:function(e){
    var that = this;
    var currentImageUrl = that.data.imageUrl[e.target.dataset.index]
    wx.previewImage({
      current: currentImageUrl, // 当前显示图片的http链接
      urls: that.data.imageUrl // 需要预览的图片http链接列表
    })
  },
  formSubmit: function(e) {
    console.log("tempFilePaths:" + tempFilePaths)
    console.log("userinfo"+app.globalData.userInfo)
    if (app.globalData.userInfo.length==0){
        console.log("sssfkwn;")
    }
    var that = this;
    //var suggestsList = [];
    uid = app.globalData.uid
    console.log("uid:"+uid)
    console.log("repair:" + json)
    if(uid==''){
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    }else{
      e.detail.value.uid = uid
      e.detail.value.imageUrl = tempFilePaths
      var repair = e.detail.value;
      //var currentSuggestsList = suggestsList.push(suggest);
      var json = JSON.stringify(repair)
      wx.request({
        url: app.getHeader() + '/SheQu/insertRepair', // 拼接接口地址
        method: 'post',
        data: json,
        contentType: 'application/json',
        success(res) {
          console.log('res:' + res)
          if (res.data == "success") {
            wx.showToast({
              title: '信息提交成功',
              icon: 'success',
              duration: 2000
            })
          } else {
            wx.showToast({
              title: '信息提交失败',
              duration: 1000,
              icon: 'none'
            })
          }
        }
      })
    }
  } 
})