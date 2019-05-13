//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    remindInfo: {}
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function (e) {
    console.log(e);
    var info = JSON.parse(e.remindInfo);
    this.setData({
      remindInfo: info
    })
  }
})
