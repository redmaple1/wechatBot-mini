//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    remindInfo: {},
    disabledEdit: true
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
  },
  editRemind: function (e) {
    var infoMsg = e.currentTarget.dataset;
    debugger
    infoMsg = JSON.stringify(infoMsg);
    wx.navigateTo({
      url: '../remindEdit/remindEdit?remindInfo=' + infoMsg,
    })
  }
})
