//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  scanCode: function() {
    wx.scanCode({
      onlyFromCamera: true,
      scanType: ['qrCode'],
      success: function(res) {
        console.log("扫码成功");
      },
      fail: function(res) {},
      complete: function(res) {
        console.log("扫码完成");
      },
    })
  }
})
