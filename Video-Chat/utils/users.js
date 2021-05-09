const users = [];

const userJoin = (_id, member_Id, room_Id) => {
  const user = { _id, member_Id, room_Id };

  users.push(user);

  return user;
};

const getCurrentUser = (id) => {
  return users.find((user) => user._id === id);
};

module.exports = {
  userJoin,
  getCurrentUser,
};
