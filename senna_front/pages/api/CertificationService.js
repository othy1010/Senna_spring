import axios from "axios";

const CERTIFICATIONS_REST_API_URL = "http://localhost:8080/api/certifications";

class CertificationService {
  //certifications
  getCertifications() {
    return axios.get(CERTIFICATIONS_REST_API_URL);
  }
  getCertificationById(certificationId) {
    return axios.get(CERTIFICATIONS_REST_API_URL + "/certificationId/" + certificationId);
  }
  createCertification(certification) {
    return axios.post(CERTIFICATIONS_REST_API_URL, certification);
  }
  updateCertification(certificationId, certification) {
    return axios.put(CERTIFICATIONS_REST_API_URL + "/certificationId/" + certificationId, certification);
  }
  deleteCertification(certificationId) {
    return axios.delete(CERTIFICATIONS_REST_API_URL + "/certificationId/" + certificationId);
  }

}

export default new CertificationService();
