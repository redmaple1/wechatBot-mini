var cronUtil = require('../utils/cron.js')

const checkForm = (e) => {
  var title = e.detail.value.title;
  var sendTo = e.detail.value.sendTo;
  var cronExp = e.detail.value.cronExp;
  var content = e.detail.value.content;

  if (title.length == 0) {
    wx.showToast({
      title: '提醒标题不能为空',
      icon: 'none'
    })
    return false;
  }
  if (title.length > 15) {
    wx.showToast({
      title: '提醒标题不能超过15字',
      icon: 'none'
    })
    return false;
  }
  if (sendTo.length == 0) {
    wx.showToast({
      title: '提醒对象不能为空',
      icon: 'none'
    })
    return false;
  }
  if (sendTo.length == 0) {
    wx.showToast({
      title: '提醒对象不能为空',
      icon: 'none'
    })
    return false;
  }
  if (cronExp.length == 0) {
    wx.showToast({
      title: 'cron表达式不能为空',
      icon: 'none'
    })
    return false;
  }
  if (!cronUtil.cronValidate(cronExp)) {
    return false;
  }
  if(content.length == 0){
    wx.showToast({
      title: '提醒内容不能为空',
      icon: 'none'
    })
    return false;
  }
  return true;
}

module.exports = {
  checkForm: checkForm
}