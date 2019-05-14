//index.js
//获取应用实例
const app = getApp()
var checkUtil = require('../../utils/check.js')

Page({
  data: {


  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function() {

  },
  formSubmit(e) {
    console.log('form发生submit事件，携带数据为: ', e.detail.value)
    //前端校验
    if(!checkUtil.checkForm(e)){
      return;
    }
    //正在提交
    wx.showToast({
      title: "正在提交",
      icon: 'loading'
    })
    wx.request({
      url: getApp().globalData.baseUrl + '/remindInfo',
      method: 'POST',
      header: {
        // 'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        title: e.detail.value.title,
        sendTo: e.detail.value.sendTo,
        cronExp: e.detail.value.cronExp,
        content: e.detail.value.content,
        ownerId: "testOwnerId"
      },
      success: (res) => {
        console.log(res.data)
        
        wx.hideLoading()
        if(res.data.code == 0){
          wx.navigateBack({
            delta: 1
          })
          wx.showToast({
            title: '创建提醒成功',
            icon: 'success',
            duration: 1000
          })
        }
        
      }
    })
  },
  formReset() {
    console.log('form发生了reset事件')
  }
})

