import { useRouter } from 'next/router'
import axios from 'axios';


const bk_url = process.env.BACKEND_URL
// const bk_url = "http://localhost:8080"
const DRUGS_REST_API_URL = "http://backend:8080/api/drugs";
class DrugService {
  //drugs

  async getDrugs() {

    try {
      const response = await fetch(DRUGS_REST_API_URL)
      console.log(response, "⚡")
      return await response;
    }
    catch (err) {
      console.log(err)
      throw (err)
    }

  }
  async getDrugById(drugId) {
    try {

      const response = await axios.get(`http://backend:8080/api/drugs/drugId/${drugId}`);
      console.log(response, "⚡getDrugById⚡")
      return response;
    }
    catch (err) {
      console.log(err, "🚚🚒🚒🚑🚛🚚🛴")
      console.log(err.request, "💥💌💌💌💥💢")
      throw (err)
    }
  }
  async getDrugByPatientId(patientId) {
    const response = await fetch(DRUGS_REST_API_URL + "/patientId/" + patientId).catch(err => console.log(err));
    console.log(bk_url, "getDrugByPatientId")
    return await response.json();
  }
  async getDrugByDrugUsage(drugUsage) {
    const response = await fetch(DRUGS_REST_API_URL + "/drugUsage/" + drugUsage).catch(err => console.log(err));
    console.log(bk_url, "getDrugByDrugUsage")
    return await response.json();
  }
  async getDrugByDrugName(drugName) {
    const response = await fetch(DRUGS_REST_API_URL + "/drugName/" + drugName).catch(err => console.log(err));
    console.log(bk_url, "getDrugByDrugName")
    return await response.json();
  }
  async getDrugByDrugSupplierId(drugSupplierId) {
    const response = await fetch(DRUGS_REST_API_URL + "/drugSupplierId/" + drugSupplierId).catch(err => console.log(err));
    console.log(bk_url, "getDrugByDrugSupplierId")
    return await response.json();
  }
  async createDrug(drug) {
    const response = await fetch(DRUGS_REST_API_URL, { method: "POST", body: JSON.stringify(drug), headers: { "Content-Type": "application/json" } }).catch(err => console.log(err));
    console.log(response, "post_request_drug")
    return await response.json();
    // return axios.post(DRUGS_REST_API_URL, drug);
  }

  async updateDrug(drugId, drug) {
    const response = await fetch(DRUGS_REST_API_URL + "/drugId/" + drugId, { method: "PUT", body: JSON.stringify(drug), headers: { "Content-Type": "application/json" } }).catch(err => console.log(err));
    console.log(response, "update_request_drug")
    return await response.json();

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

    // try {
    //   const response = await fetch(DRUGS_REST_API_URL + "/drugId/" + drugId, { method: "DELETE" })
    //   console.log(response, "⚡delete_request_drug⚡")
    // }
    // catch (err) {
    //   console.log(err)
    //   throw (err)
    // }

  }

}

export default new DrugService();
