import { useRouter } from 'next/router'
import axios from 'axios';


// const bk_url = "http://localhost:8080"
const DRUGS_REST_API_URL = `http://${process.env.backend_URL}:8080/api/drugs`;
class DrugService {
  async getDrugs() {
    try {
      const response = await fetch(DRUGS_REST_API_URL)
      return response;
    }
    catch (err) {
      console.log(err)
      throw (err)
    }
  }
  async getDrugById(drugId) {
    try {
      const response = await axios.get(`${DRUGS_REST_API_URL}/drugId/${drugId}`)
      return response;
    }
    catch (err) {
      console.log(err, "🚚")
      console.log(err.request, "💥")
      throw (err)
    }
  }
  async getDrugByPatientId(patientId) {
    try {
      const response = await axios.get(`${DRUGS_REST_API_URL}/patientId/${patientId}`)
      return response;
    }
    catch (err) {
      console.log(err, "🚚")
      console.log(err.request, "💥")
      throw (err)
    }
  }
  async getDrugByDrugUsage(drugUsage) {
    try {

      const response = await axios.get(`${DRUGS_REST_API_URL}/drugUsage/${drugUsage}`)
      return response;
    }
    catch (err) {
      console.log(err, "🚚")
      console.log(err.request, "💥")
      throw (err)
    }
  }
  async getDrugByDrugName(drugName) {
    try {
      const response = await axios.get(`${DRUGS_REST_API_URL}/drugName/${drugName}`)
      return response;
    }
    catch (err) {
      console.log(err, "🚚")
      console.log(err.request, "💥")
      throw (err)
    }
  }
  async getDrugByDrugSupplierId(drugSupplierId) {
    try {
      const response = await axios.get(`${DRUGS_REST_API_URL}/drugSupplierId/${drugSupplierId}`)
      return response;
    }
    catch (err) {
      console.log(err, "🚚")
      console.log(err.request, "💥")
      throw (err)
    }
  }
  async createDrug(drug) {
    try {
      const response = await axios.post(`/api/drugs/`, drug);
      console.log("⚡create_request_drug⚡")
    }
    catch (err) {
      console.log(err, "🚚")
      throw (err)
    }
  }
  async updateDrug(drugId, drug) {
    try {
      await axios.put(`/api/drugs/drugId/${drugId}`, drug);
      console.log("⚡updateDrug⚡")

    }
    catch (err) {
      console.log(err)
      throw (err)
    }
  }
  async deleteDrug(drugId) {
    try {
      await axios.delete(`/api/drugs/drugId/${drugId}`);
      console.log("⚡delete_request_drug⚡")
    }
    catch (err) {
      console.log(err)
      throw (err)
    }
  }

}

export default new DrugService();
