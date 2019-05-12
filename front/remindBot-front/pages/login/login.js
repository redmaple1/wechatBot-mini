//logs.js
const util = require('../../utils/util.js')

Page({
  data: {
    logs: []
  },
  onLoad: function () {
    this.setData({
      logs: (wx.getStorageSync('logs') || []).map(log => {
        return util.formatTime(new Date(log))
      })
    })
  },
  openLoginConfirm: function(){
    wx.login({
      success(res) {
        if (res.code) {
          // 发起网络请求
          console.log('res.code=' + res.code)
          // wx.request({
          //   url: 'https://test.com/onLogin',
          //   data: {
          //     code: res.code
          //   }
          // })
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
    // wx.showModal({
    //   title: '登陆授权',
    //   content: '弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内',
    //   confirmText: "主操作",
    //   cancelText: "辅助操作",
    //   success: function (res) {
    //     console.log(res);
    //     if (res.confirm) {
    //       console.log('用户点击主操作')
    //     } else {
    //       console.log('用户点击辅助操作')
    //     }
    //   }
    // });
  }
})
