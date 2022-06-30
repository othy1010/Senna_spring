import axios from "axios";

const ORDERS_REST_API_URL = "http://localhost:8080/api/orders";

class OrderService {
  //orders
  getOrders() {
    return axios.get(ORDERS_REST_API_URL);
  }
  getOrderById(orderId) {
    return axios.get(ORDERS_REST_API_URL + "/orderId/" + orderId);
  }
  getOrderByPatientId(patientId) {
    return axios.get(ORDERS_REST_API_URL + "/patientId/" + patientId);
  }
  createOrder(order) {
    return axios.post(ORDERS_REST_API_URL, order);
  }
  updateOrder(orderId, order) {
    return axios.put(ORDERS_REST_API_URL + "/orderId/" + orderId, order);
  }
  deleteOrder(orderId) {
    return axios.delete(ORDERS_REST_API_URL + "/orderId/" + orderId);
  }

}

export default new OrderService();
