import axios from "axios";

const COMPOSANTS_REST_API_URL = "http://localhost:8080/api/composants";

class ComposantService {
  //composants
  getComposants() {
    return axios.get(COMPOSANTS_REST_API_URL);
  }
  getComposantById(composantId) {
    return axios.get(COMPOSANTS_REST_API_URL + "/composantId/" + composantId);
  }
  createcomposant(composant) {
    return axios.post(COMPOSANTS_REST_API_URL, composant);
  }
  updatecomposant(composantId, composant) {
    return axios.put(COMPOSANTS_REST_API_URL + "/composantId/" + composantId, composant);
  }
  deletecomposant(composantId) {
    return axios.delete(COMPOSANTS_REST_API_URL + "/composantId/" + composantId);
  }

}

export default new ComposantService();

