import axios from "axios";

const CATEGORIES_REST_API_URL = "http://localhost:8080/api/categories";

class CategoryService {
  //categories
  getCategories() {
    return axios.get(CATEGORIES_REST_API_URL);
  }
  getCategoryById(categoryId) {
    return axios.get(CATEGORIES_REST_API_URL + "/categoryId/" + categoryId);
  }
  createCategory(category) {
    return axios.post(CATEGORIES_REST_API_URL, category);
  }
  updateCategory(categoryId, category) {
    return axios.put(CATEGORIES_REST_API_URL + "/categoryId/" + categoryId, category);
  }
  deleteCategory(categoryId) {
    return axios.delete(CATEGORIES_REST_API_URL + "/categoryId/" + categoryId);
  }

}

export default new CategoryService();
