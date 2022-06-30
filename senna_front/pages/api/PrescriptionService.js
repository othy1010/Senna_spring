import axios from "axios";

const PRESCRIPTIONS_REST_API_URL = "http://localhost:8080/api/prescriptions";

class PrescriptionService {
  //prescriptions
  getPrescriptions() {
    return axios.get(PRESCRIPTIONS_REST_API_URL);
  }
  getPrescriptionById(prescriptionId) {
    return axios.get(PRESCRIPTIONS_REST_API_URL + "/prescriptionId/" + prescriptionId);
  }
  getPrescriptionByPatientId(patientId) {
    return axios.get(PRESCRIPTIONS_REST_API_URL + "/patientId/" + patientId);
  }
  getPrescriptionByDoctorId(doctorId) {
    return axios.get(PRESCRIPTIONS_REST_API_URL + "/doctorId/" + doctorId);
  }
  createPrescription(prescription) {
    return axios.post(PRESCRIPTIONS_REST_API_URL, prescription);
  }
  updatePrescription(prescriptionId, prescription) {
    return axios.put(PRESCRIPTIONS_REST_API_URL + "/prescriptionId/" + prescriptionId, prescription);
  }
  deletePrescription(prescriptionId) {
    return axios.delete(PRESCRIPTIONS_REST_API_URL + "/prescriptionId/" + prescriptionId);
  }

}

export default new PrescriptionService();
