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
    objectId: "",
    disabledEdit: true
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function (e) {
    console.log("remindDetail onload e=" + JSON.stringify(e));
    // var info = JSON.parse(e.remindInfo);
    this.setData({
      objectId: e.objectId
    })

    wx.request({
      url: getApp().globalData.baseUrl + '/remindInfo/' + e.objectId,
      method: 'GET',
      header: {
        // 'content-type': 'application/x-www-form-urlencoded'
      },
      success: (res) => {
        console.log(res.data)
        if (res.data.code == 0) {
          console.log("res.data.data="+JSON.stringify(res.data.data))
          this.setData({
            remindInfo: res.data.data
          })
        } else {
          wx.showToast({
            title: '加载失败',
            icon: 'none',
            duration: 1000
          })
        }
      }
    })

    
  },
  onShow(){
    console.log("onShow objectId=" + this.data.objectId)
    this.onLoad({"objectId":this.data.objectId});
  },
  editRemind: function (e) {
    var infoMsg = e.currentTarget.dataset;
    infoMsg = JSON.stringify(infoMsg);
    console.log("infoMsg="+infoMsg)
    wx.navigateTo({
      url: '../remindEdit/remindEdit?remindInfo=' + infoMsg,
    })
  }
})
