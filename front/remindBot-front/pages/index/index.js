//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    remindInfoList: getRemindInfo()
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  gotoCreate: function(){
    console.log("gotoCreate");
    wx.navigateTo({
      url: '../create/create',
    })
  },
  detail: function (e) {
    var infoMsg = e.currentTarget.dataset;
    infoMsg = JSON.stringify(infoMsg);
    wx.navigateTo({
      url: '../remindDetail/remindDetail?remindInfo=' + infoMsg,
    })
  }
  
})

function getRemindInfo() {
  console.log("初始化列表数据");
  let list = [10];
  for (let i = 0; i < 10; i++) {
    let remindInfo = { "id": i,
                       "objectId": i,
                       "title": "提醒事项" + i,
                       "sendTo": "接收人" + i,
                       "cronExp": "cron" + i,
                       "content": "提醒内容" + i }
    list[i] = remindInfo;
  }
  return list;
}
