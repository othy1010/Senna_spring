import axios from "axios";

const USERS_REST_API_URL = "http://localhost:8080/api/users";

class UserService {
   //users
   createUser(user) {
      return axios.post(USERS_REST_API_URL, user);
   }
   getUsers() {
      return axios.get(USERS_REST_API_URL);
   }
   getUserById(userId) {
      return axios.get(USERS_REST_API_URL + "/userId/" + userId);
   }
   //   getUserByEmail(email) {
   //     return axios.get(USERS_REST_API_URL + "/email/" + email);
   //   }
   updateUser(userId, user) {
      return axios.put(USERS_REST_API_URL + "/userId/" + userId, user);
   }
   deleteUser(userId) {
      return axios.delete(USERS_REST_API_URL + "/userId/" + userId);
   }

   //   findByEmail(email) {
   //     return axios.get(USERS_REST_API_URL + "/email/" + email);
   //   }
}

export default new UserService();
