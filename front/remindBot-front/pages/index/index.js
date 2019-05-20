//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    delBtnWidth: 185, //删除按钮宽度单位（rpx）
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
    
    if(app.globalData.userInfo){
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
      //从服务器拉取数据
      this.fetchRemindInfoList()
    }else if(this.data.canIUse){
      app.userInfoReadyCallback = res => {
        console.log("执行了rollback")
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }

      app.openIdReadyCallback = res => {
        //从服务器拉取数据
        console.log("执行了openId rollback")
        this.fetchRemindInfoList()
      }
    }else{
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
          this.fetchRemindInfoList()
        }
      })
    }
    
  },
  onShow: function() {
    this.onLoad()
  },
  onPullDownRefresh: function() {
    console.log("调用下拉刷新")
    wx.showNavigationBarLoading()
    this.fetchRemindInfoList()
    wx.hideNavigationBarLoading()
  },
  fetchRemindInfoList(){
    wx.showLoading({
      title: '正在加载',
    })
    wx.request({
      url: getApp().globalData.baseUrl + '/remindInfo',
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      data: {
        ownerId: getApp().globalData.openId
      },
      success: (res) => {
        console.log(res.data)
        var resData = res.data.data;
        var list = new Array(resData.length);
        for (let i = 0; i < list.length; i++) {
          console.log(resData[i]);
          list[i] = resData[i];
        }
        this.setData({
          remindInfoList: list
        })
        wx.hideLoading()
      },
      fail: () => {
        wx.hideLoading()
        wx.showToast({
          title: '加载失败',
          icon: 'none'
        })
      }
    })
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
  },
  
})
