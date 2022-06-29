
import { useState } from 'react'


function DrugCreation({ detail }) {
   const [state, setState] = useState({
      drugName: detail ? detail.drugName : "",
      drugDescription: detail ? detail.drugDescription : "",
      drugPrice: detail ? detail.drugPrice : "",
      drugQuantity: detail ? detail.drugQuantity : "",
      drugCreatedAt: "",
      drugStock: detail ? detail.drugStock : "",
      needPrescription: detail ? detail.needPrescription : false,
      drugCategoryId: detail ? detail.drugCategoryId : "",
      drugSupplierId: detail ? detail.drugSupplierId : "",
      drugUsage: detail ? detail.drugUsage : "",
      drugWarnings: detail ? detail.drugWarnings : "",
      drugSideEffects: detail ? detail.drugSideEffects : "",
   });
   function handleChange(e) {
      if (e.target.name === 'needPrescription') {
         setState({ ...state, [e.target.name]: e.target.checked })
      } else {
         setState({ ...state, [e.target.name]: e.target.value })
      }
      // setState({ ...state, [e.target.name]: e.target.value });

   }
   const [showModal, setShowModal] = useState(false);
   const submitDrug = (event) => {
      event.preventDefault();
      setShowModal(false)
   }
   async function handleSubmit(e) {
      e.preventDefault();

      let formData = new FormData();

      for (let [key, value] of Object.entries(state)) {
         formData.append(key, value);
         console.log(key, value, `🎈submit Drug 🎈`, formData)
      }
      console.log(`🎈submit Drug 🎈`, formData)
   }

   return (
      <>
         <button
            button type="button" className="justify-center items-center flex ml-auto text-white bg-indigo-500 border-0 py-2 px-6 focus:outline-none hover:bg-indigo-600 rounded"
            onClick={() => setShowModal(true)}
         >
            {detail ? 'Update Drug' : 'Create Drug'}

         </button>
         {showModal ? (
            <>
               <div
                  className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none"
               >
                  <div className="relative w-2/3 m-auto h-2/3 mt-10">
                     {/*content*/}
                     <div className="border-0 rounded-lg shadow-lg relative p-5 flex flex-col w-full bg-white outline-none focus:outline-none">
                        {/*header*/}
                        <div className="flex items-start justify-between p-5 border-b border-solid border-slate-200 rounded-t">
                           <h3 className="text-3xl font-semibold">
                              {detail ? 'Update Drug' : 'Create Drug'}
                           </h3>
                           <button type="button" className="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-toggle="defaultModal">
                              <svg className="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"
                                 onClick={() => setShowModal(false)}><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                           </button>

                        </div>
                        {/*body*/}
                        <form onSubmit={handleSubmit}>
                           <div className="grid gap-6 mb-6 lg:grid-cols-2">
                              <div>
                                 <label for="drugName" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Drug Name</label>
                                 <input type="text" id="drugName" name='drugName' className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="drug Name" onChange={handleChange} value={state.drugName} />
                              </div>
                              <div>
                                 <label for="drugDescription" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Drug Price</label>
                                 <input type="number" id="drugPrice" name='drugPrice' className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="drug Price" onChange={handleChange} value={state.drugPrice} />
                              </div>
                              <div>
                                 <label for="drugQuantity" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Drug Quantity</label>
                                 <input type="number" id="drugQuantity" name='drugQuantity' className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="drug pill quantity" onChange={handleChange} value={state.drugQuantity} />
                              </div>
                              <div>
                                 <label for="drugStock" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Drug Stock</label>
                                 <input type="number" id="drugStock" name="drugStock" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="drug pill stock" onChange={handleChange} value={state.drugStock} />
                              </div>



                              <div >
                                 <label for="drugCategoryId" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-400">Drug Category</label>
                                 <select id="drugCategoryId" name="drugCategoryId" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" onChange={handleChange} value={state.drugCreatedAt}>
                                    <option selected>Chose a Category</option>
                                    <option value="1">category 1</option>
                                    <option value="2">category 2</option>
                                 </select>
                              </div>
                              <div>
                                 <label for="drugSupplierId" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-400">Drug Supplier</label>
                                 <select id="drugSupplierId" name="drugSupplierId" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" onChange={handleChange} value={state.drugSupplierId}>
                                    <option selected>Chose a Supplier</option>
                                    <option value="1">Supplier 1</option>
                                    <option value="2">Supplier 2</option>
                                 </select>
                              </div>
                              <div >
                                 <label for="text" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Drug Usage</label>
                                 <textarea type="text" id="drugUsage" name="drugUsage" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="drug Usage" onChange={handleChange} value={state.drugUsage} />
                              </div>
                              <div>
                                 <label for="drugStock" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Drug Warnings</label>
                                 <textarea type="text" id="drugWarnings" name="drugWarnings" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="drug Warnings" onChange={handleChange} value={state.drugWarnings} />
                              </div>
                              <div>
                                 <label for="drugStock" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Drug Side Effects</label>
                                 <textarea type="text" id="drugSideEffects" name="drugSideEffects" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="drug Side Effects" onChange={handleChange} value={state.drugSideEffects} />
                              </div>
                              <div >


                                 <label for="text" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Drug Description</label>
                                 <textarea type="text" id="drugDescription" name="drugDescription" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="drug Description" onChange={handleChange} value={state.drugDescription} />
                              </div>
                              <div>
                                 <label for="drugStock" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Date</label>
                                 <input type="date" id="drugCreatedAt" name="drugCreatedAt" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="drug Date" onChange={handleChange} value={state.drugCreatedAt} />
                              </div>
                           </div>
                           <div className="flex items-start mb-6">
                              <div className="flex items-center h-5">
                                 <input id="needPrescription" name="needPrescription" type="checkbox" value={state.needPrescription} onChange={handleChange} className="w-4 h-4 bg-gray-50 rounded border border-gray-300 focus:ring-3 focus:ring-blue-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-blue-600 dark:ring-offset-gray-800" />
                              </div>
                              <label for="needPrescription" className="ml-2 text-sm font-medium text-gray-900 dark:text-gray-400">Need a prescription </label>
                           </div>

                        </form>
                        {/*footer*/}
                        <div className="flex items-center justify-end p-6 border-t border-solid border-slate-200 rounded-b">
                           <button type="submit" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" onClick={handleSubmit}>{detail ? 'Update Drug' : 'Create Drug'}</button>
                           <button
                              className="text-red-500 background-transparent font-bold uppercase px-6 py-2 text-sm outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                              type="button"
                              onClick={() => setShowModal(false)}
                           >
                              Close
                           </button>

                        </div>
                     </div>
                  </div>
               </div>
               <div className="opacity-25 fixed inset-0 z-40 bg-black"></div>
            </>
         ) : null}
      </>
   );
}

export default DrugCreation