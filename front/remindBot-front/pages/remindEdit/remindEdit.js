//index.js
//获取应用实例
const app = getApp()
var checkUtil = require('../../utils/check.js')

Page({
  data: {
    remindInfo: {},
    noteMaxLen: 200,
    currentNoteLen: 0
  },
  wordLimit: function (e) {
    var value = e.detail.value, len = parseInt(value.length);
    if (len > this.data.noteMaxLen) return;

    this.setData({
      currentNoteLen: len
    });
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
      remindInfo: info,
      currentNoteLen: info.content.length
    })
  },
  formSubmit(e) {
    console.log('修改保存事件，携带数据为: ', e.detail.value)
    //前端校验
    if (!checkUtil.checkForm(e)) {
      return;
    }
    //正在提交
    wx.showToast({
      title: "正在保存",
      icon: 'loading'
    })
    wx.request({
      url: getApp().globalData.baseUrl + '/remindInfo',
      method: 'PUT',
      header: {
        // 'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        objectId: e.detail.value.objectId,
        title: e.detail.value.title,
        sendTo: e.detail.value.sendTo,
        cronExp: e.detail.value.cronExp,
        content: e.detail.value.content,
        ownerId: getApp().globalData.openId
      },
      success: (res) => {
        console.log(res.data)

        wx.hideLoading()
        if (res.data.code == 0) {
          wx.navigateBack({
            delta: 1
          })
          wx.showToast({
            title: '保存成功',
            icon: 'success',
            duration: 1000
          })
        }else{
          wx.showToast({
            title: '保存失败',
            icon: 'none',
            duration: 1000
          })
        }
      }
    })
  }
})
