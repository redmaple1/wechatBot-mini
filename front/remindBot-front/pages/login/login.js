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
    wx.showModal({
      title: '登陆授权',
      content: '点击进行登陆',
      confirmText: "确认",
      cancelText: "取消",
      success: function (res) {
        console.log(res);
        if (res.confirm) {
          console.log('登陆-用户点击确认')
          //显示loading
          wx.showLoading({
            title: '正在登陆',
          })
          wx.login({
            success(res) {
              if (res.code) {
                // 向后端发送请求获取session
                getSessionBack(res.code)
              } else {
                console.log('登录失败！' + res.errMsg)
                wx.hideLoading()
                wx.showToast({
                  title: '登陆失败'
                })
              }
            }
          })
        } else {
          console.log('登陆-用户点击取消')
        }
      }
    });
  }
})

function getSessionBack(code){
  console.log('js_code=' + code)
  wx.request({
    url: 'https://2ac4236b.ngrok.io/api/remindBot/login',
    data: {
      js_code: code
    },
    success(result) {
      console.log(result.data)
      wx.hideLoading()
      wx.showToast({
        title: '登陆成功'
      })
    }
  })
}
