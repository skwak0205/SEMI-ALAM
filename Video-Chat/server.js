const express = require('express');
const cors = require('cors');
const { userJoin, getCurrentUser, userLeave } = require('./utils/users');
const formatMessage = require('./utils/messages');

const app = express();
const server = require('http').Server(app);
const io = require('socket.io')(server, {
  cors: {
    origin: '*',
    methods: ['GET', 'POST'],
  },
});

const { ExpressPeerServer } = require('peer');
const peerServer = ExpressPeerServer(server, {
  debug: true,
});

//app.use('/peerjs', peerServer);

app.use(cors());

app.get('/', (req, res) => {
  res.send('Server Running....');
});

const botName = 'admin';

io.on('connection', (socket) => {
  // 화상 채팅
  socket.on('joinVideoRoom', (_id, { member_Id, room_Id }) => {
    const user = userJoin(_id, member_Id, room_Id);

    socket.join(user.room_Id);

    socket.emit(
      'videoMessage',
      formatMessage(botName, `${user.member_Id}님 환영합니다!`)
    );

    socket.broadcast.to(room_Id).emit('user-connected', _id);

    socket.broadcast
      .to(user.room_Id)
      .emit(
        'videoMessage',
        formatMessage(botName, `${user.member_Id}님이 참석하셨습니다.`)
      );

    socket.on('videoChatMessage', (member_Id, msg) => {
      const user = getCurrentUser(member_Id);

      io.to(user.room_Id).emit(
        'videoMessage',
        formatMessage(user.member_Id, msg)
      );
    });

    socket.on('disconnect', () => {
      const user = getCurrentUser(_id);

      if (user) {
        socket.broadcast.to(room_Id).emit('user-disconnected', _id);

        io.to(user.room_Id).emit(
          'videoMessage',
          formatMessage(botName, `${user.member_Id} 님이 나가셨습니다.`)
        );
      }
    });
  });

  // 채팅
  socket.on('joinChatRoom', ({ member_Id, room_Id }) => {
    const user = userJoin(socket.id, member_Id, room_Id);

    socket.join(user.room_Id);
  });

  socket.on('chatMessage', (msg, time) => {
    const user = getCurrentUser(socket.id);

    const message = { member_Id: user.member_Id, text: msg, time };

    io.to(user.room_Id).emit('message', message);
  });

  socket.on('disconnect', () => {
    console.log('disconnected');
  });
});

const port = process.env.PORT || 5000;

server.listen(port, () => {
  console.log(`Server is running on ${port}`);
});
