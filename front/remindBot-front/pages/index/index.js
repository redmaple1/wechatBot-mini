//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    remindInfoList: []
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    console.log("初始化列表数据");
    wx.showLoading({
      title: '正在加载',
    })
    //从服务器拉取数据
    wx.request({
      url: getApp().globalData.baseUrl + '/remindInfo',
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      data: {
        ownerId: "testOwnerId1"
      },
      success: (res) => {
        console.log(res.data)
        var resData = res.data.data;
        var list = [resData.length];
        for (let i = 0; i < list.length; i++) {
          console.log(resData[i]);
          list[i] = resData[i];
        }
        this.setData({
          remindInfoList: list
        })
        wx.hideLoading()
      }
    })
  },
  onPullDownRefresh: () => {
    console.log("调用下拉刷新")
    wx.stopPullDownRefresh()
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
    // infoMsg = JSON.stringify(infoMsg);
    wx.navigateTo({
      url: '../remindDetail/remindDetail?objectId=' + infoMsg.objectid,
    })
  }
  
})
