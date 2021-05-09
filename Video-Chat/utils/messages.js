const moment = require('moment');
require('moment-timezone');

moment.tz.setDefault('Asia/Seoul');

const formatMessage = (username, text) => {
  return {
    username,
    text,
    time: moment().format('h:mm a'),
  };
};

module.exports = formatMessage;
