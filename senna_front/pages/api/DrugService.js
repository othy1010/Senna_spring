import axios from "axios";

const DRUGS_REST_API_URL = "http://localhost:8080/api/drugs";

class DrugService {
  //drugs
  getDrugs() {
    return axios.get(DRUGS_REST_API_URL);
  }
  getDrugById(drugId) {
    return axios.get(DRUGS_REST_API_URL + "/drugId/" + drugId);
  }
  getDrugByPatientId(patientId) {
    return axios.get(DRUGS_REST_API_URL + "/patientId/" + patientId);
  }
  getDrugByDrugUsage(drugUsage) {
    return axios.get(DRUGS_REST_API_URL + "/drugUsage/" + drugUsage);
  }
  getDrugByDrugName(drugName) {
    return axios.get(DRUGS_REST_API_URL + "/drugName/" + drugName);
  }
  getDrugByDrugSupplierId(drugSupplierId) {
    return axios.get(DRUGS_REST_API_URL + "/drugSupplierId/" + drugSupplierId);
  }
  createDrug(drug) {
    return axios.post(DRUGS_REST_API_URL, drug);
  }

  updateDrug(drugId, drug) {
    return axios.put(DRUGS_REST_API_URL + "/drugId/" + drugId, drug);
  }
  deleteDrug(drugId) {
    return axios.delete(DRUGS_REST_API_URL + "/drugId/" + drugId);
  }

}

export default new DrugService();
