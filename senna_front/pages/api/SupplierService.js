import axios from "axios";

const SUPPLIERS_REST_API_URL = "http://localhost:8080/api/suppliers";

class SupplierService {
   //suppliers
   getSuppliers() {
      return axios.get(SUPPLIERS_REST_API_URL);
   }
   getSupplierById(supplierId) {
      return axios.get(SUPPLIERS_REST_API_URL + "/supplierId/" + supplierId);
   }
   createSupplier(supplier) {
      return axios.post(SUPPLIERS_REST_API_URL, supplier);
   }
   updatesupplier(supplierId, supplier) {
      return axios.put(SUPPLIERS_REST_API_URL + "/supplierId/" + supplierId, supplier);
   }
   deletesupplier(supplierId) {
      return axios.delete(SUPPLIERS_REST_API_URL + "/supplierId/" + supplierId);
   }

}

export default new SupplierService();
